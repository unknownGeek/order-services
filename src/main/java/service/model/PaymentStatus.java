package service.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum PaymentStatus {

    PAID("PAID"),
    AUTHORIZED("AUTHORIZED"),
    NOT_APPLICABLE("NOT_APPLICABLE"),
    AWAIT_AUTH("AWAIT_AUTH"),
    FAILED_AUTH("FAILED_AUTH"),
    AWAIT_PAYMENT("AWAIT_PAYMENT"),
    REFUND_DUE("REFUND_DUE"),
    AWAIT_PAY_INFO("AWAIT_PAY_INFO"),
    UNPAID("UNPAID");

    private final String description;

    PaymentStatus(final String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }

    @JsonCreator
    public static PaymentStatus fromDescription(String desc) {
        if(desc == null) {
            return null;
        }
        for(PaymentStatus option : PaymentStatus.values()) {
            if(desc.equals(option.getDescription())) {
                return option;
            }
        }
        return null;
    }

}