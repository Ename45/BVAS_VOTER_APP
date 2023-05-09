package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Gender;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterRepositoryTest {

    private final VoterRepository voterRepository = new BvasVoterRepository();
    Voter savedVoter;

    @BeforeEach
    public void setUp(){
        Voter voter = buildTestVoter();
        savedVoter = voterRepository.save(voter);
    }

    @Test
    public void testSaveVoter(){
        assertNotNull(savedVoter);
        assertNotNull(savedVoter.getVoterId());
    }

    private Voter buildTestVoter(){
        Voter voter = new Voter();
        voter.setName("Inem");
        voter.setAge(20);
        voter.setGender(Gender.FEMALE);
        return voter;
    }

    @Test
    public void testFindById(){
        Voter foundVoter = voterRepository.findById(savedVoter.getVoterId());
        assertNotNull(foundVoter);
    }

    @Test
    public void testFindAllVoters(){
        voterRepository.save(new Voter());
        voterRepository.save(new Voter());

        List<Voter> voters = voterRepository.findAll();
        assertEquals(3, voters.size());
        assertNotNull(voters.get(0));
        assertNotNull(voters.get(1));
        assertNotNull(voters.get(2));
    }

    @Test
    public void testDeleteVoterById(){
        Voter savedSecondVoter = voterRepository.save(new Voter());
        List<Voter> voters = voterRepository.findAll();
        assertEquals(2, voters.size());
        voterRepository.deleteById(savedSecondVoter.getVoterId());
        voters = voterRepository.findAll();
        assertEquals(1, voters.size());
    }
}