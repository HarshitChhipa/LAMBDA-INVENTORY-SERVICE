package com.serverless.inventoryservice.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.serverless.inventoryservice.models.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Repository {
    private final DynamoDBMapper mapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(Repository.class);

    public Repository() {
        this(new DbMapper().getMapper());
    }

    Repository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public void save(Item item) {
        LOGGER.info("Saving Item : {}", item);
        mapper.save(item);
        LOGGER.info("Item saved successfully");
    }


    public Item get(String itemId) {
        LOGGER.info("Getting Item : {}", itemId);
        return mapper.load(Item.class, itemId);
    }

    public void delete(String itemId) {
        LOGGER.info("Delete Item : {}", itemId);
        mapper.delete(get(itemId));
    }
}