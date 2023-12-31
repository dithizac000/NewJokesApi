package edu.greenriver.sdev.jokesapi;


import edu.greenriver.sdev.jokesapi.model.Joke;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JokesApiApplicationTests
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void contextLoads()
    {

    }

    @Test
    public void getAllJokes()
    {
        String endpoint = "http://localhost:" + port + "/jokes";

        //assemble a request
        HttpEntity request = new HttpEntity(new HttpHeaders());

        //make the request and get a response
        ResponseEntity<Joke[]> response = rest.exchange(endpoint, HttpMethod.GET,
                request, Joke[].class);

        //test it!
        HttpStatusCode status = response.getStatusCode();
        Joke[] jokes = response.getBody();

        assertEquals(status, HttpStatus.OK);
        assertTrue(jokes.length > 0);
    }

    @Test
    public void updateTest() {

    }

    @Test public void deleteTest() {

    }
}