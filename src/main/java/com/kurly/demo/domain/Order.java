package com.kurly.demo.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //주문 회원

    @Builder
    public Order(User user){
        this.user = user;
    }
}
