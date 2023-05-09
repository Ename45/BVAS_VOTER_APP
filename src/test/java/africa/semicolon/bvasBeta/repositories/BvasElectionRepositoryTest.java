package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Election;
import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionRepositoryTest {

    Election savedElection;
    UserInformation userInformation = new UserInformation();
    private final ElectionRepository electionRepository = new BvasElectionRepository(userInformation);

    @BeforeEach
    public void setUp(){
        Election election = new Election();
        savedElection = electionRepository.save(election);
    }

    @Test
    public void testSaveElection(){
        assertNotNull(savedElection);
        assertNotNull(savedElection.getElectionId());
    }

//    private Election buildTestElection(){
//        Election election = new Election();
//        election.setUserInformation(userInformation);
//        return election;
//    }

    @Test
    public void testFindById(){
        Election foundElection = electionRepository.findById(savedElection.getElectionId());
        assertNotNull(foundElection);
    }

    @Test
    public void testFindAllElections(){
        electionRepository.save(new Election());
        electionRepository.save(new Election());

        List<Election> elections = electionRepository.findAll();
        assertEquals(3, elections.size());
        assertNotNull(elections.get(0));
        assertNotNull(elections.get(1));
        assertNotNull(elections.get(2));
    }

    @Test
    public void testDeleteElectionById(){
        Election savedSecondElection = electionRepository.save(new Election());
        List<Election> electionList = electionRepository.findAll();
        assertEquals(2, electionList.size());
        electionRepository.deleteById(savedSecondElection.getElectionId());
        electionList = electionRepository.findAll();
        assertEquals(1, electionList.size());
    }
}