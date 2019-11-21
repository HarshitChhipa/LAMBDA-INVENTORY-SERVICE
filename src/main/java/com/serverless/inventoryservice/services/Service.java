package com.serverless.inventoryservice.services;

import com.serverless.inventoryservice.models.Item;
import com.serverless.inventoryservice.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Singleton
public class Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    @Inject
    Repository repository;

    public void save(Item item) {
        LOGGER.info("Saving Item ...");
        item.setId(UUID.randomUUID().toString());
        repository.save(item);
        LOGGER.info("Item Saved...");

    }

    public Item get(String itemId) {
        LOGGER.info("Getting Item for : {}", itemId);
        return repository.get(itemId);
    }

    public void put(Item item) {
        LOGGER.info("Putting Item for : {}", item);
        repository.save(item);
    }

    public void delete(String itemId) {
        LOGGER.info("Delete Item for : {}", itemId);
        repository.delete(itemId);
    }

    public void putAll(List<Item> items) {
        if (Objects.nonNull(items))
            items.forEach(item -> put(item));
    }
}
