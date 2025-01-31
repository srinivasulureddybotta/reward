package com.test.reward.rewards.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.reward.rewards.data.RewardData;

@Service
public class RewardsService {

	public Map<Integer, Map<String, Integer>> calculateRewards(List<RewardData> data) {
		List<Map<String, Object>> rewardsMap = new ArrayList<Map<String, Object>>();
		data.forEach(reward -> {
			double amount = reward.getAmount();
			int points = calculatePoints(amount);

			// Sending response
			Map<String, Object> response = new HashMap<>();
			response.put("customerId", reward.getCustomerId());
			response.put("transactionDate", reward.getTransactionDate());
			response.put("amount", reward.getAmount());
			response.put("rewardPoints", points);
			rewardsMap.add(response);
		});

		// loop rewards map then customerId: keep in the hashMap
		// value need to add rewardPoints in hashmap
		// check months in the request and add in the same month
		Map<Integer, Map<String, Integer>> customerRewards = new HashMap<>();

		for (Map<String, Object> rew : rewardsMap) {

			Long customerIdLong = (Long) rew.get("customerId");
			int customerId = customerIdLong.intValue();

			LocalDate date = (LocalDate) rew.get("transactionDate");

			String month = date.getMonth().toString();

			Integer rewardPoints = (Integer) rew.get("rewardPoints");

			customerRewards.putIfAbsent(customerId, new HashMap<String, Integer>());

			Map<String, Integer> monthlyRewards = customerRewards.get(customerId);

			monthlyRewards.put(month, monthlyRewards.getOrDefault(month, 0) + rewardPoints);
			monthlyRewards.put("total", monthlyRewards.getOrDefault("total", 0) + rewardPoints);

		}

		return customerRewards;
	}

	private int calculatePoints(double amount) {
		int points = 0;
		if (amount > 100) {
			points += (amount - 100) * 2;
			amount = 100;
		}
		if (amount > 50) {
			points += (amount - 50) * 1;
		}
		return points;
	}

}
