package com.github.liurui.mongobeat.repositories;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoInput  implements   MongoInputable{
    public  static  final Logger LOGGER  = LoggerFactory.getLogger(MongoInput.class);

    @Autowired
    MongoTemplate  mongoTemplate;


    @Override
    public void count(){
        DBCollection collection = mongoTemplate.getCollection("UserInfo");

        BasicDBObjectBuilder basicDBObjectBuilder = new BasicDBObjectBuilder();

        basicDBObjectBuilder.add("_id" , new BasicDBObject("$gt" , "5775b50859242e007cf54e85"));

        List<DBObject> dbObjects = collection.find(basicDBObjectBuilder.get()).toArray();

        for (DBObject dbObject : dbObjects) {
            LOGGER.info("-----------------");
            for (String key : dbObject.keySet()) {
                LOGGER.info("{}:{}" , key , dbObject.get(key));
            }
        }
    }
}
