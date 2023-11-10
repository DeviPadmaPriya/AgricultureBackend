package com.cart;


import com.cart.controller.CartController;
import com.cart.entity.Cart;
import com.cart.entity.CartItem;
import com.cart.exception.CartNotFoundException;
import com.cart.exception.CropNotFoundException;
import com.cart.service.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartControllerTest {

    @Mock
    private CartServiceImpl cartService;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addToCart_shouldReturnCreated() {
        CartItem cartItem = new CartItem();
        String userId = "testUserId";
        String cropId = "testCropId";
        Cart mockCart = new Cart(); // Mock your Cart object as needed

        when(cartService.addCart(cartItem, userId, cropId)).thenReturn(mockCart);

        ResponseEntity<Object> response = cartController.addToCart(cartItem, userId, cropId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(cartService, times(1)).addCart(cartItem, userId, cropId);
    }

    @Test
    void updateCart_shouldReturnCreated() {
        String cartId = "testCartId";
        Cart cart = new Cart(); // Mock your Cart object as needed

        when(cartService.updateCart(cartId, cart)).thenReturn(cart);

        ResponseEntity<Cart> response = cartController.updateCart(cartId, cart);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(cartService, times(1)).updateCart(cartId, cart);
    }

    @Test
    void getCartByUserId_shouldReturnOk() throws CartNotFoundException {
        String userId = "testUserId";
        Cart mockCart = new Cart(); // Mock your Cart object as needed

        when(cartService.getCartByUserId(userId)).thenReturn(mockCart);

        ResponseEntity<Object> response = cartController.getCartByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(cartService, times(1)).getCartByUserId(userId);
    }

    @Test
    void removeCartItem_shouldReturnOk() throws CartNotFoundException, CropNotFoundException {
        String cartId = "testCartId";
        String cropId = "testCropId";

        doNothing().when(cartService).removeCartItem(cartId, cropId);

        ResponseEntity<String> response = cartController.removeCartItem(cartId, cropId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Item removed successfully.", response.getBody());
        verify(cartService, times(1)).removeCartItem(cartId, cropId);
    }

    @Test
    void deleteCart_shouldReturnOk() {
        String cartId = "testCartId";

        when(cartService.deleteCart(cartId)).thenReturn("cart deleted");

        ResponseEntity<String> response = cartController.deleteCart(cartId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("cart deleted", response.getBody());
        verify(cartService, times(1)).deleteCart(cartId);
    }
}
