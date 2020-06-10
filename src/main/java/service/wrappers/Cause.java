package service.wrappers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "field","type","description" })
@XmlRootElement(name = "Cause")
public class Cause implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "code", required = false)
    private String code;

    @XmlElement(name = "field", required = false)
    private String field;

    @XmlElement(name = "type", required = false)
    private String type;

    @XmlElement(name = "description", required = false)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cause [code=" + code + ", field=" + field + ", type=" + type
                + ", description=" + description + "]";
    }

}
