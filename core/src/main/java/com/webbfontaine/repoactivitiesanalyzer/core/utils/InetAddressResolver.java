package com.webbfontaine.repoactivitiesanalyzer.core.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressResolver {

	private static String[] headersToCheck = new String[]{
		"X-Forwarded-For",
		"Proxy-Client-IP",
		"WL-Proxy-Client-IP",
		"HTTP_X_FORWARDED_FOR",
		"HTTP_X_FORWARDED",
		"HTTP_X_CLUSTER_CLIENT_IP",
		"HTTP_CLIENT_IP",
		"HTTP_FORWARDED_FOR",
		"HTTP_FORWARDED",
		"HTTP_VIA",
		"REMOTE_ADDR"
	};

	public static InetAddress getClientIpAddr(HttpServletRequest request) {
		String ip = null;
		for (int i = 0; i < headersToCheck.length; i++) {
			ip = request.getHeader(headersToCheck[i]);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
				break;
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		try {
			return InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			return null;
		}
	}
}
