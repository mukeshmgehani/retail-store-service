/**
 * 
 */
package com.assesment.retailstoreservice.serviceimp;

import com.assesment.retailstoreservice.service.DiscountPolicyService;

/**
 * @author mukeshgehani
 * 
 * This class is used to generate discount of $5 for every 100 dollars in cart
 *
 */
public class DiscountPolicyServiceImpl implements DiscountPolicyService {

	/* (non-Javadoc)
	 * @see com.assesment.retailstoreservice.service.DiscountPolicyService#applyDiscount(java.lang.Double)
	 */
	@Override
	public Double applyDiscount(double totalAmount) {
		if(totalAmount<100) return totalAmount;
		
		int discountFactor = (int) (totalAmount / 100) ;
		double discount = discountFactor * 5;
		return totalAmount - discount; 
	}

}
