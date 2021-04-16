package com.kurly.demo.repository;

import com.kurly.demo.domain.Cart;
import com.kurly.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);

    @Modifying
    @Query("delete from Cart s where s.user.id = :user_id")
    void deleteByUserId(@Param("user_id") Long userId);
}
