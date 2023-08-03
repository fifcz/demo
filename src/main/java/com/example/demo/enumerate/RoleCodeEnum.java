package com.example.demo.enumerate;

public enum RoleCodeEnum {
    SUPER_SYSTEM("1","超级管理员"),
    OPERATION_SYSTEM("2","系统管理员"),
    OPERATION_SUB_SYSTEM("3", "子管理员"),
    NORMAL("4", "正常")
    ;
    private  String code;
    private String msg;
    RoleCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
