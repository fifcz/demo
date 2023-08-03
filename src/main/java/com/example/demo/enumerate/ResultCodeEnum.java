package com.example.demo.enumerate;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS("0000", "成功")
    ;
    private String code;
    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
