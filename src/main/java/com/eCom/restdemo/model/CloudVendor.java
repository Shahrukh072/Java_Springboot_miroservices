package com.eCom.restdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cloud_vendor_info")
public class CloudVendor {
   
    @Id
    private String vendorId;
    private String vendorName;
    private String VendorAddress;
    private String vendorPhoneNumber;

    public String getVendorId() {
        return this.vendorId;
    }

    public CloudVendor() {
    }

    public CloudVendor(String vendorId, String vendorName, String VendorAddress, String vendorPhoneNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.VendorAddress = VendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }


    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return this.VendorAddress;
    }

    public void setVendorAddress(String VendorAddress) {
        this.VendorAddress = VendorAddress;
    }

    public String getVendorPhoneNumber() {
        return this.vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }
   
}
