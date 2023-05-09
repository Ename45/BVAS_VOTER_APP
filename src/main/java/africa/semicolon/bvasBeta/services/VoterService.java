package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;

public interface VoterService {
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest);
}
