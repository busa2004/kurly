package com.kurly.demo.service;

import com.kurly.demo.domain.*;
import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.repository.GoodsRepository;
import com.kurly.demo.repository.OrderRepository;
import com.kurly.demo.repository.UserRepository;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;
    private final CartRepository cartRepository;

    @Transactional
    public void save(Long userId, List<Cart> carts) {

        Optional<User> user = userRepository.findById(userId);
        Order order = Order.builder().user(user.get()).build();

        for (Cart cart : carts){
            Goods goods = goodsRepository.findOne(cart.getGoods().getId());
            OrderGoods.builder()
                    .goods(goods)
                    .order(order)
                    .count(cart.getCount());
        }

        cartRepository.deleteByUserId(userId);

    }

}
