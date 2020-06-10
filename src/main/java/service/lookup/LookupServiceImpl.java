package service.lookup;

import service.model.Order;
import service.model.HelloWorld;
import service.model.BuyerInfo;
import service.model.Email;
import service.model.PaymentStatus;
import service.model.PersonName;
import service.model.Phone;

import service.wrappers.ServiceResponse;
import service.wrappers.ServiceResponseBuilder;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.util.List;


public class LookupServiceImpl implements LookupService {

    @Override
    public ServiceResponse<List<Order>> getCustomerOrders(UriInfo uriInfo, HttpHeaders headers) {
        return null;
    }

    @Override
    public ServiceResponse<HelloWorld> getHelloMessage(UriInfo uriInfo) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> name = queryParams.get("name");
        HelloWorld helloWorld = new HelloWorld(name.get(0));
        return ServiceResponseBuilder.ok(helloWorld, null);
    }

    @Override
    public ServiceResponse<Order> getCustomerOrder(String orderNo) {
        Order order = getSampleOrder(orderNo);
        return ServiceResponseBuilder.ok(order, null);
    }

    private Order getSampleOrder(String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setPaymentStatus(PaymentStatus.UNPAID);
        order.setBuyerInfo(getSampleBuyerInfo());
        return order;
    }

    private BuyerInfo getSampleBuyerInfo() {
        PersonName name = new PersonName("David", "Williamson", "Cool");
        Phone phone = new Phone("+53", "37642784623", "+53-37642784623");
        Email email = new Email("david.cool@yahoo.com");
        Phone smsMobileNo = new Phone("+53", "73873487238", "+53-73873487238");
        BuyerInfo buyerInfo = new BuyerInfo();
        buyerInfo.setName(name);
        buyerInfo.setPhone(phone);
        buyerInfo.setEmail(email);
        buyerInfo.setSmsMobileNo(smsMobileNo);
        return buyerInfo;
    }

}
