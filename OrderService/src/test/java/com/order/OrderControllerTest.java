package com.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.controller.OrderController;
import com.order.entity.Order;
import com.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

public class OrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setUserid("testUserId");
        order.setCartid("testCartId");

        when(orderService.createOrder(any(Order.class))).thenReturn(order);

        mockMvc.perform(post("/order/create/userid/{userId}/cartid/{cartId}", "testUserId", "testCartId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userid").value("testUserId"))
                .andExpect(jsonPath("$.cartid").value("testCartId"));
    }

 

    @Test
    public void testGetOrderId() throws Exception {
        Order order = new Order();
        order.setUserid("testUserId");
        order.setCartid("testCartId");

        when(orderService.getOrderId("testOrderId")).thenReturn(order);

        mockMvc.perform(get("/order/getById/{orderid}", "testOrderId"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userid").value("testUserId"))
                .andExpect(jsonPath("$.cartid").value("testCartId"));
    }

    @Test
    public void testDeleteOrder() throws Exception {
        mockMvc.perform(delete("/order/delete/orderid/{orderId}", "testOrderId"))
                .andExpect(status().isNoContent());
    }
}
