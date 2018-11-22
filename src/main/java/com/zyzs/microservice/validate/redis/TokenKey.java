package com.zyzs.microservice.validate.redis;

public class TokenKey extends BasePrefix{

	private TokenKey( int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static TokenKey token = new TokenKey(3600*1, "token:");
}
