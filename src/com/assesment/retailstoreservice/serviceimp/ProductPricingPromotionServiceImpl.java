/**
 * 
 */
package com.assesment.retailstoreservice.serviceimp;

import com.assesment.retailstoreservice.model.ProductDetails;
import com.assesment.retailstoreservice.model.ProductType;
import com.assesment.retailstoreservice.service.ProductPricingPolicyService;

/**
 * @author mukeshgehani
 * 
 *         This class is used for applying discount based on product Type
 *
 */
public class ProductPricingPromotionServiceImpl extends ProductPricingPolicyService {

	private final double pricingFactor;

	public ProductPricingPromotionServiceImpl(ProductDetails productDetails, int discountPrecentage) {
		super(productDetails);
		if (discountPrecentage < 0 || discountPrecentage > 100) {
			throw new IllegalArgumentException("Precentage of discount must be in [0,100]");
		}
		this.pricingFactor = (100 - discountPrecentage) / 100.0;
	}

	@Override
	public Double getPriceForQuantity(Integer quantity) {
		// If Grocery then don't apply the percentage discount
		if (super.getProductType() == ProductType.GROCERY) {
			return super.getPriceForQuantity(quantity);
		}

		// else apply percentage discount
		return (super.getPriceForQuantity(quantity) * pricingFactor);
	}

}
