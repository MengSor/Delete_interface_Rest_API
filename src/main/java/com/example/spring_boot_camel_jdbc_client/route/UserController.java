package com.example.spring_boot_camel_jdbc_client.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private MetaDataProcessor metaDataProcessor;

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<BeanResponseList> getUserAll(@PathVariable Long id) {
//        logger.info("Successfully retrieved {} users");
        BeanResponseList agentResponses = metaDataProcessor.deleteUsers(id);
        logger.info("Salesforce cache table process successfully");
        return ResponseEntity.ok(agentResponses);
    }

    @GetMapping("/v1")
    public ResponseEntity<BeanResponse> getUserAll() {
//        logger.info("Successfully retrieved {} users");
        BeanResponse agentResponses = metaDataProcessor.getAllUsers();
        logger.info("Salesforce table process successfully");
        return ResponseEntity.ok(agentResponses);
    }
}
