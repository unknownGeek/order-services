package service.consumer;


import service.model.Order;
import service.wrappers.ServiceResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ConsumerService {

    @Path("/insert")
    @POST
    ServiceResponse<String> insertOrder(Order order);
}
