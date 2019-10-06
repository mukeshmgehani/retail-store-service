/**
 * 
 */
package com.assesment.retailstoreservice.model;

/**
 * @author mukeshgehani
 *
 */
public interface ProductDetails {
	
	Double getPrice();
	String getName();
	ProductType getProductType();
	Double getPriceForQuantity(Integer quantity);

}
