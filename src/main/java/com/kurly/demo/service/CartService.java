package com.kurly.demo.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.kurly.demo.domain.Cart;
import com.kurly.demo.domain.Goods;
import com.kurly.demo.domain.User;
import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.repository.GoodsRepository;
import com.kurly.demo.repository.UserRepository;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final GoodsRepository goodsRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(Long userId, CartRequestDto requestDto) {

        Optional<User> user = userRepository.findById(userId);
        Goods goods = goodsRepository.findOne(requestDto.getGoodsId());
        cartRepository.save(Cart.builder().user(user.get()).goods(goods).count(requestDto.getCount()).build());

    }

}
