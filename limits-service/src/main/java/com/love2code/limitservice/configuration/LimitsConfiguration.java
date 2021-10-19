package com.love2code.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("limits-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitsConfiguration {
	private int minimum;
	private int maximum;
}
