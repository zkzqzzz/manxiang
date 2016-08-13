package com.demo.zk.manxiang.wxpay;

import java.util.List;
import java.util.Random;

public class WeixinUtils {
	
	public static String genNonceStr() {
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
	}
	
	public static long genTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}
	
	public static String sign(List<NameValuePair> params) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < params.size(); i++) {
			sb.append(params.get(i).getName());
			sb.append('=');
			sb.append(params.get(i).getValue());
			sb.append('&');
		}
		sb.append("key=");
		sb.append(WeixinConfig.API_SECRET);
		String packageSign = MD5.md5(sb.toString());
		return packageSign;
	}

}
