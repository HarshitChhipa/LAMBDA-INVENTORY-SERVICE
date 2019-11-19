package com.serverless.inventoryservice.controllers;

import com.serverless.inventoryservice.models.Item;
import com.serverless.inventoryservice.services.Service;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Objects;


@Controller("/v1/item")
public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Inject
    private Service service;

    @Post(produces = MediaType.APPLICATION_JSON)
    public HttpResponse add(@Body Item item) {
        LOGGER.info("Create item -  CreateRequest received: {}", item);
        service.save(item);
        return HttpResponse.created(item);
    }

    @Get(value = "/{itemId}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse get(@PathVariable String itemId) {
        LOGGER.info("Get item -  received: {}", itemId);
        Item item = service.get(itemId);
        return Objects.nonNull(item) ? HttpResponse.ok(item) : HttpResponse.notFound();
    }

    @Put(value = "/{itemId}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse put(@PathVariable String itemId, @Body Item item) {
        LOGGER.info("Put item -  received: {}", item);
        item.setId(itemId);
        service.put(item);
        return HttpResponse.ok(item);
    }

    @Delete(value = "/{itemId}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse delete(@PathVariable String itemId) {
        LOGGER.info("Delete inventory -  received: {}", itemId);
        service.delete(itemId);
        return HttpResponse.ok();
    }

}