package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * プロ野球チーム情報を操作するコントローラー.
 * 
 * @author kojiro0706
 *
 */
@Controller
@RequestMapping("")
public class TeamController {

	@Autowired
	private TeamService teamService;

	/**
	 * プロ野球チームを全件表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return プロ野球チーム情報
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();

		model.addAttribute("teamList", teamList);

		return "teamlist";
	}

	/**
	 * プロ野球チームの詳細を表示する.
	 * 
	 * @param id    プロ野球チームID
	 * @param model リクエストスコープ
	 * @return プロ野球チーム情報
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {

		Team team = teamService.showDetail(id);

		model.addAttribute("team", team);

		return "showdetail";
	}

}
