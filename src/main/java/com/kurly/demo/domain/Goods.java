package com.kurly.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class Goods {

    @Id
    @GeneratedValue
    @Column(name = "goods_id")
    private Long id;

    private String img;
    private int price;
    private String name;
    private String description;

    @Builder
    public Goods(String img, int price, String name,String description){
        this.img = img;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
