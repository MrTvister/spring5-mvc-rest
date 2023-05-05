package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.bootstrap.Bootstrap;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

        //setup data for testing
        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, vendorRepository);
        bootstrap.run(); //load data

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void patchCustomerUpdateFirstName() {

    }

    @Test
    public void patchCustomerUpdateLastName() throws Exception {
        long id = getCustomerIdValue();
        Customer origin = customerRepository.getOne(id);
        org.junit.Assert.assertNotNull(origin);

        String originFirstName = origin.getFirstName();
        String originLastName = origin.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("UpdateName");
        customerService.patchCustomer(id, customerDTO);

        Customer updateCustomer = customerRepository.findById(id).get();
        org.junit.Assert.assertNotNull(updateCustomer);
        org.junit.Assert.assertEquals("UpdateName", updateCustomer.getFirstName());
        assertThat(originFirstName, not(equalTo(updateCustomer.getFirstName())));
        assertThat(originLastName, equalTo(updateCustomer.getLastName()));

    }

    private Long getCustomerIdValue() {
        List<Customer> customerList = customerRepository.findAll();
        System.out.println(customerList.size());
        return customerList.get(0).getId();
    }


}
