package io.swagger.api;

import io.swagger.model.Pattern;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.realityfamily.Repositories.PatternsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")
@Controller
public class PatternsApiController implements PatternsApi {

    private static final Logger log = LoggerFactory.getLogger(PatternsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PatternsRepository repository;

    @org.springframework.beans.factory.annotation.Autowired
    public PatternsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Pattern>> getPatterns(@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Pattern>>(repository.findAll(), HttpStatus.OK);//ResponseEntity<List<Pattern>>(objectMapper.readValue("[ {\n  \"detectedStart\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"goal\" : {\n    \"balance\" : 5.962133916683182,\n    \"weightInDepositoryPipe20\" : 2.3021358869347655,\n    \"patterns\" : [ null, null ],\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"progress\" : 5.637376656633329,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n    \"user\" : {\n      \"accountAuth\" : \"accountAuth\",\n      \"balance\" : 7.061401241503109,\n      \"accountName\" : \"accountName\",\n      \"accountIBAN\" : \"accountIBAN\",\n      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n      \"instagram\" : \"https://www.instagram.com/worldverwe\",\n      \"goals\" : [ null, null ]\n    }\n  },\n  \"allAmount\" : 6.027456183070403,\n  \"averageTransAmount\" : 1.4658129805029452,\n  \"detectedEnd\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"patternType\" : \"Obligatory\",\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n  \"transactions\" : [ {\n    \"timeStamp\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"amount\" : 9.301444243932576,\n    \"balance\" : 3.616076749251911,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n  }, {\n    \"timeStamp\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"amount\" : 9.301444243932576,\n    \"balance\" : 3.616076749251911,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n  } ],\n  \"frequency\" : 0\n}, {\n  \"detectedStart\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"goal\" : {\n    \"balance\" : 5.962133916683182,\n    \"weightInDepositoryPipe20\" : 2.3021358869347655,\n    \"patterns\" : [ null, null ],\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"progress\" : 5.637376656633329,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n    \"user\" : {\n      \"accountAuth\" : \"accountAuth\",\n      \"balance\" : 7.061401241503109,\n      \"accountName\" : \"accountName\",\n      \"accountIBAN\" : \"accountIBAN\",\n      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n      \"instagram\" : \"https://www.instagram.com/worldverwe\",\n      \"goals\" : [ null, null ]\n    }\n  },\n  \"allAmount\" : 6.027456183070403,\n  \"averageTransAmount\" : 1.4658129805029452,\n  \"detectedEnd\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"patternType\" : \"Obligatory\",\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n  \"transactions\" : [ {\n    \"timeStamp\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"amount\" : 9.301444243932576,\n    \"balance\" : 3.616076749251911,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n  }, {\n    \"timeStamp\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"amount\" : 9.301444243932576,\n    \"balance\" : 3.616076749251911,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n  } ],\n  \"frequency\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Pattern>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Pattern>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
