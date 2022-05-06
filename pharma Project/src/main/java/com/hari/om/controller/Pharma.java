package com.hari.om.controller;




import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hari.om.entities.CompanyEntity;
import com.hari.om.entities.CompanyProjection;
import com.hari.om.entities.DiseaseProjection;
import com.hari.om.entities.Feedback;
import com.hari.om.entities.ProductProjection;
import com.hari.om.entities.ResponseDTO;
import com.hari.om.intf.PharmaIntf;

@RestController
@Component
public class Pharma {
	
	
	@Autowired
	private PharmaIntf pharmaIntf;
	
	private static final String apiLink = "https://sheet.best/api/sheets/22c663f7-b717-4394-a0d6-f0a70d4fe525";
	
	@GetMapping("/getMedicine/{id}")
	public ResponseDTO getProductByCompany(@PathVariable("id") Long companyId) {
		
		ResponseDTO dto =  pharmaIntf.getProductBasedOnCompany(companyId);
		
		
		return dto;		
		
	}
	
	@PostMapping("/feedback-data")
	public String feedbackData(@RequestBody Feedback feedback) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		headers.add("x-api-key", "6SXf0U_G8VJ7ks9LAiRBuR5$!SHsLozp4Zcud2xslEeV4r6HCWgZyJiLgpNZ9UB$");
        HttpEntity<Feedback> entity=new HttpEntity<Feedback>(feedback,headers);
		return restTemplate.exchange(apiLink, HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	
	@GetMapping("/get-product-by-id")
	public ProductProjection getProductByProductIdAndCompanyId(@Param("productId") Long productId, @Param("companyId") Long companyId) {
		
		ProductProjection dto = pharmaIntf.getproductByProductIdAndCompanyId(productId, companyId);
		
		return dto;
	}
	
	
	@GetMapping("/get-company-list")
	public List<CompanyProjection> getCompanyList() {
		
		List<CompanyProjection> list = pharmaIntf.getCompanyList();
		
		return list;
	}
	
	
	@GetMapping("/get-disease-list")
	public List<DiseaseProjection> getDiseaseList(){
		
		List<DiseaseProjection> list = pharmaIntf.getDiseaseList();
				
		return list;
		
	}
	
	
	@GetMapping("/get-product-by-disease")
	public List<ProductProjection> getProductByDisease(@Param("diseaseName") String diseaseName) {
		
		List<ProductProjection> list = pharmaIntf.getProductByDisease(diseaseName);
		
		return list;
	}
	 
}
