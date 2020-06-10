package service.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @JsonProperty("orderNo")
    private String orderNo;

    @JsonProperty("buyerInfo")
    private BuyerInfo buyerInfo;

    private PaymentStatus paymentStatus;
//
//
//    @JsonSerialize(using = JsonDateSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
//    @JsonDeserialize(using = JsonDateDeserializer.class)
//    @JsonProperty("orderDate")
//    private Date orderDate;
}
