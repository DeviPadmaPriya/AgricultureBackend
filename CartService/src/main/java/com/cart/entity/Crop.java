package com.cart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crop {
//
	
	private String cropid;
	private String cropName;
	private String cropType;
	private int quantity;
	private double price;
	private String Location;
	
	
}



       
        
//
//{
//     "cartid":89,
//    "userid":3,
//  "cartItems": [
//    {
//      "cropName": "Apple",
//      "price": 10,
//      "quantity": 5
//    },{
//        "cropName": "Strawberry",
//      "price": 10,
//      "quantity": 3
//    }
//   
//  ]
//}
