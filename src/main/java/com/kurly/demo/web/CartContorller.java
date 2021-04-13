package com.kurly.demo.web;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.service.CartService;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartContorller {

    private final CartService cartService;

    @PostMapping("/cart")
    @ResponseBody
    public void save(HttpSession session, CartRequestDto requestDto) {

        //(Long)session.getAttribute("id")
        cartService.save(1L,requestDto);

    }

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {

        //(Long)session.getAttribute("id")
        Long UserId = 1L;
        model.addAttribute("carts", cartService.findByUserId(UserId));

       return "cart/cart";
    }

    @DeleteMapping("/cart")
    @ResponseBody
    public void delete(@RequestParam Long cartId) {
        System.out.println(cartId);
        cartService.delete(cartId);

    }

}
