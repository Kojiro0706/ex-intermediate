package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテル情報を操作するリポジトリ.
 * 
 * @author kojiro0706
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

	/**
	 * ホテル情報を全件検索する.
	 * 
	 * @return ホテル情報
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels";

		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);

		return hotelList;
	}
	
	/**
	 * 入力された値以下のホテルを検索する.
	 * 
	 * @return ホテル情報
	 */
	public List<Hotel> searchBylessThanPrice(Integer price){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking " 
	               + "FROM hotels WHERE price <= :price";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
		
		return template.query(sql, param, HOTEL_ROW_MAPPER);

	}
}
