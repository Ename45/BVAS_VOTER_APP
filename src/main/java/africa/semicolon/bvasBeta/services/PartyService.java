package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.PartyRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.DeletePartyResponse;
import africa.semicolon.bvasBeta.dtos.responses.DeleteVoterResponse;
import africa.semicolon.bvasBeta.dtos.responses.PartyRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Party;

import java.util.List;

public interface PartyService {
    public PartyRegistrationResponse register(PartyRegistrationRequest partyRegistrationRequest) throws RegistrationException;
    Party getPartyById(String id);
    Party getPartyByName(String name);
    List<Party> getAllParty();
    DeletePartyResponse deleteById(String id);
}
