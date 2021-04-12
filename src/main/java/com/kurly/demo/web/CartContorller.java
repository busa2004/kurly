package com.kurly.demo.web;

import com.kurly.demo.repository.CartRepository;
import com.kurly.demo.service.CartService;
import com.kurly.demo.web.dto.CartRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CartContorller {

    private final CartService cartService;

    @PostMapping("/cart")
    @ResponseBody
    public void save(HttpSession session, CartRequestDto requestDto) {
        cartService.save((Long)session.getAttribute("id"),requestDto);

    }

}
