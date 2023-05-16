package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.DeleteVoterResponse;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Voter;

import java.util.List;

public interface VoterService {
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws RegistrationException;
    Voter getUserById(String id);
    List<Voter> getAllVoters();
    DeleteVoterResponse deleteById(String id);
}
