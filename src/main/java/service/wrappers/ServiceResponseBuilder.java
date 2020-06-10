package service.wrappers;

import java.util.List;

public class ServiceResponseBuilder {
    private ServiceResponseBuilder() {
    }

    /* Service response for failure scenario */
    public static <T> ServiceResponse<T> fail(ServiceHeader header, List<Error> errors) {

        ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
        serviceResponse.setErrors(errors);
        serviceResponse.setStatus(Status.FAIL);
        serviceResponse.setHeader(header);
        return serviceResponse;
    }

    /* Service response for partial scenario */
    public static <T> ServiceResponse<T> partial(T response, ServiceHeader header) {

        ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
        serviceResponse.setStatus(Status.PARTIAL);
        serviceResponse.setHeader(header);
        serviceResponse.setPayload(response);
        return serviceResponse;
    }

    /* Service response for successful scenario */
    public static <T> ServiceResponse<T> ok(T response, ServiceHeader header) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
        serviceResponse.setPayload(response);
        serviceResponse.setStatus(Status.OK);
        serviceResponse.setHeader(header);
        return serviceResponse;
    }

    /* Service response for all (Successful, Partial and Failure) scenarios */
    public static <T> ServiceResponse<T> response(T response, Status status, ServiceHeader header) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<T>();
        serviceResponse.setPayload(response);
        serviceResponse.setStatus(status);
        serviceResponse.setHeader(header);
        return serviceResponse;
    }

}
