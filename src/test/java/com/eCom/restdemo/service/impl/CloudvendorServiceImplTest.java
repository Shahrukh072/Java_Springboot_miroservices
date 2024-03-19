package com.eCom.restdemo.service.impl;

import com.eCom.restdemo.model.CloudVendor;
import com.eCom.restdemo.repository.CloudvendorRepository;
import com.eCom.restdemo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CloudvendorServiceImplTest {
    @Mock
    private CloudvendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1", "amazon",
                "Ind", "9540083310");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudvendor(cloudVendor)).isEqualTo("created Success");

    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudvendor(cloudVendor)).isEqualTo("Updated Successfully");
    }

    @Test
    void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudvendor("1")).isEqualTo("Delete Successfully");
    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));

        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void testGetByVendorName() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class);

        when(cloudVendorRepository.findByVendorName("amazon")).
                thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

        // assertThat(cloudVendorService.getByvendorname("amazon").get(0).getVendorId()).
        //         isEqualTo(cloudVendor.getVendorId());
    }

    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudvendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(
                Collections.singleton(cloudVendor)
        ));

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(cloudVendor.getVendorPhoneNumber());

    }

}
