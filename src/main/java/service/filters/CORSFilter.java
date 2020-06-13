package service.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext containerResponseContext) {
        MultivaluedMap<String, Object> containerResponseContextMap = containerResponseContext.getHeaders();
        containerResponseContextMap.add("Access-Control-Allow-Origin", "*");
        containerResponseContextMap.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        containerResponseContextMap.add("Access-Control-Allow-Credentials", "true");
        containerResponseContextMap.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        containerResponseContextMap.add("Access-Control-Max-Age", "1209600");
    }

}