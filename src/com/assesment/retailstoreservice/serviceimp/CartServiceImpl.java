/**
 * 
 */
package com.assesment.retailstoreservice.serviceimp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import com.assesment.retailstoreservice.model.ProductDetails;
import com.assesment.retailstoreservice.model.User;
import com.assesment.retailstoreservice.model.UserType;
import com.assesment.retailstoreservice.service.CartService;
import com.assesment.retailstoreservice.service.DiscountPolicyService;

/**
 * @author mukeshgehani
 *
 */
public class CartServiceImpl implements CartService {

	private Map<ProductDetails, Integer> noOfProductsWithQuantities;
	private DiscountPolicyService discountPolicyService;
	private User user;

	/**
	 * @param user
	 */
	public CartServiceImpl(User user) {
		this.noOfProductsWithQuantities = new LinkedHashMap<>();
		this.user = user;
	}

	/**
	 * @param discountPolicyService
	 * @param user
	 */
	public CartServiceImpl( User user,DiscountPolicyService discountPolicyService) {
		this.discountPolicyService = discountPolicyService;
		this.user = user;
		this.noOfProductsWithQuantities = new LinkedHashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assesment.retailstoreservice.service.CartService#totalBill()
	 */
	@Override
	public Double totalBill() {
		double totalAmount = 0;
		for(ProductDetails product:noOfProductsWithQuantities.keySet()) {
			totalAmount+=product.getPriceForQuantity(noOfProductsWithQuantities.get(product));
		}
		if (discountPolicyService != null) {
			totalAmount = discountPolicyService.applyDiscount(totalAmount);
		}
		return totalAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assesment.retailstoreservice.service.CartService#addProduct(com.assesment
	 * .retailstoreservice.model.ProductDetails) To add Single product
	 */
	@Override
	public void addProduct(ProductDetails productDetails) {
		addProduct(productDetails, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assesment.retailstoreservice.service.CartService#addProduct(com.assesment
	 * .retailstoreservice.model.ProductDetails, java.lang.Integer) To add multiple
	 * quantities of Product
	 */
	@Override
	public void addProduct(ProductDetails product, Integer quantity) {
		ProductDetails productDetails;

		// Apply 30% discount in case of employee of store
		if (user.getUserType() == UserType.EMPLOYEE) {
			productDetails = new ProductPricingPromotionServiceImpl(product, 30);
		}
		// Apply 10% discount in case of affiliate User
		else if (user.getUserType() == UserType.AFFILIATE) {
			productDetails = new ProductPricingPromotionServiceImpl(product, 10);
		}

		// If a user has been a customer for 2 or more years then apply 5% discount
		else if (user.getUserType() == UserType.OTHER
				&& ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now()) >= 2) {
			productDetails = new ProductPricingPromotionServiceImpl(product, 5);
		}

		else {
			productDetails = product;
		}

		int previousQuantity = noOfProductsWithQuantities.containsKey(productDetails)
				? noOfProductsWithQuantities.get(productDetails)
				: 0;
		noOfProductsWithQuantities.put(productDetails, previousQuantity + quantity);
	}

}
