package net.jay.webserver.cache;

import net.jay.webserver.domain.SearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by jay on 2017. 3. 30..
 */
public class SearchCache {
    public final static int CACHE_MAX_SIZE = 5;
    public final static int QUEUE_MAX_SIZE = 10;

    private Map<String, Object[]> cache;
    private List<String> requsetQueue;
    
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    public SearchCache() {
        requsetQueue = Collections.synchronizedList(new ArrayList<>(QUEUE_MAX_SIZE));
        cache = Collections.synchronizedMap(new HashMap<String, Object[]>(0,0.75f));
    }

    public void addRequestSearch(String search){
        if(requsetQueue.size() > QUEUE_MAX_SIZE){
            requsetQueue.remove(requsetQueue.size()-1);
            for(String str : requsetQueue)
                logger.info("Queue data : {}", str);
        }
        requsetQueue.add(0,search);
    }

    private String findSearchVO(){
        String ret ="";

        Iterator<String> iterator = cache.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            logger.info("Contains : {}",key );
            if(!requsetQueue.contains(key)) ret = key;
        }

        if(ret.equals("")) {

            Map<String, Integer> map = new HashMap<>();
            int i = 0;
            for(String str : requsetQueue){
                if(!map.containsKey(str)){
                    map.put(str, i);
                }
            }
            Iterator<String> it = map.keySet().iterator();
            int max = 0;
            while(it.hasNext()){
                String key = it.next();
                int val = map.get(key);
                if(max < val ){
                    ret = key;
                    max = val;
                }
            }
        }

        return ret;
    }

    public int getRequsetQueueSize() {
        return requsetQueue.size();
    }


    public boolean hasSearch(String search){
        return (cache.containsKey(search) ? true : false);
    }

    public  void addSearch(String search, Object[] data){
        cache.put(search,data);
    }

    public Object[] getSearch(String search){
        return cache.get(search);
    }

    public SearchVO removeSearchVO(){
        String removeSearch = findSearchVO();
        Object[] removeData = cache.get(removeSearch).clone();
        cache.remove(removeData);
        return new SearchVO(removeSearch,removeData) ;
    }

    public int getCacheSize() {
        return cache.size();
    }
}
