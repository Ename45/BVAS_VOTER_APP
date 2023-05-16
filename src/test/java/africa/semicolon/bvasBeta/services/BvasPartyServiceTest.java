package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.PartyRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.PartyRegistrationResponse;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static africa.semicolon.bvasBeta.utils.AppUtils.ONE;
import static africa.semicolon.bvasBeta.utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class BvasPartyServiceTest {

    PartyService partyService;
    PartyRegistrationRequest partyRegistrationRequest;
    PartyRegistrationResponse partyRegistrationResponse;
    @BeforeEach
    void setUp() {
        partyService = new BvasPartyService();
        partyRegistrationRequest = new PartyRegistrationRequest();
        partyRegistrationResponse = new PartyRegistrationResponse();
    }

    @Test
    void registerTest() throws RegistrationException {
        PartyRegistrationRequest partyRegistrationRequest = buildPartyRegistrationRequest();

        PartyRegistrationResponse partyRegistrationResponse = partyService.register(partyRegistrationRequest);
        assertNotNull(partyRegistrationResponse);
        assertNotNull(partyRegistrationResponse.getMessage());
    }
    private static PartyRegistrationRequest buildPartyRegistrationRequest() {
        PartyRegistrationRequest partyRegistrationRequest = new PartyRegistrationRequest();
        partyRegistrationRequest.setPartyName("Labour Party");
        partyRegistrationRequest.setUsername("LP");
        partyRegistrationRequest.setPassword("1234");
        return partyRegistrationRequest;
    }

    @Test
    void getPartyByIdTest() throws RegistrationException {
        var registrationResponse = partyService.register(partyRegistrationRequest);
        List<Party> partyList = partyService.getAllParty();
        Party lastRegisteredParty = partyList.get(partyList.size()-1);
        Party foundParty = partyService.getPartyById(lastRegisteredParty.getPartyId());
        assertNotNull(foundParty);
        assertEquals(partyRegistrationRequest.getPartyName(), foundParty.getPartyName());
    }

    @Test
    void getPartyByNameTest() throws RegistrationException {
        partyRegistrationRequest.setPartyName("Labour Party");
        var registrationResponse = partyService.register(partyRegistrationRequest);
        List<Party> partyList = partyService.getAllParty();
        Party lastRegisteredParty = partyList.get(partyList.size()-1);
        Party foundParty = partyService.getPartyByName(lastRegisteredParty.getPartyName());
        assertNotNull(foundParty);
        assertEquals(partyRegistrationRequest.getPartyName(), foundParty.getPartyName());
    }

    @Test
    void getAllPartyTest() throws RegistrationException {
        var response = partyService.register(partyRegistrationRequest);
        assertNotNull(response);
        List<Party> partyList = partyService.getAllParty();
        assertEquals(1, partyList.size());
        assertNotNull(partyList);
    }

    @Test
    void deleteByIdTest() throws RegistrationException {
        partyService.register(partyRegistrationRequest);
        List<Party> partyList = partyService.getAllParty();
        assertEquals(ONE, partyList.size());
        Party lastRegisteredParty = partyList.get(partyList.size()-ONE);
        Party foundParty = partyService.getPartyById(lastRegisteredParty.getPartyId());
        partyService.deleteById(foundParty.getPartyId());
        assertEquals(0, partyService.getAllParty().size());
        partyList = partyService.getAllParty();
        assertEquals(ZERO, partyList.size());
    }
}