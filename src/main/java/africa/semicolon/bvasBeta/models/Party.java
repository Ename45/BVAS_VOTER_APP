package africa.semicolon.bvasBeta.models;

import lombok.Data;

@Data

public class Party {
    private String partyName;
    private String partyId;
    private UserInformation userInformation;
}
