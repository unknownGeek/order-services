package service.lookup;

import service.jdbc.JDBCConnectionManager;
import service.model.Order;
import service.model.HelloWorld;
import service.model.BuyerInfo;
import service.model.Email;
import service.model.PaymentStatus;
import service.model.PersonName;
import service.model.Phone;

import service.wrappers.ServiceResponse;
import service.wrappers.ServiceResponseBuilder;
import service.wrappers.Status;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;


public class LookupServiceImpl implements LookupService {

    @Override
    public ServiceResponse<List<Order>> getCustomerOrders(UriInfo uriInfo, HttpHeaders headers) {
        List<Order> orders = new LinkedList<Order>();
        try{
            Connection con = JDBCConnectionManager.getDBConnection();
            String sqlQuery = "Select * from order_data LIMIT 10";
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            preparedStatement.setQueryTimeout(60);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                orders.add(getOrder(resultSet));
            }
            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            String msg = "Error while preparing Response or closing the JDBC connection";
            System.err.println(msg);
            return ServiceResponseBuilder.response(null, Status.FAIL, null);
        } finally {

        }

        return ServiceResponseBuilder.response(orders, orders.isEmpty() ? Status.NOT_FOUND : Status.OK, null);
    }


    @Override
    public ServiceResponse<HelloWorld> getHelloMessage(UriInfo uriInfo) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> name = queryParams.get("name");
        HelloWorld helloWorld = new HelloWorld(name.get(0));
        return ServiceResponseBuilder.ok(helloWorld,  null);
    }

    private Order getOrder(ResultSet resultSet) throws SQLException {
        String orderNum = resultSet.getString(1);
        PersonName personName = new PersonName(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        Phone phone = new Phone(resultSet.getString(5), resultSet.getString(6), resultSet.getString(5)+"-"+resultSet.getString(6));
        Email email = new Email(resultSet.getString(7));
        PaymentStatus paymentStatus = PaymentStatus.fromDescription(resultSet.getString(8));
        Order order = new Order(orderNum, new BuyerInfo(personName, phone, email, null), paymentStatus);
        return order;
    }

    @Override
    public ServiceResponse<Order> getCustomerOrder(String orderNo) {
//        Order order = getSampleOrder(orderNo);
        Order order = null;
        try{
            Connection con = JDBCConnectionManager.getDBConnection();
            PreparedStatement preparedStatement = getPreparedStatement(con, orderNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                order = getOrder(resultSet);
            }
            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            String msg = "Error while preparing Response or closing the JDBC connection";
            System.err.println(msg);
            return ServiceResponseBuilder.response(null, Status.FAIL, null);
        } finally {

        }
        return ServiceResponseBuilder.response(order, order == null ? Status.NOT_FOUND : Status.OK, null);
    }

    private PreparedStatement getPreparedStatement(Connection con, String orderNo) throws SQLException {
        String sqlQuery = getSqlQuery(orderNo);
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        preparedStatement.setQueryTimeout(60);
        return preparedStatement;
    }

    private String getSqlQuery(String orderNo) {
        String strInsertQuery = MessageFormat.format("Select * from order_data where order_no = ''{0}''", orderNo);
        return strInsertQuery;
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
