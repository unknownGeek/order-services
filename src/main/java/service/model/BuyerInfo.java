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
public class BuyerInfo {

    @JsonProperty("name")
    private PersonName name;

    @JsonProperty("phone")
    private Phone phone;

    @JsonProperty("email")
    private Email email;

    @JsonProperty("smsMobileNo")
    private Phone smsMobileNo;
}
