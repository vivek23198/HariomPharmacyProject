package com.hari.om.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hari.om.entities.CompanyEntity;
import com.hari.om.entities.CompanyProjection;
import com.hari.om.entities.DiseaseProjection;
import com.hari.om.entities.ProductProjection;
import com.hari.om.entities.ResponseDTO;
import com.hari.om.intf.PharmaIntf;
import com.hari.om.repository.PharmaRepository;

@Component
public class PharmaServiceImpl implements PharmaIntf{
	
	@Autowired
	private PharmaRepository pharmaRepository;

	@Override
	public ResponseDTO getProductBasedOnCompany(Long cid) {
		
		ResponseDTO responseDto = new ResponseDTO();
		
		List<ProductProjection> productList = null;
		
		productList = pharmaRepository.getProductListByCompanyId(cid);
		

		
		responseDto.setProductList(productList);
		
		return responseDto;
	}

	@Override
	public ProductProjection getproductByProductIdAndCompanyId(Long productId, Long companyId) {
		
		//ResponseDTO responseDto = new ResponseDTO();
		
		ProductProjection product = null;
		product = pharmaRepository.getProductByProductIdAndCompanyId(productId, companyId);
		
		//responseDto.setProductList(productList);
		
		return product;
	}

	@Override
	public List<CompanyProjection> getCompanyList() {
		
		List<CompanyProjection> companyList = pharmaRepository.getCompanyList();
		
		return companyList;
	}
	
	public List<DiseaseProjection> getDiseaseList(){
		
		List<DiseaseProjection> diseaseList = pharmaRepository.getDiseaseList();
		
		return diseaseList;
	}

	@Override
	public List<ProductProjection> getProductByDisease(String diseaseName) {
		
		List<ProductProjection> productListByDisease = pharmaRepository.getProductByDisease(diseaseName);
		
		return productListByDisease;
	}

}
