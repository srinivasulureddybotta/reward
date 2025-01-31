package com.test.reward.rewards.repository.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rewards")
public class Rewards {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private double Amount;
	
	private Long customerID;
	
	private Date createstamp = new Date();

}
