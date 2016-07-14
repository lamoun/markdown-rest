package com.lminaiev.markdown.config.live;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Configuration for mongo
 *
 * @author Leonid Minaiev
 */
@Profile("live")
@Configuration
@EnableMongoRepositories
public class MongoConfigLive extends AbstractMongoConfiguration {

    @Value("${OPENSHIFT_MONGODB_DB_HOST}")
    private String  host;

    @Value("${OPENSHIFT_MONGODB_DB_PORT}")
    private Integer port;

    @Value("${OPENSHIFT_MONGODB_DB_USERNAME}")
    private String  userName;

    @Value("${OPENSHIFT_MONGODB_DB_PASSWORD}")
    private String  password;


    @Override
    protected String getDatabaseName() {
        return "markdownrest";
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential = MongoCredential.createMongoCRCredential(userName, getDatabaseName(), password.toCharArray());
        ServerAddress adr = new ServerAddress(host, port);
        return new MongoClient(adr, Arrays.asList(credential));
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.lminaiev.markup.entity";
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception
    {

        MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getDatabaseName());
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;
    }
}