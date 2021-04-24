package com.kurly.demo.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("GoodsInfoV2")
@Setter
public class GoodsV2 extends Goods{

    private String storage;

}
