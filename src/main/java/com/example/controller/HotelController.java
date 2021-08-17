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
	
	@RequestMapping("")
	public String index() {
		return "search-hotel";
	}

	/**
	 * ホテル情報を取得する.
	 * 
	 * @param price PRICE
	 * @param model リクエストスコープ
	 * @return
	 */
	@RequestMapping("/showList")
	public String searchBylessThanPrice(Integer price, Model model) {

		List<Hotel> hotelList = hotelService.searchBylessThanPrice(price);

		model.addAttribute("hotelList", hotelList);

		return "search-hotel";
	}

}
