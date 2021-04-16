package com.kurly.demo.domain;

import lombok.Builder;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "order_goods")
@Builder
@Setter
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


    public static List<OrderGoods> createOrderGoods(List<Cart> carts) {
        List<OrderGoods> orderGoods = new ArrayList<OrderGoods>();
        for (Cart cart : carts){
            orderGoods.add(OrderGoods.builder().goods(cart.getGoods()).count(cart.getCount()).build());
        }
        return orderGoods;

    }
}
