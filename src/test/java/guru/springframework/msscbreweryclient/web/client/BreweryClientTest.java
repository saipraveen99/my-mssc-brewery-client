package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerbyId() {
        log.info("getBeerbyId Test Started");
        BeerDto dto = breweryClient.getBeerbyId(UUID.randomUUID());
        log.info("getBeerbyId invoked. The received response is :"+dto);
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        log.info("saveNewBeer Test started");
        BeerDto beerDto = BeerDto.builder().beerName("my-beer").beerStyle("sweet").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        log.info("saveNewBeer invoked. THe received response is :"+uri);
        assertNotNull(uri);

    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("my-beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }
}