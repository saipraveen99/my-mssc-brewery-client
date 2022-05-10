package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
@Slf4j
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        log.info("getCustomerById Test started");
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        log.info("getCustomerById Invoked. Response is: "+customerDto.toString());
    }

    @Test
    void saveCustomer() {
        log.info("saveCustomer Test started");
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("chaladi sai praveen").build();
        URI uri = customerClient.saveCustomer(customerDto);
        log.info("saveCustomer Invoked. Response is: "+uri.toString());
    }

    @Test
    void updateCustomer() {
        log.info("updateCustomer Test started");
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("chaladi sai praveen").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
        log.info("updateCustomer Invoked.");
    }

    @Test
    void deleteCustomer() {
        log.info("deleteCustomer Test started");
        customerClient.deleteCustomer(UUID.randomUUID());
        log.info("deleteCustomer Invoked.");
    }
}