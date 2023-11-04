package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataPojo {
    public String password;
    public String firstName;
    public String lastName;
    public String dateOfBirth;
    @JsonProperty("country")
    public String country;
    @JsonProperty("city")
    public String city;
    @JsonProperty("street")
    public String street;
    @JsonProperty("streetNumber")
    public String streetNumber;
    @JsonProperty("flat")
    public String flat;
    @JsonProperty("zipCode")
    public String zipCode;
    @JsonProperty("phoneNumber")
    public String phoneNumber;

}
