package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.CreateElectionRequest;
import africa.semicolon.bvasBeta.dtos.responses.CreateElectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionServiceTest {
    private ElectionService electionService = new BvasElectionService();

    @BeforeEach
    void setUp() {
    }

    @Test
//    void createElectionTest() {
//        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
//        createElectionRequest.setElectionCategory("GUBERNATORIAL");
//        createElectionRequest.setElectionDate("2023-02-25");
//        List<String> parties = getParties();
//        createElectionRequest.setParties(parties);
//        List<String> states = getStates();
//        createElectionRequest.setState(states);
//
//        CreateElectionResponse createElectionResponse = electionService.create(createElectionRequest);
//        assertNotNull(createElectionResponse);
//    }

    private static List<String> getStates() {
        List<String> states = new ArrayList<>();
        states.add("Lagos");
        states.add("Kogi");
        states.add("Kano");
        return states;
    }

    private static List<String> getParties() {
        List<String> parties = new ArrayList<>();
        parties.add("PDP");
        parties.add("TOWN HALL");
        parties.add("APC");
        parties.add("LP");
        return parties;
    }
}