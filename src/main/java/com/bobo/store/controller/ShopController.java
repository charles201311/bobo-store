package com.bobo.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.store.domain.Goods;
import com.bobo.store.domain.Shop;
import com.bobo.store.service.GoodsService;
import com.bobo.store.service.ShopService;
import com.github.pagehelper.PageInfo;

@Controller
public class ShopController {

	//1222222222
///3333
	@Resource
	private ShopService shopService;

	@Resource
	private GoodsService goodsService;

	@RequestMapping("selects")
	public String selects(Model model, @RequestParam(defaultValue = "") String sname, Integer[] gids,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer pageSize) {

		PageInfo<Shop> info = shopService.selects(sname, gids, page, pageSize);

		model.addAttribute("info", info);
		model.addAttribute("sname", sname);
		String str = "";
		if (null != gids && gids.length > 0) {
			
			for (Integer i : gids) {
				str += i+",";
			}
		}
		//str="1,2,3,"
		model.addAttribute("str", str);
		return "selects";

	}

	@ResponseBody
	@RequestMapping("selectGoods")
	public List<Goods> selectGoods() {
		return goodsService.selects();
	}
	/**
	 * 
	 * @Title: add 
	 * @Description:跳转到增加页面
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(Model model) {
		
		 List<Goods> goods = goodsService.selects();
		 model.addAttribute("goods", goods);
		
		return "add";
		
	}
	
	
	@ResponseBody
	@RequestMapping("deleteBatch")
	public boolean deleteBatch(@RequestParam("ids[]") Integer[] ids) {
		
		
		return true;
		
	}
	
	/**
	 * 
	 * @Title: add 
	 * @Description:跳转到增加页面
	 * @return
	 * @return: String
	 */
	@PostMapping("add")
	public String add(Shop shop,Integer[] gids) {
		shopService.insert(shop, gids);
		return "redirect:/selects";
		
	}
	/**
	 * 
	 * @Title: select 
	 * @Description: 单个查询
	 * @param model
	 * @param sid
	 * @return
	 * @return: String
	 */
	@GetMapping("select")
	public String select(Model model,Integer sid) {
		
		Shop shop = shopService.select(sid);
		model.addAttribute("shop", shop);
		return "select";
	}
}
