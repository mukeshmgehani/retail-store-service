/**
 * 
 */
package com.assesment.retailstoreservice;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

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
public class ProductWithDiscountTest {
	
	 private ProductDetails groceryProduct;
	    private ProductDetails otherProduct;
	    private User employee;
	    private User affiliate;
	    private User otherUser;
	    private User otherUserWith2Years;
	    private DiscountPolicyService discountPolicyService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

    	employee = new User(UserType.EMPLOYEE, "Mukesh");
    	affiliate = new User(UserType.AFFILIATE, "Risha");
    	otherUser = new User(UserType.OTHER, "Sanjay");
    	otherUserWith2Years = new User(UserType.OTHER, "Ramesh", LocalDateTime.of(2017, 7, 19, 6, 40, 45));
    	groceryProduct = new Product( 20D,"Oil", ProductType.GROCERY);
    	otherProduct = new Product(222D,"TV",ProductType.OTHER);
        discountPolicyService = new DiscountPolicyServiceImpl();
	}


    @Test
    public void employeeWithGroceryProductTest() {
    	CartService cartService=new CartServiceImpl(employee, discountPolicyService);
    	cartService.addProduct(groceryProduct,2);
        // No discount because of grocery item
        assertEquals(40,cartService.totalBill(),0.01);
        
    }
    
    @Test
    public void employeeWithOtherProductTest() {
    	CartService cartService=new CartServiceImpl(employee, discountPolicyService);
        cartService.addProduct(otherProduct, 4);
        /*
         *  30% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 30% discount = 621.6
         *  After 30 dollars off due to price over $600 = 591.6 
         */
        assertEquals(591.6, cartService.totalBill(), 0.01);
        
    }
    
    @Test
    public void affiliateWithGroceryProductTest() {
    	CartService cartService=new CartServiceImpl(affiliate, discountPolicyService);
    	cartService.addProduct(groceryProduct,2);
        // No discount because of grocery item
        assertEquals(40,cartService.totalBill(),0.01);
        
    }
    
    @Test
    public void affiliateWithOtherProductTest() {
    	CartService cartService=new CartServiceImpl(affiliate, discountPolicyService);
    	cartService.addProduct(otherProduct,4);
      
        /*
         *  10% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 10% discount = 799.2
         *  After 35 dollars off due to price over $700 = 591.6 
         */
        assertEquals(764.2, cartService.totalBill(), 0.01);
        
    }
    
    @Test
    public void otherUserWithGroceryProductTest() {
    	CartService cartService=new CartServiceImpl(otherUser, discountPolicyService);
    	cartService.addProduct(groceryProduct,2);
        // No discount because of grocery item
        assertEquals(40,cartService.totalBill(),0.01);
        
    }
    
    @Test
    public void otherUserWithOtherProductTest() {
    	CartService cartService=new CartServiceImpl(otherUser, discountPolicyService);
    	cartService.addProduct(otherProduct,4);
      
        /*
         *  Total 222 * 4 = 888
         *  No percentage discount because user is a customer for less than 2 years
         *  After 40 dollars off due to price over $800 = 848 
         */
        assertEquals(848, cartService.totalBill(), 0.01);        
    }
    
    @Test
    public void otherUserWith2YearsWithGroceryProductTest() {
    	CartService cartService=new CartServiceImpl(otherUserWith2Years, discountPolicyService);
    	cartService.addProduct(groceryProduct,2);
        // No discount because of grocery item
        assertEquals(40, cartService.totalBill(), 0.01);
    }
    
    @Test
    public void otherUserWith2YearsWithOtherProductTest() {
    	CartService cartService=new CartServiceImpl(otherUserWith2Years, discountPolicyService);
    	cartService.addProduct(otherProduct,4);
      /*
         *  5% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 5% discount = 843.6
         *  After 40 dollars off due to price over $800 =803.6 
         */
        assertEquals(803.6, cartService.totalBill(), 0.01);
    }
    
    @Test
    public void employeeWithGroceryAndOtherProductTest() {
    	CartService cartService=new CartServiceImpl(employee, discountPolicyService);
        cartService.addProduct(otherProduct, 4);
        cartService.addProduct(groceryProduct,4);
        /*
         *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on grocery items = 968 still
         *  After 30% discount on 4 other items totalling 888 = 701.6
         *  After 35 dollars off due to price over $700 =666.6 
         */
        assertEquals(666.6, cartService.totalBill(), 0.01);
        
    }

}
