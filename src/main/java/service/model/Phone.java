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
public class Phone {

    /**
     * Refers to the country code. This should be a pure number.
     */
    @JsonProperty("countryCode")
    private String countryCode;

    /**
     * Refers to the subscriber number which does not include access codes like
     * country/area code. This should be a pure number.
     */
    @JsonProperty("subscriberNumber")
    private String subscriberNumber;

    /**
     * Refers to the entire number one will typically find in a visiting card.
     * This typically will be (country code) + (subscriber number).
     */
    @JsonProperty("completeNumber")
    private String completeNumber;
}
