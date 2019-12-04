package com.bobo.store.domain;

import java.util.List;

public class Shop {
	private Integer id;
	private String name;// 店铺名称
	private String created;// 创建日期
	
	private String gname;//售卖商品
	
	
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
}
