package com.eCom.restdemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eCom.restdemo.exception.CloudVendorNotFoundexception;
import com.eCom.restdemo.model.CloudVendor;
import com.eCom.restdemo.repository.CloudvendorRepository;
import com.eCom.restdemo.service.CloudVendorService;

import jakarta.annotation.Nonnull;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    CloudvendorRepository cloudvendorRepository;


    public CloudVendorServiceImpl(CloudvendorRepository cloudvendorRepository) {
        this.cloudvendorRepository = cloudvendorRepository;
    }
    @Override
    public String createCloudvendor(@Nonnull CloudVendor cloudvendor) {
        if (cloudvendor == null) {
            return "Failure";
          }
      cloudvendorRepository.save(cloudvendor);  
      return "created Success";
    }

    @Override
    public String updateCloudvendor(CloudVendor cloudVendor) {
        if (cloudVendor == null) {
            return "Failure: CloudVendor is null";
        }
        cloudvendorRepository.save(cloudVendor);
        return "Updated Successfully";
    }

    @Override
    public String deleteCloudvendor(String cloudvendorId) {
        if (cloudvendorId == null) {
            return "Cloudvendor ID cannot be null";
        }
        cloudvendorRepository.deleteById(cloudvendorId);
        return "Delete Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudvendorId) {
        if (cloudvendorId == null) {
            return null;
        }
        if(cloudvendorRepository.findById(cloudvendorId).isEmpty())
            throw new CloudVendorNotFoundexception("Requested cloud vendor does not exist");
        return cloudvendorRepository.findById(cloudvendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudvendorRepository.findAll();
    }

}
