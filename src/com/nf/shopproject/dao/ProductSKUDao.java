package com.nf.shopproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.nf.shopproject.entity.ProductSpecification;

public class ProductSKUDao extends BaseDao{

	public List<ProductSpecification> getProductByConditionTwo(Map<String,Object>conditions){
		String sql = getSqlByCondition("select *\r\n" + 
				"from category_association c inner join specification s on  c.cid=s.cid\r\n" + 
				"inner join spec_property sp on sp.pk_id=s.pk_id\r\n" + 
				"inner join prt_specification p on p.pid=c.pid \r\n" + 
				"where 1=1", conditions);
		BeanListHandler<ProductSpecification> handler=new BeanListHandler<>(ProductSpecification.class);
		List<Object> list=new ArrayList<Object>();//这里用一个集合来装参数
		for(Object j:conditions.values().toArray()) {
			list.add(j);
		}
		List<ProductSpecification> productsku=queryRunner.query(sql, handler, list.toArray());
		return productsku;
	}
	//查询规格
	public List<ProductSpecification> getproductBypid(Integer id) {
		String sql="select * from prt_specification where pid = ?";
		BeanListHandler<ProductSpecification> handler = new BeanListHandler<>(ProductSpecification.class);
		List<ProductSpecification> result=queryRunner.query(sql, handler, id);
		return result;
	}
	//查询商品
	public ProductSpecification getproductByid(Integer id) {
		String sql="select * from prt_specification where pk_id = ?";
		BeanHandler<ProductSpecification> handler = new BeanHandler<>(ProductSpecification.class);
		ProductSpecification result=queryRunner.query(sql, handler, id);
		return result;
	}
}
