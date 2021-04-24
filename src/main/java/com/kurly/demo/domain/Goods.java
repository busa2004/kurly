package com.kurly.demo.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("GoodsInfo")
//@JsonIgnoreProperties(value={"description"})
public class Goods {

    @Id
    @GeneratedValue
    @Column(name = "goods_id")
    private Long id;

    private String img;
    private int price;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요")
    private String name;

    //@JsonIgnore
    private String description;

}
