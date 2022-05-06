package com.hari.om.entities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseDTO {
	
	private List<ProductProjection> productList;

	public List<ProductProjection> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductProjection> productList) {
		this.productList = productList;
	}
	
	
	

}
