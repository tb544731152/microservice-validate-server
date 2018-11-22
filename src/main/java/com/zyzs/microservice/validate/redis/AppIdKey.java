package com.zyzs.microservice.validate.redis;

public class AppIdKey extends BasePrefix {

	public AppIdKey(String prefix) {
		super(prefix);
	}
	public static AppIdKey appid = new AppIdKey("appid:");
}
