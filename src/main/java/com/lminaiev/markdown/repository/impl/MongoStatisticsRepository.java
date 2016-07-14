package com.lminaiev.markdown.repository.impl;

import com.lminaiev.markdown.entity.StatisticsRecord;
import com.lminaiev.markdown.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoStatisticsRepository implements StatisticsRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void save(StatisticsRecord record) {
        mongoTemplate.save(record);
    }

    @Override
    public List<StatisticsRecord> getAllRecords() {
        return mongoTemplate.findAll(StatisticsRecord.class);
    }


}
