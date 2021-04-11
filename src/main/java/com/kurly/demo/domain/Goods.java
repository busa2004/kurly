package com.kurly.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Goods {

    @Id
    @GeneratedValue
    @Column(name = "goods_id")
    private Long id;
    private String img;
    private int price;
    private String name;
    private String desc;

}
