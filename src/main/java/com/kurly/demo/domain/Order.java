package com.kurly.demo.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "orders")
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //주문 회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderGoods> orderGoods = new ArrayList<>();


    public void addOrderGoods(OrderGoods og) {
        orderGoods.add(og);
        og.setOrder(this);
    }

    public static Order createOrder(List<OrderGoods> orderGoods, Optional<User> user) {
        Order order = new Order();
        order.setUser(user.get());
        for (OrderGoods og : orderGoods) {
            order.addOrderGoods(og);
        }
        return order;
    }


}
