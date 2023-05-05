package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static guru.springfamework.controller.v1.VendorController.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class VendorServiceImplTest {

    private final Long ID = 1l;
    private final String NAMA = "Some Name";

    VendorService vendorService;
    @Mock
    VendorRepository vendorRepository;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(vendorRepository, VendorMapper.INSTANCE);
    }
    @Test
    public void testGetAllCustomers() {
        List<Vendor> vendors = Arrays.asList(new Vendor(),new Vendor(),new Vendor());
        when(vendorRepository.findAll()).thenReturn(vendors);

        List<VendorDTO> customerDTOS = vendorService.getAllVendors();

        assertEquals(3, customerDTOS.size());
    }
    @Test
    public void testGetCustomerById() {
        Vendor vendor = new guru.springfamework.domain.Vendor();
        vendor.setId(ID);
        vendor.setName(NAMA);

        when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));

        VendorDTO vendorDTO = vendorService.getVendorById(ID);

        assertEquals(ID, vendorDTO.getId());
        assertEquals(NAMA , vendorDTO.getName());
        assertEquals(VENDOR_URL + "/" + ID, vendorDTO.getVendor_url());

    }

}