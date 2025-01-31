package com.test.reward.rewards.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.reward.rewards.data.RewardData;
import com.test.reward.rewards.service.RewardsService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

	@Autowired
	public RewardsService rewardsService;

	@PostMapping("/pointsfor3months")
	public Map<Integer, Map<String, Integer>> pointsFor3Months(@RequestBody List<RewardData> rewardsData) {

		return rewardsService.calculateRewards(rewardsData);
	}

	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Success");
	}

}
