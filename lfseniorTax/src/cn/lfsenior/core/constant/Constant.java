package cn.lfsenior.core.constant;

import java.util.HashMap;

public class Constant {
	public static String PRIVILEGE_XZGL="xzgl";
	public static String PRIVILEGE_HQFW="hqfw";
	public static String PRIVILEGE_ZXXX="zxxx";
	public static String PRIVILEGE_NSFW="nsfw";
	public static String PRIVILEGE_SPACE="space";
	
	public static HashMap<String, String> PRIVILEGE_MAP;
	static{
		PRIVILEGE_MAP=new HashMap<String, String>();
		PRIVILEGE_MAP.put(PRIVILEGE_XZGL, "行政管理");
		PRIVILEGE_MAP.put(PRIVILEGE_HQFW, "后勤服务");
		PRIVILEGE_MAP.put(PRIVILEGE_ZXXX, "掌上学习");
		PRIVILEGE_MAP.put(PRIVILEGE_NSFW, "纳税服务");
		PRIVILEGE_MAP.put(PRIVILEGE_SPACE, "我的空间");
	}
}
