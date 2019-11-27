package com.nf.shopproject.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private Map<Integer,CartItem> carts=new HashMap();
	//�����Ʒ�����ﳵ
	public void addCartItem(CartItem item) {
		CartItem itemInCart =carts.get(item.getPrt_specification().getPk_id());
		//������ﳵ���ж���,����ԭ�������Ļ����ϼ�,���ڵ�����,
		//���� ,����Ʒ�ŵ����ﳵ��.
		if(itemInCart!=null) {
			itemInCart.setCount(itemInCart.getCount()+item.getCount());
		}else {
			carts.put(item.getPrt_specification().getPk_id(),item);
		}				
	}
	//${cart.items}���ڱ������ﳵ������ֵ
	public List<CartItem> getItems(){
		return new ArrayList<CartItem>(carts.values());
	}
	//������
	public int getItemCount() {
		int total=0;
		for(CartItem item:carts.values()) {
			total+= item.getCount();//�ѹ��ﳵ���С�Ƽ�����
		}
		return  total;
	}
	//�Ƴ�ĳ����Ʒ��һ������
		public void removeItems(Integer id, Integer count) {
			CartItem itemInCart=carts.get(id);
			if(itemInCart==null) {
				return ;
			}
			//�������ԭ����,�����������
			Integer newValue=itemInCart.getCount()-count;
			//����<=0���Ƴ�
			if(newValue<=0) {
				carts.remove(id);
			}else {
				itemInCart.setCount(newValue);
			}
		}
	//�Ƴ�һ����Ʒ
	public void removeItems(Integer id) {
		CartItem itemInCart=carts.get(id);
		if(itemInCart==null) {
			return ;
		}
		carts.remove(id);
	}
	//�ܼ۸�
	public BigDecimal getTotal() {
		BigDecimal total=new BigDecimal(0);
		for(CartItem item:carts.values()){
			total=total.add(item.getSubTotal());
		}
		return total;
	}
}
