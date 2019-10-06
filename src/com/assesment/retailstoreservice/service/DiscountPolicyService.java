/**
 * 
 */
package com.assesment.retailstoreservice.service;

/**
 * @author mukeshgehani
 *
 *Interface for Overall Discount Policy for all products of cart
 */
public interface DiscountPolicyService {

	Double applyDiscount(double totalAmount);
}
