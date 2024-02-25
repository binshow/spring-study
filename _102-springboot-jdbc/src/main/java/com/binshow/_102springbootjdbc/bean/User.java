package com.binshow._102springbootjdbc.bean;


import lombok.Data;


@Data
public class User {

    private int id;
    private String loginName;
    private String nickName;
    private String passwd;

}
