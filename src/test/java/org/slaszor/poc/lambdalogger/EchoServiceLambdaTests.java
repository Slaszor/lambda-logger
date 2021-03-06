package org.slaszor.poc.lambdalogger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EchoServiceLambdaTests {

    @Mock
    Context context;
    @Mock
    APIGatewayProxyRequestEvent requestEvent;

    @Test
    public void handleRequest() {
        String input = "Another example";

        Mockito.when(requestEvent.getBody()).thenReturn(input);

        EchoServiceLambda echoService = new EchoServiceLambda();
        RequestResponse requestResponse = echoService.handleRequest(requestEvent, context);

        assertEquals(input, requestResponse.getBody());

    }
}