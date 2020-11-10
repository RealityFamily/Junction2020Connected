package io.swagger.api;

import io.swagger.model.Challenge;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Goal;
import io.swagger.realityfamily.Repositories.ChallengeRepository;
import io.swagger.realityfamily.Repositories.GoalsRepository;
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
public class ChallengeApiController implements ChallengeApi {

    private static final Logger log = LoggerFactory.getLogger(ChallengeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private GoalsRepository goalsRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ChallengeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Challenge> getChallenge(@ApiParam(value = "",required=true) @PathVariable("challengeId") UUID challengeId
,@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) throws UnsupportedEncodingException {
       // challengeRepository.save(new Challenge(Challenge.ChallengeTypeEnum.SURVIVEORDIE, "TestChalendge", "","", goalsRepository.findAll().get(0)));
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return //new ResponseEntity<Challenge>(challengeRepository.findOne(challengeId), HttpStatus.OK);//
                new ResponseEntity<Challenge>(objectMapper.readValue("{\n  \"goal\" : {\n    \"balance\" : 5.962133916683182,\n    \"weightInDepositoryPipe20\" : 2.3021358869347655,\n    \"patterns\" : [ null, null ],\n    \"name\" : \"name\",\n    \"description\" : \"description\",\n    \"progress\" : 5.637376656633329,\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n    \"user\" : {\n      \"accountAuth\" : \"accountAuth\",\n      \"balance\" : 7.061401241503109,\n      \"accountName\" : \"accountName\",\n      \"accountIBAN\" : \"accountIBAN\",\n      \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n      \"instagram\" : \"https://www.instagram.com/worldverwe\",\n      \"goals\" : [ null, null ]\n    }\n  },\n  \"name\" : \"name\",\n  \"challengeType\" : \"SurviveOrDie\",\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n  \"periodStart\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"periodEnd\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Challenge.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }

        return new ResponseEntity<Challenge>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postChallenge(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Challenge body
,@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) {

        String accept = request.getHeader("Accept");
        challengeRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
