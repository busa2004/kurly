package com.kurly.demo.service;

import com.kurly.demo.domain.*;
import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.repository.GoodsRepository;
import com.kurly.demo.repository.OrderRepository;
import com.kurly.demo.repository.UserRepository;
import com.kurly.demo.web.dto.CartRequestDto;
import com.kurly.demo.web.dto.OrderRequestDto;
import com.kurly.demo.web.dto.OrderResponseDto;
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
    public void save(Long userId, OrderRequestDto orderRequestDto) {

        Optional<User> user = userRepository.findById(userId);
        List<Cart> carts = cartRepository.findByUserId(userId);

        Delivery delivery = new Delivery();
        delivery.setAddress(orderRequestDto.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        List<OrderGoods> orderGoods = OrderGoods.createOrderGoods(carts);
        Order order = Order.createOrder(orderGoods,user,delivery);
        orderRepository.save(order);
        cartRepository.deleteByUserId(userId);

    }

    public List<OrderResponseDto> findByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return OrderResponseDto.createOrderResponseDtos(orders);
    }
}
