/**
 * 
 */
package com.assesment.retailstoreservice.model;

/**
 * @author mukeshgehani
 *
 */
public class Product implements ProductDetails {

	private Double price;
	private String name;
	private ProductType productType;

	/**
	 * @param price
	 * @param name
	 * @param productType
	 */
	public Product(Double price, String name, ProductType productType) {
		super();
		this.price = price;
		this.name = name;
		this.productType = productType;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productType != other.productType)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [price=");
		builder.append(price);
		builder.append(", name=");
		builder.append(name);
		builder.append(", productType=");
		builder.append(productType);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Double getPriceForQuantity(Integer quantity) {
		return this.price*quantity;
	}

}
