package org.librairy.service.modeler.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.avro.AvroRemoteException;
import org.librairy.service.modeler.facade.model.ModelerService;
import org.librairy.service.modeler.facade.rest.model.WordList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/words")
@Api(tags="/words", description="top words of a given topic")
public class RestWordsController {

    private static final Logger LOG = LoggerFactory.getLogger(RestWordsController.class);

    @Autowired
    ModelerService service;

    @PostConstruct
    public void setup(){

    }

    @PreDestroy
    public void destroy(){

    }

    @ApiOperation(value = "confirmation", nickname = "postWords", response=WordList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = WordList.class),
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public WordList words(@RequestParam Integer topicId,@RequestParam Integer maxWords)  {
        try {
            return new WordList(service.words(topicId,maxWords).stream().map(w -> new org.librairy.service.modeler.facade.rest.model.Word(w)).collect(Collectors.toList()));
        } catch (AvroRemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
