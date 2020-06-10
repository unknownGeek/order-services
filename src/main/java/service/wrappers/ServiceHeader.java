package service.wrappers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ServiceHeader class is used to hold service specific header values that needs
 * to be passed as payload.
 *
 * @author sdikshi
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceHeader", propOrder = {"headerAttributes"})
@XmlRootElement(name = "ServiceHeader")
public class ServiceHeader implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Map<String, Object> headerAttributes;

    /**
     *
     */
    public ServiceHeader() {
        super();
    }

    /**
     *
     * @param headerAttributes
     */
    public ServiceHeader(Map<String, Object> headerAttributes) {
        super();
        this.headerAttributes = headerAttributes;
    }

    /**
     * @return
     */
    public Map<String, Object> getHeaderAttributes() {
        if (headerAttributes == null) {
            headerAttributes = new HashMap<String, Object>();
        }
        return headerAttributes;
    }

    /**
     * @param headerAttributes
     * @return
     */
    public ServiceHeader setHeaderAttributes(
            Map<String, Object> headerAttributes) {
        this.headerAttributes = headerAttributes;
        return this;
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public ServiceHeader addHeaderAttribute(String key, Object value) {
        getHeaderAttributes().put(key, value);
        return this;
    }

    /**
     * @param key
     * @return
     */
    public Object getHeaderAttribute(String key) {
        return getHeaderAttributes().get(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean containsHeaderAttribute(String key) {
        return getHeaderAttributes().containsKey(key);
    }

    /**
     * @param key
     * @return
     */
    public Object removeHeaderAttribute(String key) {
        return getHeaderAttributes().remove(key);
    }

    @Override
    public String toString() {
        return "ServiceHeader [headerAttributes=" + headerAttributes + "]";
    }

}
