package io.swagger.api;

import io.swagger.model.Goal;
import java.util.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
public class GoalPredictApiController implements GoalPredictApi {

    private static final Logger log = LoggerFactory.getLogger(GoalPredictApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private GoalsRepository goalsRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public GoalPredictApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Goal> getGoalPredict(@ApiParam(value = "",required=true) @PathVariable("goalId") UUID goalId,
                                               @ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth)
    {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Goal> goals = goalsRepository.findAll();
            for (Goal goal : goals) {
                if (goal.getId().equals(goalId)) {
                    return new ResponseEntity<Goal>(goal, HttpStatus.OK);
                }
            }
            return new ResponseEntity<Goal>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Goal>(HttpStatus.NOT_IMPLEMENTED);
    }

}
