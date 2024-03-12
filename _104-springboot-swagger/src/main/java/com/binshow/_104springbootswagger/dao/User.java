package com.binshow._104springbootswagger.dao;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class User {

        @ApiModelProperty("用户id")
        private int id;

        @ApiModelProperty("用户名称")
        private String name;

}
