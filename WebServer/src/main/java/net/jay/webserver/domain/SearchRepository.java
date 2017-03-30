package net.jay.webserver.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by jay on 2017. 3. 30..
 */
public interface SearchRepository extends MongoRepository<SearchVO , String> {

    /*
    Boolean findBySearch(String search);
    */

}
