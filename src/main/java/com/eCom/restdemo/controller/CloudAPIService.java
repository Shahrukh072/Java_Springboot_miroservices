package com.eCom.restdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCom.restdemo.model.CloudVendor;
import com.eCom.restdemo.response.ResponseHandler;
import com.eCom.restdemo.service.CloudVendorService;

@RestController
@RequestMapping("/CloudVendor")
public class CloudAPIService {

    CloudVendorService cloudVendorService;

    public CloudAPIService(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){

       return ResponseHandler.responseBuilder("Requested cendor details are give here",
         HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
       return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String CreateCloudVendordetails(@RequestBody CloudVendor cloudVendor){
    
        cloudVendorService.createCloudvendor(cloudVendor);
        return "Cloud vendor created sucessfully";
}

     @PutMapping
     public String UpdateCloudVendordetails(@RequestBody CloudVendor cloudVendor){

        cloudVendorService.updateCloudvendor(cloudVendor);
       return "Cloud vendor Update sucessfully";
}

    @DeleteMapping("{vendorId}")
    public String DeleteCloudVendordetails(@PathVariable("vendorId") String vendorId){

        cloudVendorService.deleteCloudvendor(vendorId);
        return "Cloud vendor delete sucessfully";
}

}
