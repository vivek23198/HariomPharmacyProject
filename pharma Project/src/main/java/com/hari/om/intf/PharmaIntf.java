package com.hari.om.intf;

import java.util.List;

import com.hari.om.entities.CompanyEntity;
import com.hari.om.entities.CompanyProjection;
import com.hari.om.entities.DiseaseProjection;
import com.hari.om.entities.ProductProjection;
import com.hari.om.entities.ResponseDTO;

public interface PharmaIntf {
	
	 ResponseDTO getProductBasedOnCompany(Long cid);

	 ProductProjection getproductByProductIdAndCompanyId(Long productId, Long companyId);
	 
	 List<CompanyProjection> getCompanyList();
	 
	 List<DiseaseProjection> getDiseaseList();
	 
	 List<ProductProjection> getProductByDisease(String diseaseName);
}
