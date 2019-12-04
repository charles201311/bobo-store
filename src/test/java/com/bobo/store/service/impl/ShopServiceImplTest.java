package com.bobo.store.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bobo.store.domain.Shop;
import com.bobo.store.service.ShopService;
import com.github.pagehelper.PageInfo;

//读取spring的配置文件.并启动sprign容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ShopServiceImplTest {
	
	@Resource
	private ShopService shopService;

	@Test
	public void testSelects() {
		PageInfo<Shop> info = shopService.selects(null, null, 0, 10);
		System.out.println(info.getList());
		
	}

}
