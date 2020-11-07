package io.swagger.api;

import io.swagger.model.Goal;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GoalPredictApiController implements GoalPredictApi {

    private static final Logger log = LoggerFactory.getLogger(GoalPredictApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GoalPredictApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Goal> getGoalPredict(@ApiParam(value = "",required=true) @PathVariable("goalId") UUID goalId
,@ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Goal>(objectMapper.readValue("{\n  \"balance\" : 5.962133916683182,\n  \"weightInDepositoryPipe20\" : 2.3021358869347655,\n  \"patterns\" : [ null, null ],\n  \"name\" : \"name\",\n  \"description\" : \"description\",\n  \"progress\" : 5.637376656633329,\n  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n  \"user\" : {\n    \"accountAuth\" : \"accountAuth\",\n    \"balance\" : 7.061401241503109,\n    \"accountName\" : \"accountName\",\n    \"accountIBAN\" : \"accountIBAN\",\n    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",\n    \"instagram\" : \"https://www.instagram.com/worldverwe\",\n    \"goals\" : [ null, null ]\n  }\n}", Goal.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Goal>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Goal>(HttpStatus.NOT_IMPLEMENTED);
    }

}
