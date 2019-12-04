package com.bobo.store.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.store.dao.ShopMapper;
import com.bobo.store.domain.Shop;
import com.bobo.store.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopMapper shopMapper;

	@Override
	public PageInfo<Shop> selects(String sname, Integer[] gids, Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);
		List<Shop> list = shopMapper.selects(sname, gids);

		return new PageInfo<Shop>(list);
	}

	@Override
	public boolean insert(Shop shop, Integer[] gids) {

		try {

			// 1.增加店面,并返回店面的主键值
			shopMapper.insert(shop);

			// 2中间表
			for (Integer gid : gids) {
				shopMapper.insertMiddle(shop.getId(), gid);
			}
			
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("增加失败");
		}

	}

	@Override
	public Shop select(Integer sid) {
		// TODO Auto-generated method stub
		return shopMapper.select(sid);
	}

}
