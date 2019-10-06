/**
 * 
 */
package com.assesment.retailstoreservice;

import com.assesment.retailstoreservice.model.Product;
import com.assesment.retailstoreservice.model.ProductDetails;
import com.assesment.retailstoreservice.model.ProductType;
import com.assesment.retailstoreservice.model.User;
import com.assesment.retailstoreservice.model.UserType;
import com.assesment.retailstoreservice.service.CartService;
import com.assesment.retailstoreservice.service.DiscountPolicyService;
import com.assesment.retailstoreservice.serviceimp.CartServiceImpl;
import com.assesment.retailstoreservice.serviceimp.DiscountPolicyServiceImpl;

/**
 * @author mukeshgehani
 *
 */
public class RetailStoreServiceApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User employee = new User(UserType.EMPLOYEE, "Mukesh");
		ProductDetails groceryProduct = new Product(20D, "Oil", ProductType.GROCERY);
		ProductDetails otherProduct = new Product(100D, "TV", ProductType.OTHER);
		DiscountPolicyService discountPolicyService = new DiscountPolicyServiceImpl();

		CartService cartService = new CartServiceImpl(employee);
		cartService.addProduct(groceryProduct, 3);
		cartService.addProduct(otherProduct, 2);
		/*
		 * Total (20 * 3) + (100 * 2) = 260$ No discount on grocery items = 260 still
		 * After 30% discount on 2 other items is 60$ for 200$ then amount will be 140$
		 * for other items then total amount will be 140+60 = 200$
		 */
		System.out.println(cartService.totalBill());

		CartService cartServiceWithDiscountPolicy = new CartServiceImpl(employee, discountPolicyService);
		cartServiceWithDiscountPolicy.addProduct(groceryProduct, 3);
		cartServiceWithDiscountPolicy.addProduct(otherProduct, 2);
		/*
		 * Total (20 * 3) + (100 * 2) = 260$ No discount on grocery items = 260 still
		 * After 30% discount on 2 other items is 60$ for 200$ then amount will be 140$
		 * for other items then total amount will be 140+60 = 200$ 
		 * After 10 dollars off due to price is $200 = 190$
		 */
		System.out.println(cartServiceWithDiscountPolicy.totalBill());
	}

}
