package service.consumer;

import service.model.Order;
import service.wrappers.ServiceResponse;
import service.wrappers.ServiceResponseBuilder;

public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public ServiceResponse<Order> insertOrder(Order order) {
        return ServiceResponseBuilder.ok(order, null);
    }

}
