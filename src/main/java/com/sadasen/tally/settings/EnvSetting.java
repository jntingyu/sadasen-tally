package com.sadasen.tally.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @date 2018年9月15日
 * @author lei.ys
 * @addr home
 * @desc
 */
@Component
public class EnvSetting {
	
	@Value("${env.test:false}")
	private boolean test;
	
	public EnvSetting() {
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

}
