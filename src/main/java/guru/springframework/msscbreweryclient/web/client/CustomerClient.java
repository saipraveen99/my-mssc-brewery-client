package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "csp.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH = "/api/v1/customer/";

    private String apihost;

    private RestTemplate restTemplate;

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid) {
         return restTemplate.getForObject(apihost + CUSTOMER_PATH + uuid.toString(), CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH + uuid.toString());
    }
}
