/**
 * 
 */
package com.digitexx.ancestry.util;

import java.util.Properties;

/**
 * @author lqnhu
 * 
 */
public class Config {
	Properties configFile;

	public Config(String path , Class<?> clazz) {
		configFile = new java.util.Properties();
		try {
			configFile.load(clazz.getClass().getClassLoader().getResourceAsStream(path));
		} catch (Exception eta) {
			eta.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = this.configFile.getProperty(key);
		return value;
	}
}
