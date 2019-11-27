package com.nf.shopproject.controller.text;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nf.shopproject.entity.Cart;

public class CartText {
	private Map<Integer,CartItemText> carts=new HashMap();
	
	public void addCartItem(CartItemText item) {
		CartItemText itemInCart=carts.get(item.getPrt_specification().getPk_id());//map�ļ�����Ʒid
		if(itemInCart!=null) {
			itemInCart.setCount(itemInCart.getCount()+item.getCount());
		}else {
			carts.put(item.getPrt_specification().getPk_id(), item);
		}
	}
	//${cart.items}���ڱ������ﳵ������ֵ
		public List<CartItemText> getItems(){
			return new ArrayList<CartItemText>(carts.values());
	}
	//������
	public int getItemCount() {
		int total=0;
		for(CartItemText item:carts.values()) {
			total+= item.getCount();//�ѹ��ﳵ���С�Ƽ�����
		}
		return  total;
	}
	//�Ƴ�ĳ����Ʒ��һ������
	public void removeItems(Integer id, Integer count) {
		CartItemText itemInCart=carts.get(id);
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
			CartItemText itemInCart=carts.get(id);
			if(itemInCart==null) {
				return ;
			}
			carts.remove(id);
		}
		//�ܼ۸�
		public BigDecimal getTotal() {
			BigDecimal total=new BigDecimal(0);
			for(CartItemText item:carts.values()){
				total=total.add(item.getSubTotal());
			}
			return total;
		}
}
