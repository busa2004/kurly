package com.kurly.demo.web.api;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kurly.demo.domain.Cart;
import com.kurly.demo.domain.Goods;
import com.kurly.demo.domain.Order;
import com.kurly.demo.domain.OrderGoods;
import com.kurly.demo.service.CartService;
import com.kurly.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping("/v1/orders/{userId}")
    public MappingJacksonValue retrieveAllOrderByUserId(@PathVariable Long userId) {
      List<Order> orders = orderService.findOrderByUserId(userId);

      SimpleBeanPropertyFilter orderFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","orderGoods","delivery","orderDate","status");

      SimpleBeanPropertyFilter deliveryFilter = SimpleBeanPropertyFilter
            .filterOutAllExcept("id","address","status");

      SimpleBeanPropertyFilter orderGoodsFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","goods","count");

      SimpleBeanPropertyFilter goodsFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","img","price","name");

      FilterProvider filters = new SimpleFilterProvider()
                .addFilter("OrderInfo",orderFilter)
                .addFilter("DeliveryInfo",deliveryFilter)
                .addFilter("OrderGoodsInfo",orderGoodsFilter)
                .addFilter("GoodsInfo",goodsFilter);
      MappingJacksonValue mapping = new MappingJacksonValue(orders);
      mapping.setFilters(filters);


      return mapping;

    }


}
