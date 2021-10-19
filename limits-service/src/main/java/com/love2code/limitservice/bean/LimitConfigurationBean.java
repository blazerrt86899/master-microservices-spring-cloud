package com.love2code.limitservice.bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfigurationBean {
	private int maximum;
	private int minimum;

}
