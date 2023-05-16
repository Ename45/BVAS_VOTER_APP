package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.PartyRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.DeletePartyResponse;
import africa.semicolon.bvasBeta.dtos.responses.PartyRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.repositories.BvasPartyRepository;
import africa.semicolon.bvasBeta.repositories.PartyRepository;

import java.util.List;

public class BvasPartyService implements PartyService{
    PartyRepository partyRepository = new BvasPartyRepository();

    @Override
    public PartyRegistrationResponse register(PartyRegistrationRequest partyRegistrationRequest) throws RegistrationException {
        String partyName = partyRegistrationRequest.getPartyName();
        String userName = partyRegistrationRequest.getUsername();
        String password = partyRegistrationRequest.getPassword();

        Party party = new Party();
        party.setPartyName(partyName);
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(userName);
        userInformation.setPassword(password);
        party.setUserInformation(userInformation);

        Party savedParty = partyRepository.save(party);
        if (savedParty == null) throw new RegistrationException("Party registration failed");


        PartyRegistrationResponse partyRegistrationResponse = new PartyRegistrationResponse();
        partyRegistrationResponse.setMessage("Party Registered");
        return partyRegistrationResponse;
    }

    @Override
    public Party getPartyById(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public Party getPartyByName(String name) {
        return partyRepository.findByName(name);
    }

    @Override
    public List<Party> getAllParty() {
        return partyRepository.findAll();
    }

    @Override
    public DeletePartyResponse deleteById(String id) {
        partyRepository.deleteById(id);
        DeletePartyResponse deletePartyResponse = new DeletePartyResponse();
        deletePartyResponse.setMessage("Party deleted");
        return deletePartyResponse;
    }
}
