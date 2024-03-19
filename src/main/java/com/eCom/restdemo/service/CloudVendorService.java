package com.eCom.restdemo.service;


import java.util.List;

import com.eCom.restdemo.model.CloudVendor;

public interface CloudVendorService {

    public String createCloudvendor(CloudVendor cloudvendor);
    public String updateCloudvendor(CloudVendor cloudVendor);
    public String deleteCloudvendor(String cloudvendorId);
    public CloudVendor getCloudVendor(String cloudvendorId);
    public List<CloudVendor>getAllCloudVendors();

}
