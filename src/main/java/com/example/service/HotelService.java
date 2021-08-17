package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を操作するサービスクラス.
 * 
 * @author kojiro0706
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * ホテル情報を全件取得する.
	 * 
	 * @return ホテル情報
	 */
	public List<Hotel> showList() {
		return hotelRepository.findAll();
	}

	/**
	 * 入力された値以下のホテル情報を取得する.
	 * 
	 * @param price PRICE
	 * @return ホテル情報
	 */
	public List<Hotel> searchBylessThanPrice(Integer price) {

		return hotelRepository.searchBylessThanPrice(price);
	}
}
