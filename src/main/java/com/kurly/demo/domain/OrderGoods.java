package com.kurly.demo.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "order_goods")
public class OrderGoods {

    @Id
    @GeneratedValue
    @Column(name = "order_goods_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; //주문

    private int count; //주문 수량

    @Builder
    public OrderGoods(Goods goods, Order order, int count){
        this.goods = goods;
        this.order = order;
        this.count = count;
    }
}
