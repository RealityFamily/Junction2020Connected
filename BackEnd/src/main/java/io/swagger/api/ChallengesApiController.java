package io.swagger.api;

import io.swagger.model.Challenge;
import io.swagger.model.SmallInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.realityfamily.Repositories.ChallengeRepository;
import io.swagger.realityfamily.Repositories.UsersRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")
@Controller
public class ChallengesApiController implements ChallengesApi {

    private static final Logger log = LoggerFactory.getLogger(ChallengesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private UsersRepository usersRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ChallengesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<SmallInfo>> getChallenges(@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            ArrayList<SmallInfo> smallInfos = new ArrayList<>();

            List<Challenge> challenges = challengeRepository.findAll();
            for(Challenge c : challenges){
                smallInfos.add(new SmallInfo(c.getId(), c.getName()));
            }

            try {
                return new ResponseEntity<List<SmallInfo>>(smallInfos, HttpStatus.OK); //ResponseEntity<List<SmallInfo>>(objectMapper.readValue("[ {\n  \"name\" : \"name\",\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n}, {\n  \"name\" : \"name\",\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<SmallInfo>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<SmallInfo>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
