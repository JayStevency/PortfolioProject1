package net.jay.webserver.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jay on 2017. 3. 27..
 */
@RestController
@RequestMapping(value = "search")
public class SearchController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String uri = "http://localhost:8000";

    //CrossOrigin http://adrenal.tistory.com/16
    @CrossOrigin(origins = "http://localhost:7000")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object[] search(String search){
        logger.info("Search Data : {}", search);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri+"/github/"+search, Object[].class);
        Object[] result = responseEntity.getBody();
        return result;
    }

}
