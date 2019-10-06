/**
 * 
 */
package com.assesment.retailstoreservice.service;

import com.assesment.retailstoreservice.model.ProductDetails;

/**
 * @author mukeshgehani
 *
 */
public interface CartService {
	
	Double totalBill();
	void addProduct(ProductDetails productDetails);
	void addProduct(ProductDetails productDetails,Integer quantity);

}
