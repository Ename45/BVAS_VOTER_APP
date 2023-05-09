package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.repositories.BvasVoterRepository;
import africa.semicolon.bvasBeta.repositories.VoterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterServiceTest {
    private final VoterService voterService = new BvasVoterService();
    VoterRepository voterRepository = new BvasVoterRepository();
    Voter voter = new Voter();

    @BeforeEach
    void setUp() {

    }

    @Test
    void registerTest() {
        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(40);
        registrationRequest.setName("Inem");
        registrationRequest.setLga("town hall");
        registrationRequest.setGender("Female");
        registrationRequest.setPassword("1234");
        registrationRequest.setState("Lagos");
        registrationRequest.setStreet("Sabo");
        registrationRequest.setTown("Main Sabo");
        registrationRequest.setUserName("ename");
        registrationRequest.setHouseNumber("4");

        VoterRegistrationResponse registrationResponse = voterService.register(registrationRequest);

        assertEquals(1, voterRepository.findAll().size());
        assertNotNull(voter.getVoterId());
        assertNotNull(registrationResponse);
        assertNotNull(registrationResponse.getVotersIdentificationNumber());
    }
}