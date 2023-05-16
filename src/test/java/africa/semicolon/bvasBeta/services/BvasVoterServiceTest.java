package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.VoterRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.VoterRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static africa.semicolon.bvasBeta.utils.AppUtils.ONE;
import static africa.semicolon.bvasBeta.utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class BvasVoterServiceTest {
    private final VoterService voterService = new BvasVoterService();
//    VoterRepository voterRepository = new BvasVoterRepository();
    VoterRegistrationRequest registrationRequest;
    Voter voter = new Voter();

    @BeforeEach
    void setUp() {
        registrationRequest = buildVoterRegistrationRequest();
    }

    @Test
    void registerTest() {
//        VoterRegistrationRequest registrationRequest = buildVoterRegistrationRequest();
        try {
            VoterRegistrationResponse registrationResponse = voterService.register(registrationRequest);
            assertNotNull(registrationResponse);
            assertNotNull(registrationResponse.getVotersIdentificationNumber());
//            assertEquals(1, voterService);
        }catch (RegistrationException exception){
            System.out.println(exception);
        }
    }

    @Test
    void getAllVotersTest() throws RegistrationException {
        var response = voterService.register(registrationRequest);
        assertNotNull(response);
        List<Voter> voters = voterService.getAllVoters();
        assertEquals(1, voters.size());
        assertNotNull(voters);
    }


    @Test
    public void getVoterByIdTest() throws RegistrationException {
        var registrationResponse = voterService.register(registrationRequest);
        List<Voter> voters = voterService.getAllVoters();
        Voter lastRegisteredVoter = voters.get(voters.size()-1);
        Voter foundVoter = voterService.getUserById(lastRegisteredVoter.getVoterId());
//        Voter foundVoter =
//                voterService.getUserById(voterService.getAllVoters().get(voterService.getAllVoters().size()-1).getVoterId());
        assertNotNull(foundVoter);
        assertEquals(registrationRequest.getName(), foundVoter.getName());
    }

    @Test
    public void deleteVoterByIdTest() throws RegistrationException {
        voterService.register(registrationRequest);
        List<Voter> voters = voterService.getAllVoters();
        assertEquals(ONE, voters.size());
        Voter lastRegisteredVoter = voters.get(voters.size()-ONE);
        Voter foundVoter = voterService.getUserById(lastRegisteredVoter.getVoterId());
        voterService.deleteById(foundVoter.getVoterId());
        assertEquals(0, voterService.getAllVoters().size());
        voters = voterService.getAllVoters();
        assertEquals(ZERO, voters.size());
    }

































    private static VoterRegistrationRequest buildVoterRegistrationRequest() {
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
        return registrationRequest;
    }
}