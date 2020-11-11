package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.realityfamily.Repositories.ClientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")
@Controller
public class DebCredStatusApiController implements DebCredStatusApi {

    private static final Logger log = LoggerFactory.getLogger(DebCredStatusApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ClientsRepository clientsRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public DebCredStatusApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Double> getDebCredStatus(@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
               // return new ResponseEntity<Double>(usersRepository.findAll().get(0).getBalance(), HttpStatus.OK);
                return new ResponseEntity<Double>(objectMapper.readValue("0.8008281904610115", Double.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Double>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Double>(HttpStatus.NOT_IMPLEMENTED);
    }

}
