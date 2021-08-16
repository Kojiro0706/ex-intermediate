package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * プロ野球チーム情報の操作を行うサービスクラス.
 * @author kojiro0706
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	/**
	 * プロ野球チーム情報を全件取得するメソッド.
	 * @return プロ野球チーム情報
	 */
	public List<Team> showList() {
		return teamRepository.findAll();
	}

	/**
	 * プロ野球チーム情報を一件取得するメソッド.
	 * @param id
	 * @return プロ野球チーム情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}
}
