package com.serverless.inventoryservice.functions;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ItemFunction implements RequestStreamHandler {
    private static Logger logger = LoggerFactory.getLogger(ItemFunction.class);
    private static MicronautLambdaContainerHandler handler;
    static {
        try {
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler();
        } catch (ContainerInitializationException e) {
            logger.error("Error in initializing Lambda Proxy", e);
        }
    }


    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        handler.proxyStream(input, output, context);
    }
}
