package org.librairy.service.modeler.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.avro.AvroRemoteException;
import org.librairy.service.modeler.facade.model.ModelerService;
import org.librairy.service.modeler.facade.rest.model.TopicList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
@Api(tags="/topics", description="dimensions of the model")
public class RestTopicsController {

    private static final Logger LOG = LoggerFactory.getLogger(RestTopicsController.class);

    @Autowired
    ModelerService service;

    @PostConstruct
    public void setup(){

    }

    @PreDestroy
    public void destroy(){

    }

    @ApiOperation(value = "confirmation", nickname = "postTopics", response=TopicList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TopicList.class),
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public TopicList topics()  {
        try {
            return new TopicList(service.topics().stream().map(t -> new org.librairy.service.modeler.facade.rest.model.Topic(t)).collect(Collectors.toList()));
        } catch (AvroRemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
