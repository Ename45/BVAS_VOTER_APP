package africa.semicolon.bvasBeta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    private String addressId;
    private String houseNumber;
    private String street;
    private String town;
    private String localGovernmentArea;
    private String state;
}
