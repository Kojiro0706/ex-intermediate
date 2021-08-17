package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;



/**
 * ホテル情報を操作するコントローラー.
 * 
 * @author kojiro0706
 *
 */
@Controller
@RequestMapping("/searchHotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	
	/**
	 * ホテル情報を全件取得する.
	 * 
	 * @param model リクエストスコープ
	 * @return　ホテル情報
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Hotel> hotelList = hotelService.showList();

		model.addAttribute("hotelList", hotelList);

		return "search-hotel";
	}

	/**
	 * 入力された値以下のホテル情報を取得する.
	 * 
	 * @param price PRICE
	 * @param model リクエストスコープ
	 * @return
	 */
	@RequestMapping("/searchBylessThanPrice")
	public String searchBylessThanPrice(Integer price, Model model) {

		List<Hotel> hotelList = hotelService.searchBylessThanPrice(price);

		model.addAttribute("hotelList", hotelList);

		return "search-hotel";
	}

}
