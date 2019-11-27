package com.nf.shopproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.nf.shopproject.entity.Product;

public class ProductDao extends BaseDao{
	/**
	 * 查询全部商品
	 * @return
	 */
	public List<Product> getAll(){
	    String sql = "select * from product";
	    BeanListHandler<Product> handler = new BeanListHandler<>(Product.class);
	    List<Product> products =  queryRunner.query(sql, handler);
	    return  products;
	}
	//id查询
	public Product getById(Integer pid){
		String sql="select * from product where pk_pid=?";
		BeanHandler<Product> product=new BeanHandler<>(Product.class);
		Product result=queryRunner.query(sql, product, pid);
		return result;
	}		
	/**
	 * 添加操作
	 * 时间为默认
	 * @param product
	 * @return
	 */
	public  boolean insert(Product product){
        String sql = "insert into product(pname,original_price,images,about,remark) values(?,?,?,?,?)";
        int affectedRows = queryRunner.modify(sql,product.getPname(),
                product.getOriginal_price(),
                product.getImages(),
                product.getAbout(),
                product.getRemark());
        return  affectedRows == 1 ? true : false;
    }
	/**
	 * 根据商品id删除商品
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id) {
		String sql="delete product where pk_pid = ? ";
		int affectedRows = queryRunner.modify(sql, id);
	    return  affectedRows == 1 ? true : false;
	}
	/**
	 * 商品修改操作
	 * 名称,价格,图片,简介
	 * @param product
	 * @return
	 */
	public boolean update(Product product) {
		String sql="update product set pname=? ,original_price=?, "
				+"images=?, about=?, remark=? where pk_pid=?";
		int affectedRows = queryRunner.modify(sql,product.getPname(),
                product.getOriginal_price(),
                product.getImages(),
                product.getAbout(),
                product.getRemark(),
                product.getPk_pid());
		return affectedRows == 1 ? true : false;
	}
	/**
	 * 分页条件查询
	 * @param conditions 这里key放字段名，value放置字段的值。
	 * @param offset 
	 * @param count
	 * @return
	 */
	public List<Product> getProductByCondition(Map<String,Object>conditions,int offset,int count){
//		String sql=getSqlByCondition("select * from(select ROW_NUMBER() over(order by pk_pid) as rowNo," + 
//				"* from product where 1=1",conditions)+")as p where rowNo between ? and ? ";
				String sql = getSqlByCondition("select * from(select ROW_NUMBER()over(order by pk_pid) as rowNo,"
				+ " c.cname 类型名称,c.pk_cid, a.cid ,a.pid, p.pk_pid, p.pname , p.original_price ,p.images, p.about ,p.create_time ,p.remark "
				+ "from category "
				+ "c Inner Join category_association a on c.pk_cid=a.cid "
				+ "inner join product p on p.pk_pid=a.pid where 1=1",conditions)+")as p where rowNo between ? and ?";
		BeanListHandler<Product> handler=new BeanListHandler<>(Product.class);
		List<Object> list=new ArrayList<Object>();//这里用一个集合来装参数
		for(Object j:conditions.values().toArray()) {
			list.add(j);
		}
			list.add(offset);
			list.add(count);
		List<Product> product=queryRunner.query(sql, handler, list.toArray());
		return product;
	}
	//统计数量
	public int getProductsCountByCondition(Map<String,Object> conditions) {
		//String sql=getSqlByCondition("select Count(*) from category_association where 1=1",conditions);//select Count(*) from category_association where 1=1 and cid=1/select Count(*) from product where 1=1
		String sql=getSqlByCondition("select Count(*) from  category_association a\r\n" + 
				"inner join product p on p.pk_pid=a.pid where 1=1", conditions);
		ScalarHandler<Integer> handler=new ScalarHandler<>();
		int rows=Integer.valueOf(queryRunner.query(sql, handler, conditions.values().toArray()).toString());
		return rows;
	}
	
	//分页查询
	public List<Product> getPagedRecords(int start, int end){
		String sql="select * from(select ROW_NUMBER() over(order by pk_pid) as rowNo, * from product) as p where rowNo between ? and ? ";
		BeanListHandler<Product> beanListHandler =new BeanListHandler<>(Product.class);
		List<Product> result = queryRunner.query(sql, beanListHandler,start,end);
		return result;
	}		
	//总页数
	public int getRecordCount(){
		String sql="select Count(*) from product";
		ScalarHandler<Integer> handler=new ScalarHandler<>();
		Integer result=Integer.valueOf(queryRunner.query(sql, handler).toString());
		return result;
	}	
}