package com.order.service;

import java.util.List;

import com.order.entity.Order;

public interface OrderService {
	 
	  public Order createOrder(Order order);

	  public String deleteOrder(String orderid);

	public List<Order> getOrdersByUserid(String userid);

	public Order getOrderId(String orderid);

	public List<Order> getAllOrders();
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public OrderResponse createOrder(Order order) {
//		
//		String cropid=order.getCropid();
//		Crop crop;
//		  try {
//	            crop = restTemplate.getForObject("http://CROP/crop/getById/" + cropid, Crop.class);
//	        } catch (HttpClientErrorException.NotFound notFoundException) {
//	            // Crop not found
//	            return new OrderResponse("Crop Not Found", null, 0.0);
//	        }
//
//	        order.setCost(crop.getPrice());
//	        order.setStatus("Confirmed");
//	        Order savedOrder = ordRepo.save(order);
//
//	        crop.getOrders().add(savedOrder);
//	        restTemplate.put("http://CROP/crop/update", crop);
//
//	        double totalCost = calculateTotalCost(crop.getOrders());
//
//	        return new OrderResponse("Your Order is Placed Successfully, OrderID is: " + savedOrder.getOrderid(), savedOrder.getOrderid(), totalCost);
//	    }
//

//	private double calculateTotalCost(List<Order> orders) {
//		double totalCost = 0.0;
//
//        for (Order order : orders) {
//            totalCost += order.getCost();
//        }
//
//        return totalCost;	
//		
//	}		

//}
