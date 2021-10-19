package com.love2code.limitservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.limitservice.bean.LimitConfigurationBean;
import com.love2code.limitservice.configuration.LimitsConfiguration;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/config")
@AllArgsConstructor
public class LimitsConfigController {
	
	private final LimitsConfiguration configuration;

	@GetMapping("/limits")
	public LimitConfigurationBean retrieveLimitsFromConfiguration() {
		return new LimitConfigurationBean(configuration.getMaximum(), 
				configuration.getMinimum());
	}
}
