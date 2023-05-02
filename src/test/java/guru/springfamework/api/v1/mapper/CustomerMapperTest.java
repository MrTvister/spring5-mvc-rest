package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest extends junit.framework.TestCase {

    public static final long ID = 1L;
    public static final String FIRSTNAME = "Joe";
    public static final String LASTNAME = "Newman";

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @org.junit.Test
    public void customerToCustomerDTOTest() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(LASTNAME);
        customer.setId(ID);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(LASTNAME, customerDTO.getLastName());
    }
}