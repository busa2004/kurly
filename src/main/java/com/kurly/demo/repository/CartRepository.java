package com.kurly.demo.repository;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
