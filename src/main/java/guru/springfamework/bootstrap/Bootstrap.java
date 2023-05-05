package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private CategoryRepository categoryRespository;
    private CustomerRepository customerRepository;

    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        fillCategory();

        fillCustomer();

        fillVendor();

        System.out.println("Data Loaded = " + categoryRespository.count() );
    }

    private void fillVendor() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("First Vendor");
        vendorRepository.save(vendor1);
        Vendor vendor2 = new Vendor();
        vendor2.setName("Second Vendor");
        vendorRepository.save(vendor2);
        Vendor vendor3 = new Vendor();
        vendor3.setName("Third Vendor");
        vendorRepository.save(vendor3);
        Vendor vendor4 = new Vendor();
        vendor4.setName("Forth Vendor");
        vendorRepository.save(vendor4);
    }

    private void fillCustomer() {
        Customer Joe = new Customer();
        Joe.setFirstName("Joe");
        Joe.setLastName("Newman");

        Customer Michael = new Customer();
        Michael.setFirstName("Michael");
        Michael.setLastName("Lachappele");


        Customer David = new Customer();
        David.setFirstName("David");
        David.setLastName("Winter");

        customerRepository.save(Joe);
        customerRepository.save(Michael);
        customerRepository.save(David);
    }

    private void fillCategory() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);
    }
}
