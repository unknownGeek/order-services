package service.wrappers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author ranand
 *
 *         Error class for handling error cases while using
 *         ServiceRequest/ServiceResponse wrappers or in general inside soari
 *         framework.
 *
 */

@SuppressWarnings("restriction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "field", "description", "info", "severity",
        "category", "causes","errorIdentifiers" })
@XmlRootElement(name = "Error")
public class Error implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "code", required = true)
    private String code;

    @XmlElement(name = "field", required = false)
    private String field;

    @XmlElement(name = "description", required = false)
    private String description;

    @XmlElement(name = "info", required = false)
    private String info;

    @XmlElement(name = "severity", required = false)
    private ErrorSeverity severity = ErrorSeverity.ERROR;

    @XmlElement(name = "category", required = false)
    private ErrorCategory category = ErrorCategory.REQUEST;

    @XmlElementWrapper(name = "causes", required = false)
    @XmlElement(name = "cause", required = false)
    private List<Cause> causes;

    @XmlJavaTypeAdapter(MapAdapter.class)
    @XmlElement(name = "errorIdentifiers", required = false)
    private Map<String,Object> errorIdentifiers = new HashMap<String, Object>();

    public Error() {
    }

    public Error(String code, String field, String desc, String info) {
        this.code = code;
        this.field = field;
        this.description = desc;
        this.info = info;
    }

    public Error(String code, String field, String desc, String info,
                 ErrorSeverity severity, ErrorCategory category) {
        this.code = code;
        this.field = field;
        this.description = desc;
        this.info = info;
        this.severity = severity;
        this.category = category;
    }

    public Error(String code, String field, String desc, String info,
                 ErrorSeverity severity, ErrorCategory category, List<Cause> causes) {
        this.code = code;
        this.field = field;
        this.description = desc;
        this.info = info;
        this.severity = severity;
        this.category = category;
        this.causes = causes;
    }

    public Error(String code, String field, String desc, String info,
                 ErrorSeverity severity, ErrorCategory category, List<Cause> causes , Map<String,Object> errorIdentifiers) {
        this.code = code;
        this.field = field;
        this.description = desc;
        this.info = info;
        this.severity = severity;
        this.category = category;
        this.causes = causes;
        this.errorIdentifiers = errorIdentifiers ;
    }

    /**
     * @return returns error code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            - sets the error code.
     * @return
     */
    public Error setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field
     * @return
     */
    public Error setField(String field) {
        this.field = field;
        return this;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            - description of the error.
     * @return
     */
    public Error setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * @return
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     * @return
     */
    public Error setInfo(String info) {
        this.info = info;
        return this;
    }

    /**
     * @return
     */
    public ErrorSeverity getSeverity() {
        return severity;
    }

    /**
     * @param severity
     * @return
     */
    public Error setSeverity(ErrorSeverity severity) {
        this.severity = severity;
        return this;
    }

    /**
     * @return
     */
    public ErrorCategory getCategory() {
        return category;
    }

    /**
     * @param category
     * @return
     */
    public Error setCategory(ErrorCategory category) {
        this.category = category;
        return this;
    }

    /**
     * @return
     */
    public List<Cause> getCauses() {
        if (causes == null) {
            causes = new ArrayList<Cause>();
        }
        return causes;
    }

    /**
     * @param causes
     * @return
     */
    public Error setCauses(List<Cause> causes) {
        getCauses().addAll(causes);
        return this;
    }

    /**
     * @param cause
     * @return
     */
    public Error addCause(Cause cause) {
        getCauses().add(cause);
        return this;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", field=" + field + ", description="
                + description + ", info=" + info + ", severity=" + severity
                + ", category=" + category + ", causes=" + causes + "]";
    }

    public Map<String, Object> getErrorIdentifiers() {
        return errorIdentifiers;
    }



    public void addErrorIdentifiers(String errorKey, Object errorValue) {
        if(getErrorIdentifiers() == null ) {
            this.errorIdentifiers = new HashMap<String, Object>();
        }
        getErrorIdentifiers().put(errorKey, errorValue);
    }


}

