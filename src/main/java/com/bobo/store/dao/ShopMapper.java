package com.bobo.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bobo.store.domain.Shop;
/**
 * 
 * @ClassName: ShopMapper 
 * @Description: TODO
 * @author: charles
 * @date: 2019年12月2日 上午9:16:47
 */
public interface ShopMapper {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加店铺
	 * @param shop
	 * @return
	 * @return: int
	 */
	int insert(Shop shop);
	
	/**
	 * 
	 * @Title: insertMiddle 
	 * @Description: 中间表
	 * @param sid
	 * @param gid
	 * @return
	 * @return: int
	 */
	int insertMiddle(@Param("sid")Integer sid,@Param("gid")Integer gid);

	/**
	 * 
	 * @Title: selects 
	 * @Description: TODO
	 * @param sname 商铺名称
	 * @param gids 商品的ID 的数组
	 * @return
	 * @return: List<Shop>
	 */
	List<Shop> selects(@Param("sname")String sname,@Param("gids")Integer[] gids);
	
	/**
	 * 
	 * @Title: select
	 * @Description: 单个查询
	 * @param sid
	 * @return
	 * @return: Shop
	 */
  Shop select(Integer sid);
	
}
