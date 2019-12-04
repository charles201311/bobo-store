package com.bobo.store.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.store.dao.GoodsMapper;
import com.bobo.store.domain.Goods;
import com.bobo.store.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> selects() {
		return goodsMapper.selects();
	}

}
