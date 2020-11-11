package io.swagger.api;

import io.swagger.model.Client;
import io.swagger.model.Goal;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Pattern;
import io.swagger.realityfamily.Repositories.ClientsRepository;
import io.swagger.realityfamily.Repositories.GoalsRepository;
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
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-11-07T19:30:51.910Z[GMT]")
@Controller
public class GoalApiController implements GoalApi {

    private static final Logger log = LoggerFactory.getLogger(GoalApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private GoalsRepository goalsRepository;

    @Autowired
    private PatternsRepository patternsRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public GoalApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> postGoal(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Goal body,
                                         @ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth) {
        if (auth != null) {
            Goal goal = new Goal();
            goal.setName(body.getName());
            goal.setDescription(body.getDescription());
            goal.setBalance(body.getBalance());
            goal.setWeightInDepositoryPipe20(body.getWeightInDepositoryPipe20());

            goal.setPatterns(patternsRepository.findAll());
            goal.setClient(clientsRepository.findOne(UUID.fromString(auth)));

            goalsRepository.save(goal);
            String accept = request.getHeader("Accept");
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseEntity<Void> deleteGoal(@ApiParam(value = "" ,required=true )  @PathVariable("deleteId") UUID body,
                                           @ApiParam(value = "" ) @RequestHeader(value="Auth", required=false) String auth) {
        List<Pattern> patterns = goalsRepository.findOne(body).getPatterns();

        goalsRepository.delete(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
