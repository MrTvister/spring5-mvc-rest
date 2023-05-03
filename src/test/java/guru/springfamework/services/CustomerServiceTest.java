package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CustomerServiceTest{

    private final static Long ID = 2l;
    private final static String NAME = "Jimmy";

    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository,CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomers() throws Exception{
        List<Customer> customerList = Arrays.asList(new Customer(),new Customer(),new Customer());
        when(customerRepository.findAll()).thenReturn(customerList);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        org.junit.Assert.assertEquals(3, customerDTOS.size());
    }
    @Test
    public void createNewCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");
        Customer saveedCustomer = new Customer();
        saveedCustomer.setFirstName(customerDTO.getFirstName());
        saveedCustomer.setLastName(customerDTO.getLastName());
        saveedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(saveedCustomer);

        CustomerDTO saved = customerService.createNewCustomer(customerDTO);
        assertEquals(customerDTO.getFirstName(), saved.getFirstName());
        assertEquals("/api/v1/customer/1", saved.getCustomerURL());
    }
}