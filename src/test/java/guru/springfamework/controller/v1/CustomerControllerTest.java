package guru.springfamework.controller.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.services.CustomerService;
import junit.framework.TestCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest{

    private final static String FIRSTNAME = "Joe";
    private final static String LASTNAME = "Monro";
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @org.junit.Test
    public void testListCustomers() throws Exception{
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1l);
        customerDTO.setFirstName(FIRSTNAME);
        customerDTO.setLastName(LASTNAME);
        CustomerDTO customerDTO2 = new CustomerDTO();
        customerDTO2.setId(2l);
        customerDTO2.setFirstName(FIRSTNAME);
        customerDTO2.setLastName(LASTNAME);


        List<CustomerDTO> customerDTOS = Arrays.asList(customerDTO, customerDTO2);
        when(customerService.getAllCustomers()).thenReturn(customerDTOS);
        mockMvc.perform(get("/api/v1/categories")
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }
}