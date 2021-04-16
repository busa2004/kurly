package com.kurly.demo.web;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.service.CartService;
import com.kurly.demo.service.OrderService;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final CartService cartService;

    @PostMapping
    public String save(HttpSession session) {
        orderService.save((Long)session.getAttribute("id"));
        return "redirect:/";
    }

    @GetMapping
    public String order(HttpSession session, Model model) {
        model.addAttribute("carts", cartService.findByUserId((Long)session.getAttribute("id")));

        return "order/order";
    }


}
