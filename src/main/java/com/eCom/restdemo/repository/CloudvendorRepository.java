package com.eCom.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eCom.restdemo.model.CloudVendor;

public interface CloudvendorRepository extends JpaRepository<CloudVendor, String> {


}
