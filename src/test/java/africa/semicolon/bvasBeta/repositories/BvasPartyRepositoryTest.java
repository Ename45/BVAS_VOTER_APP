package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasPartyRepositoryTest {

    Party savedParty;
    private UserInformation userInformation = new UserInformation();
    private final PartyRepository partyRepository = new BvasPartyRepository();

    @BeforeEach
    public void setUp(){
        Party party = buildTestParty();
        savedParty = partyRepository.save(party);
    }

    @Test
    public void testSaveParty(){
        assertNotNull(savedParty);
        assertNotNull(savedParty.getPartyId());
    }

    private Party buildTestParty(){
        Party party = new Party();
        userInformation.setUsername("Inem");
        party.setUserInformation(userInformation);
        return party;
    }

    @Test
    public void testFindById(){
        Party foundParty = partyRepository.findById(savedParty.getPartyId());
        assertNotNull(foundParty);
    }

    @Test
    public void testFindAllPartys(){
        partyRepository.save(new Party());
        partyRepository.save(new Party());

        List<Party> partys = partyRepository.findAll();
        assertEquals(3, partys.size());
        assertNotNull(partys.get(0));
        assertNotNull(partys.get(1));
        assertNotNull(partys.get(2));
    }

    @Test
    public void testDeletePartyById(){
        Party savedSecondParty = partyRepository.save(new Party());
        List<Party> partyList = partyRepository.findAll();
        assertEquals(2, partyList.size());
        partyRepository.deleteById(savedSecondParty.getPartyId());
        partyList = partyRepository.findAll();
        assertEquals(1, partyList.size());
    }
}