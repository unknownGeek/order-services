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
@NoArgsConstructor
@AllArgsConstructor
public class PersonName {

    /**
     * First name of an individual.
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * Middle name of an individual.
     */
    @JsonProperty("middleName")
    private String middleName;

    /**
     * Last name of an individual.
     */
    @JsonProperty("lastName")
    private String lastName;
}
