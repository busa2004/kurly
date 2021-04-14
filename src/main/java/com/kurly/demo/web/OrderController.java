package com.kurly.demo.web;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.service.CartService;
import com.kurly.demo.service.OrderService;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseBody
    public void save(HttpSession session, List<Cart> carts) {
        orderService.save((Long)session.getAttribute("id"),carts);
    }

}
