package africa.semicolon.bvasBeta.dtos.requests;

import lombok.Data;

@Data
public class PartyRegistrationRequest {
    private String partyName;
    private String username;
    private String password;
}
