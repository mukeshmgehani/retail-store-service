/**
 * 
 */
package com.assesment.retailstoreservice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.assesment.retailstoreservice.model.Product;
import com.assesment.retailstoreservice.model.ProductDetails;
import com.assesment.retailstoreservice.model.ProductType;
import com.assesment.retailstoreservice.model.User;
import com.assesment.retailstoreservice.model.UserType;
import com.assesment.retailstoreservice.service.CartService;
import com.assesment.retailstoreservice.serviceimp.CartServiceImpl;



/**
 * @author mukeshgehani
 *
 */
public class ProductWithoutDiscountTest {
	
	    private ProductDetails otherProduct;
	    private User otherUser;
	    private CartService cartService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
    	otherUser = new User(UserType.OTHER, "Mukesh");
    	otherProduct = new Product(1000D,"Car",ProductType.OTHER);
    	cartService=new CartServiceImpl(otherUser);
	}


	 @Test
	    public void test_emptyCartCostsZero() {
	        assertEquals(0, cartService.totalBill(), 0.01);
	    }

	    @Test
	    public void test_singleBasicotherProductCostsItsUnitPrice() {
	        cartService.addProduct(otherProduct);
	        assertEquals(otherProduct.getPrice(), cartService.totalBill(), 0.01);
	    }

	    @Test
	    public void test_multipleBasicotherProductsCostProportionally() {
	        int howMany = 3;
	        cartService.addProduct(otherProduct, howMany);
	        assertEquals(howMany * otherProduct.getPrice(), cartService.totalBill(), 0.01);
	    }

	    @Test
	    public void test_separatelyAdding() {
	        int howMany = 3;
	        for (int i = howMany; i > 0; i--) {
	            cartService.addProduct(otherProduct);
	        }
	        assertEquals(howMany * otherProduct.getPrice(), cartService.totalBill(), 0.01);
	    }
}
