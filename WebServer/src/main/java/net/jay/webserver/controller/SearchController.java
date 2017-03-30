package net.jay.webserver.controller;

import net.jay.webserver.cache.SearchCache;
import net.jay.webserver.domain.SearchRepository;
import net.jay.webserver.domain.SearchVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SearchRepository searchRepository;

    private SearchCache searchCache;

    //CrossOrigin http://adrenal.tistory.com/16
    @CrossOrigin(origins = "http://localhost:7000")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object[] search(String search){
        logger.info("Search Data : {}", search);
        if(searchCache == null)
            searchCache = new SearchCache();

        searchCache.addRequestSearch(search);
        logger.info("Request Queue size : {}",searchCache.getRequsetQueueSize());

        if(searchCache.hasSearch(search)){
            return searchCache.getSearch(search);
        }else{
            /* TODO 몽고 디비에서 데이터 확인 후 없으면 서버 2로 통신
             */


            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri+"/github/"+search, Object[].class);
            Object[] result = responseEntity.getBody();


            /* TODO LRU 알고리즘으로 캐쉬 정리 메소드 구현
             */

            if(searchCache.getCacheSize() > SearchCache.CACHE_MAX_SIZE){
                /* TODO Cache Data 삭제
                * */
                SearchVO removeData = searchCache.removeSearchVO();
                /* TODO IF 몽고 디비 데이터 존재하지 않으면 몽고 디비로
                 */
                logger.info("Remove Search : {}", removeData.toString());

            }
            searchCache.addSearch(search,result);
            logger.info("Cache size : {}",searchCache.getCacheSize());
            return result;
        }
    }
}
