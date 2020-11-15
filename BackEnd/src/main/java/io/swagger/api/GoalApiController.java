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
import java.util.ArrayList;
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
            List<Pattern> allPatterns = patternsRepository.findAll();
            if(body.getName().equals("50/30/20")){
                for(Pattern p : allPatterns){
                    List<Goal> goals = p.getGoal();
                    Goal goal = goalsRepository.save(body);
                    goalsRepository.findByName("");
                    goals.add(goal);
                    p.setGoal(goals);
                    patternsRepository.save(p);
                }
                body.setPatterns(allPatterns);
                goalsRepository.save(body);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }
            else if(body!= null) {// all goals creation excluding the 50/30/20
                    List<Pattern> patternsToSet= new ArrayList<>();
                for(Pattern p : allPatterns){
                        if(p.getPatternType()== Pattern.PatternTypeEnum.LEISURE){
                            patternsToSet.add(p);
                        }
                    } // adding all leasure p inside patternToSet
                body.setPatterns(patternsToSet);
                Goal savedGoal = goalsRepository.save(body);

                for(Pattern p : patternsToSet) {
                    List<Goal> goals = p.getGoal();
                    goals.add(savedGoal);
                    p.setGoal(goals);
                    patternsRepository.save(p);
                }
                return new ResponseEntity<Void>(HttpStatus.OK);
            }else
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
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
