package com.tim.common.enums;

/**
 * Enum的标准定义格式
 * Created by tim.syh on 2016/11/29.
 */
public enum LoginPageEnum {
    LOGIN(1),
    MOBILE_REG(2),
    MOBILE_FWD(3),
    EMAIL_REG_STEP1(4),
    EMAIL_REG_STEP2(5),
    EMAIL_FWD_STEP1(6),
    EMAIL_FWD_STEP2(7);

    private int code;

    private LoginPageEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public static LoginPageEnum valueOf(int pageType) {
        for (LoginPageEnum data : values()) {
            if (data.getCode() == pageType) {
                return data;
            }
        }
        return LOGIN;
    }

    public static void main(String[] args) {
        LoginPageEnum loginPageEnum = valueOf(6);
        System.out.println(loginPageEnum.getCode());
        System.out.println(loginPageEnum.name());
    }
}
