package com.kurly.demo.web;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.service.CartService;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping
    @ResponseBody
    public void save(HttpSession session, CartRequestDto requestDto) {
        cartService.save((Long)session.getAttribute("id"),requestDto);
    }

    @GetMapping
    public String cart(HttpSession session, Model model) {

        //(Long)session.getAttribute("id")
        Long UserId = (Long)session.getAttribute("id");
        model.addAttribute("carts", cartService.findByUserId(UserId));

       return "cart/cart";
    }

    @DeleteMapping("/{cartId}")
    @ResponseBody
    public void delete(@PathVariable Long cartId) {
        System.out.println(cartId);
        cartService.delete(cartId);

    }

}
