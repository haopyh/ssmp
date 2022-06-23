package com.haopyh.ssmp.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("books")
public class Book implements Serializable {
    private static final long serialVersionUID = -9220808989184976451L;
    private Integer id;
    private String title; //书名
    private String author; //作者
    private Double price; //价格
    private Integer sales; //销量
    private Integer stock; //库存
    private String imgPath = "static/img/default.jpg"; //封面图片的路径
}