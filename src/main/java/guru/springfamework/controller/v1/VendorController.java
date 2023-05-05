package guru.springfamework.controller.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorsListDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(VendorController.VENDOR_URL)
public class VendorController {
    public static final String VENDOR_URL = "/api/v1/vendors";

    private VendorService vendorService;

    public VendorController(guru.springfamework.services.VendorService vendorService) {
        this.vendorService = vendorService;
    }
    @GetMapping
    public ResponseEntity<VendorsListDTO> getAllVendors(){
        return new ResponseEntity<VendorsListDTO>(new VendorsListDTO(vendorService.getAllVendors()), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id){
        return new ResponseEntity<VendorDTO>(vendorService.getVendorById( id), HttpStatus.OK);
    }
    @PutMapping({"{id}"})
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.saveVendorByDTO(id, vendorDTO), HttpStatus.CREATED);
    }
    @PatchMapping({"{id}"})
    public ResponseEntity<VendorDTO> patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.patchVendor(id, vendorDTO), HttpStatus.CREATED);
    }
    @PostMapping
    public  ResponseEntity<VendorDTO> createNewVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.createNewVendor(vendorDTO), HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteVendorById(@PathVariable Long id){
        vendorService.deleteVendorById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
