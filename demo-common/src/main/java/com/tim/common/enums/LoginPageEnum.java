package com.tim.common.enums;

/**
 * Enum的标准定义格式
 * Created by tim.syh on 2016/11/29.
 */
public enum LoginPageEnum {
    LOGIN(1,"登录"),
    MOBILE_REG(2, "手机注册"),
    MOBILE_FWD(3, "手机找密"),
//    EMAIL_REG_STEP1(4),
//    EMAIL_REG_STEP2(5),
//    EMAIL_FWD_STEP1(6),
    EMAIL_FWD_STEP2(7, "邮件找密");

    private int code;
    private String desc;

    private LoginPageEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static LoginPageEnum getEnumByPageType(int pageType) {
        for (LoginPageEnum data : values()) {
            if (data.getCode() == pageType) {
                return data;
            }
        }
        return LOGIN;
    }

    public static LoginPageEnum getEnumByDesc(String desc) {
        for (LoginPageEnum loginPageEnum : values()) {
            if (loginPageEnum.desc.equals(desc)) {
                return loginPageEnum;
            }
        }
        return LOGIN;
    }

    public static void main(String[] args) {
        System.out.println(values()); //
        LoginPageEnum loginPageEnum = getEnumByPageType(6);
        LoginPageEnum loginPageEnum1 = getEnumByDesc("邮件找密");
        System.out.println(loginPageEnum.getCode());
        System.out.println(MOBILE_REG.name());
    }
}
