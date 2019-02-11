package com.corelogic.rps.rentrolldata.vendordata.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.corelogic.rps.rentrolldata.vendordata.data.VendorRequestParams;

import java.util.List;

@Service
public interface VendorRequestParamsRepository extends CrudRepository<VendorRequestParams, String> {

     @Query("from VendorRequestParams where vendorParamsId.furnisher = :furnisher")
    List<VendorRequestParams> findByFurnisher(@Param("furnisher") String  furnisher);
    
     @Query("from VendorRequestParams where vendorParamsId.vendor = :vendor")
    List<VendorRequestParams> findByVendor(@Param("vendor") String vendor);
}
