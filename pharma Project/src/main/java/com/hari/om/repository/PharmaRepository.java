package com.hari.om.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hari.om.entities.CompanyEntity;
import com.hari.om.entities.CompanyProjection;
import com.hari.om.entities.DiseaseProjection;
import com.hari.om.entities.ProductEntity;
import com.hari.om.entities.ProductProjection;

@Repository
public interface PharmaRepository extends JpaRepository<ProductEntity, Long>{
	
	@Query(value = "SELECT pid as pid, productname as productname, description as Description , image as Image, quantity as Quantity , price as Price , "
			+ "symptoms as Symptoms , dosage as Dosage , composition as Composition"
			+ " FROM public.product WHERE cid =:cid ", nativeQuery=true)
	public List<ProductProjection> getProductListByCompanyId(@Param("cid")  Long cid);
	
	
	@Query(value="SELECT pid as pid, productname as productname, description as Description , image as Image, quantity as Quantity , price as Price , "
			+ "	symptoms as Symptoms , dosage as Dosage , composition as Composition "
			+ " FROM public.product WHERE cid =:companyId AND pid =:productId ", nativeQuery=true)
	public ProductProjection getProductByProductIdAndCompanyId(@Param("productId") Long productId, @Param("companyId") Long companyId);
	
	
	@Query(value = "SELECT cid, company_name as companyName FROM public.company", nativeQuery=true)
	public List<CompanyProjection> getCompanyList();
	
	
	@Query(value="SELECT diseaseid as DiseaseId , diseasename as DiseaseName FROM public.disease", nativeQuery=true)
	public List<DiseaseProjection> getDiseaseList();
	
	
	
	@Query(value = "SELECT pid as pid, productname as productname, description as Description , image as Image, quantity as Quantity , price as Price , "
			+ "symptoms as Symptoms , dosage as Dosage , composition as Composition"
			+ " FROM public.product WHERE symptoms ILIKE '%:symptoms%' ", nativeQuery=true)
	public List<ProductProjection> getProductByDisease(@Param("symptoms") String symptoms);
	
	

}
