package com.kurly.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {

    private Long goodsId;
    private int count;

}
