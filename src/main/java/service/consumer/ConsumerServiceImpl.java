package service.consumer;

import service.jdbc.JDBCConnectionManager;
import service.model.Order;
import service.wrappers.Error;
import service.wrappers.ServiceResponse;
import service.wrappers.ServiceResponseBuilder;
import service.wrappers.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Arrays;


public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public ServiceResponse<String> insertOrder(Order order) {


        try{
            Connection con = JDBCConnectionManager.getDBConnection();
            PreparedStatement preparedStatement = getPreparedStatement(con, order);
            preparedStatement.executeUpdate();
            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            String msg = "Error while preparing Response or closing the JDBC connection";
            System.err.println(msg);
            return ServiceResponseBuilder.response("Insertion Error!", Status.FAIL, null);
        } finally {

        }

        return ServiceResponseBuilder.ok("Order Successfully Inserted!", null);
    }

    private PreparedStatement getPreparedStatement(Connection con, Order order) throws SQLException {
        String sqlQuery = getSqlQuery(order);
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        preparedStatement.setQueryTimeout(60);
        return preparedStatement;
    }

    private String getSqlQuery(Order order) {
        String strInsertQuery = MessageFormat.format("insert into order_data (order_no, first_name, middle_name, last_name, country_code, subscriber_number, email_address, payment_status) VALUES (''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'',''{6}'',''{7}'')", order.getOrderNo(), order.getBuyerInfo().getName().getFirstName(), order.getBuyerInfo().getName().getMiddleName(), order.getBuyerInfo().getName().getLastName(), order.getBuyerInfo().getPhone().getCountryCode(), order.getBuyerInfo().getPhone().getSubscriberNumber(), order.getBuyerInfo().getEmail().getEmailAddress(), order.getPaymentStatus());
        return strInsertQuery;
    }
}
