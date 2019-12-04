package com.bobo.store.service;

import com.bobo.store.domain.Shop;
import com.github.pagehelper.PageInfo;

public interface ShopService {
	/**
	 * 
	 * @Title: select
	 * @Description: 单个查询
	 * @param sid
	 * @return
	 * @return: Shop
	 */
  Shop select(Integer sid);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加店铺及其售卖商品
	 * @param shop
	 * @param gids
	 * @return
	 * @return: boolean
	 */
	boolean insert(Shop shop,Integer [] gids);
	
	

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param sname 商铺名称
	 * @param gids 商品的ID 的数组
	 * @return
	 * @return: List<Shop>
	 */
	PageInfo<Shop> selects(String sname,Integer[] gids,Integer page,Integer pageSize);
}
