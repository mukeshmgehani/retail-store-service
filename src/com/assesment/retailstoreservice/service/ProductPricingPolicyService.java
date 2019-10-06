/**
 * 
 */
package com.assesment.retailstoreservice.service;

import com.assesment.retailstoreservice.model.ProductDetails;
import com.assesment.retailstoreservice.model.ProductType;

/**
 * @author mukeshgehani
 * 
 *         This is to implement pricing at product level while generating the
 *         bill from cart
 */
public class ProductPricingPolicyService implements ProductDetails {

	private final ProductDetails productDetails;

	/**
	 * @param productDetails
	 */
	public ProductPricingPolicyService(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public Double getPrice() {
		return productDetails.getPrice();
	}

	@Override
	public String getName() {
		return productDetails.getName();
	}

	@Override
	public ProductType getProductType() {
		return productDetails.getProductType();
	}

	@Override
	public Double getPriceForQuantity(Integer quantity) {
		return productDetails.getPriceForQuantity(quantity);
	}

}
