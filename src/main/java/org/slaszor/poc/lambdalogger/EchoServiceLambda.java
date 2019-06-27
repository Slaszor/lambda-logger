package org.slaszor.poc.lambdalogger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Map;

public class EchoServiceLambda implements RequestHandler<APIGatewayProxyRequestEvent, RequestResponse> {

    private static final Logger LOG = LogManager.getLogger(EchoServiceLambda.class);

    @Override
    public RequestResponse handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        String inputBody = input.getBody();

        LOG.info(" !! SUCCESS !! ");

        Map<String, String> headers = new HashMap<>();
        headers.put("version", "0.0.1");

        return RequestResponse.builder()
                .setHeaders(headers)
                .setRawBody(inputBody)
                .setStatusCode(200)
                .build();
    }
}
