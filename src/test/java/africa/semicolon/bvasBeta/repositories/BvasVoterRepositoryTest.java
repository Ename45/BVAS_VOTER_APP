package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Gender;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
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


//    Voter voter;
//    VoterRepository voterRepository;
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//        voter = new Voter();
//        voterRepository = new BvasVoterRepository();
//    }

//    @Test
//    @DisplayName("Save a Voter")
//    public void saveOneAVoterTest() {
//        assertEquals(0, voterRepository.countVoter());
//
//        voterRepository.save(voter);
//        assertEquals(1, voterRepository.countVoter());
//    }
//
//    @Test
//    @DisplayName("Save two Voters")
//    public void saveTwoAVoterTest() {
//        voterRepository.save(voter);
//        assertEquals(1, voterRepository.countVoter());
//
//        Voter secondVoter = new Voter();
//        voterRepository.save(secondVoter);
//        assertEquals(2, voterRepository.countVoter());
//    }
//
//    @Test
//    @DisplayName("Can generate ID test for 1 Voter")
//    public void saveOneAVoter_IdCountIsNotNull() {
//        assertNull(voter.getVoterId());
//
//        voterRepository.save(voter);
//        assertEquals("1", voter.getVoterId());
//    }
//
//    @Test
//    @DisplayName("Can generate ID test for 2 Voters")
//    public void saveTwoVoters_IdCountIsNotNull() {
//        assertNull(voter.getVoterId());
//
//        voterRepository.save(voter);
//        assertEquals("1", voter.getVoterId());
//
//        Voter voter1 = new Voter();
//        voterRepository.save(voter1);
//        assertEquals("2", voter1.getVoterId());
//    }
//
//    @Test
//    @DisplayName("Find Voter by ID")
//    public void saveOneVoter_findVoterById_returnsSavedVoterTest() {
//        voter.setName("Inem");
//        voterRepository.save(voter);
//
//        Voter foundVoter = voterRepository.findById("1");
//        assertNotNull(foundVoter.getVoterId());
//        assertEquals(voter, foundVoter);
//        assertEquals(1, voterRepository.countVoter());
//        assertEquals("1", voter.getVoterId());
//        assertEquals("Inem", voter.getName());
//    }
//
//    @Test
//    @DisplayName("Update test")
//    public void saveTwoVotersWithSameId_countIsOneTest(){
//        voter.setName("inem");
//        voterRepository.save(voter);
//        Voter savedOneVoter = voterRepository.findById("1");
//        assertEquals(voter, savedOneVoter);
//
//
//        Voter secondVoter = new Voter();
//        secondVoter.setVoterId("1");
//        voter.setName("Legends");
//
//        voterRepository.save(secondVoter);
//
//        Voter foundVoter = voterRepository.findById("1");
//
//        assertEquals(foundVoter, secondVoter);
//        assertEquals("1", voter.getVoterId());
//        assertNotEquals(foundVoter, voter);
//    }
//
//    @Test
//    @DisplayName("Delete test")
//    public void deleteVoterTest(){
//        Voter voter = new Voter();
//        Voter voter2 = new Voter();
//        Voter voter3 = new Voter();
//
//        voterRepository.save(voter);
//        voterRepository.save(voter2);
//        voterRepository.save(voter3);
//
//        voterRepository.deleteById(voter2.getVoterId());
//
//        assertEquals("1", voter.getVoterId());
//        assertEquals("2", voter2.getVoterId());
//        assertEquals("3", voter3.getVoterId());
//        assertEquals(2, voterRepository.countVoter());
//
//        Voter voter4 = new Voter();
//        voterRepository.save(voter4);
//
//        assertEquals(3, voterRepository.countVoter());
//        assertEquals("3", voter4.getVoterId());
//    }
//
//    @Test
//    @DisplayName("Find all UVoter")
//    public void findAllAVoterTest() {
//        voter.setName("Inem");
//        voterRepository.save(voter);
//
//        Voter voter2 = new Voter();
//        voter2.setName("Joe");
//        voterRepository.save(voter2);
//
//        Voter voter3 = new Voter();
//        voter3.setName("Tony");
//        voterRepository.save(voter3);
//
//        Voter voter4 = new Voter();
//        voter4.setName("Legends");
//        voterRepository.save(voter4);
//
//        Voter voter5 = new Voter();
//        voter5.setName("Ned");
//        voterRepository.save(voter5);
//
//        List<Voter> allVoters = voterRepository.findAll();
//        System.out.println(allVoters);
//        assertEquals(allVoters, voterRepository.findAll());
//    }


}