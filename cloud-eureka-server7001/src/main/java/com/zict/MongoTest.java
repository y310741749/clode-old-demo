package com.zict;

import javafx.scene.shape.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void test(){
        Query query=new Query();
//        mongoTemplate.find()
    }
}
