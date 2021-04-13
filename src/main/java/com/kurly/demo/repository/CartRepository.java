package com.kurly.demo.repository;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);

}
