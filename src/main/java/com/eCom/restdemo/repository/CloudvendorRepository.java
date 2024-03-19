package com.eCom.restdemo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eCom.restdemo.model.CloudVendor;

public interface CloudvendorRepository extends JpaRepository<CloudVendor, String> {
   List<CloudVendor> findByVendorName(String vendorName);

}
