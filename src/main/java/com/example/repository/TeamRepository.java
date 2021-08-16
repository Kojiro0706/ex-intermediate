package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Team> TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);

	
	/**
	 * 全件検索を行う.
	 * 
	 * @return プロ野球チーム情報
	 */
	public List<Team> findAll() {
		String sql = "SELECT id,league_name, team_name, headquarters, inauguration, history"
				+ "FROM teams ORDER BY inauguration;";

		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);

		return teamList;
	}
	
	/**
	 * 主キー検索を行う.
	 * 
	 * @param id
	 * @return プロ野球チーム情報
	 */
	public Team load(Integer id) {
		String sql = "SELECT id,league_name, team_name, headquarters, inauguration, history"
				+ "FROM teams WHERE id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		
		return team;
		
	}

	
}
