package africa.semicolon.bvasBeta.dtos.requests;

import lombok.Data;

@Data
public class VoterRegistrationRequest {
    private String name;
    private String userName;
    private String password;
    private String houseNumber;
    private String street;
    private String town;
    private String state;
    private String lga;
    private String gender;
    private int age;
}
