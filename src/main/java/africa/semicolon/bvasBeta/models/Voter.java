package africa.semicolon.bvasBeta.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Voter {
    private String voterId;
    private UserInformation userInformation;
    private String voterIdentificationNumber;
    private Gender gender;
    private String name;
    private Address address;
    private Integer age;
}
