package com.tim.common.test.string;

import java.util.UUID;

public class TestString {
	
	public static void main(String[] args) throws Exception {
		String date = "20120607";
		int a = 5;
		System.out.println(date + a);
		System.out.println(date.charAt(0));
		String result = "(" + date.substring(0, 4) + "年" + date.substring(4, 6) + "月" + date.substring(6,8) + "日)";
		System.out.println(result);
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println(date.substring(3,date.length()));
		
		String s = "item.api.response.QueryItemListInfoRsp item.service.ItemService.queryItemListInfo(item.api.request.QueryItemListInfoReq) throws java.lang.Exception";
		s = s.replaceAll(".*Rsp ", "").replaceAll("\\(.*", "");
		System.out.println(s);
		
		String ss = "123456";
		System.out.println(Long.parseLong(ss));
		System.out.println(UUID.randomUUID().toString());
		
		System.out.println("转义开始测试：" + "abc\tde\refg");

		String test = "{\"TB2pbrIsXXXXXXUXXXXXXXXXXXX_!!0-taoxiaopu_sell.jpg\":{\"flag\":\"hr_interrupt\"}}";
		System.out.println("test=" + test);
		System.out.println("test=" + test.replace("\"hr_interrupt\"","\"interrupt\""));

        System.out.println("".hashCode());
    }
}
