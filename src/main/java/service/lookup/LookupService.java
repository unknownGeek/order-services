package service.lookup;


import service.model.Order;
import service.model.HelloWorld;

import service.wrappers.ServiceResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import java.util.List;


@Path("/v1")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface LookupService {

    @Path("/orders")
    @GET
    ServiceResponse<List<Order>> getCustomerOrders(@Context UriInfo uriInfo, @Context HttpHeaders headers);


    @Path("/sayHello")
    @GET
    ServiceResponse<HelloWorld> getHelloMessage(@Context UriInfo uriInfo);


    @Path("/orders/{orderNo}")
    @GET
    ServiceResponse<Order> getCustomerOrder(@PathParam("orderNo") String orderNo);
}
