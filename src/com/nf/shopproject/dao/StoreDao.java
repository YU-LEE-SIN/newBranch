package com.nf.shopproject.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.nf.shopproject.entity.Store;

public class StoreDao extends BaseDao{
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Store> listAll(){
		String sql="select * from store";
		BeanListHandler<Store> beanListHandler =new BeanListHandler<>(Store.class);
		List<Store> result=queryRunner.query(sql,beanListHandler);
		return result;
	}
	/**
	 * ��Ӳ���
	 * @param store
	 * @return
	 */
	public boolean insert(Store store) {
		String sql="insert into store values(?)";
		int affectedRows = queryRunner.modify(sql, store.getSname());
		return affectedRows == 1 ? true : false;
	}
	/**
	 * ɾ������
	 * @param store
	 * @return
	 */
	public boolean deleteById(Integer id) {
		String sql="delete store where pk_sid=?";
		int affectedRows = queryRunner.modify(sql, id);
		return  affectedRows == 1 ? true : false;
	} 
	/**
	 * �޸Ĳ���
	 * @param store
	 * @return
	 */
	public boolean update(Store store) {
		String sql="update Store set sname=? where pk_sid = ?";
		int affectedRows = queryRunner.modify(sql, store.getSname());
		return affectedRows == 1 ? true : false;
	}
}
