package com.nf.shopproject.service;

import java.util.List;

import com.nf.shopproject.dao.StoreDao;
import com.nf.shopproject.entity.Store;

public class StoreService {
	StoreDao storeDao=new StoreDao();
	public List<Store> listAll(){
		return storeDao.listAll();
	}
}
