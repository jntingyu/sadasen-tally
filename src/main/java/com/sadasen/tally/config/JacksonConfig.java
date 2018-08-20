package com.sadasen.tally.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadasen.tally.ext.ObjectMapperExt;

/**
 * @date 2018年8月19日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Configuration
public class JacksonConfig {
	
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapperExt();
		return mapper;
	}

}
