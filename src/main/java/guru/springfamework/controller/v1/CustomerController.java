package guru.springfamework.controller.v1;

import guru.springfamework.api.v1.model.CustomersListDTO;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(guru.springfamework.services.CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<CustomersListDTO> getAllCustomers(){
        return new ResponseEntity<CustomersListDTO>(new CustomersListDTO(customerService.getAllCustomers()),
                HttpStatus.OK);
    }
}
