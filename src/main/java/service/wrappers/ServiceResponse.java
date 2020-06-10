package service.wrappers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ServiceResponse wrapper class to be used for service request/response
 * invocations
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceResponse", propOrder = { "status", "errors", "header",
        "payload" })
@XmlRootElement(name = "ServiceResponse")
public class ServiceResponse<T> implements Serializable {

    /**
     * class version ID for serialization
     */
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "status", required = true)
    private Status status = Status.FAIL;

    @XmlElement(name = "header", required = false)
    private ServiceHeader header;

    @XmlElementWrapper(name = "errors", required = false)
    @XmlElement(name = "error", required = false)
    private List<Error> errors;

    private T payload;

    /**
     * no-arg constructor
     */
    public ServiceResponse() {
        super();
    }

    /**
     *
     * @param header
     * @param payload
     */
    public ServiceResponse(ServiceHeader header, T payload) {
        this.header = header;
        this.payload = payload;
    }

    /**
     * Returns the ServiceHeader.
     *
     * @return
     */
    public ServiceHeader getHeader() {
        if (header == null) {
            header = new ServiceHeader();
        }
        return header;
    }

    /**
     * Sets the header to ServiceResponse.
     *
     * @param header
     * @return
     */
    public ServiceHeader setHeader(ServiceHeader header) {
        this.header = header;
        return this.header;
    }

    /**
     * @return
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Sets the payload to ServiceResponse.
     *
     * @param payload
     * @return
     */
    public ServiceResponse setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    /**
     * @return
     */
    public List<Error> getErrors() {
        if (errors == null) {
            errors = new ArrayList<Error>();
        }
        return errors;
    }

    /**
     * Adds an error instance to service response error list.
     *
     * @param error
     * @return
     */
    public ServiceResponse addError(Error error) {
        getErrors().add(error);
        return this;
    }

    /**
     * Sets a list of errors to ServiceResponse.
     *
     * @param errors
     * @return
     */
    public ServiceResponse setErrors(List<Error> errors) {
        getErrors().addAll(errors);
        return this;
    }

    /**
     * Gets the status.
     *
     * @return
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status to ServiceResponse.
     *
     * @param status
     * @return
     */
    public ServiceResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "ServiceResponse [status=" + status + ", header=" + header
                + ", errors=" + errors + ", payload=" + payload + "]";
    }

}

