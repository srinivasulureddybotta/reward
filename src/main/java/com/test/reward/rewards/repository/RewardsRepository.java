package com.test.reward.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.reward.rewards.repository.model.Rewards;

public interface RewardsRepository extends JpaRepository<Rewards, Long> {

}
