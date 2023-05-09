package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Gender;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasUserInformationRepositoryTest {

    UserInformation userInformation = new UserInformation();
    private final UserInformationRepository userInformationRepository = new BvasUserInformationRepository(userInformation);
    UserInformation savedUserInformation;

    @BeforeEach
    public void setUp(){
        UserInformation userInformation = buildTestUserInformation();
        savedUserInformation = userInformationRepository.save(userInformation);
    }

    @Test
    public void testSaveUserInformation(){
        assertNotNull(savedUserInformation);
        assertNotNull(savedUserInformation.getId());
    }

    private UserInformation buildTestUserInformation(){
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername("Inem");
        return userInformation;
    }

    @Test
    public void testFindById(){
        UserInformation foundUserInformation = userInformationRepository.findById(savedUserInformation.getId());
        assertNotNull(foundUserInformation);
    }

    @Test
    public void testFindAllUserInformations(){
        userInformationRepository.save(new UserInformation());
        userInformationRepository.save(new UserInformation());

        List<UserInformation> userInformationList = userInformationRepository.findAll();
        assertEquals(3, userInformationList.size());
        assertNotNull(userInformationList.get(0));
        assertNotNull(userInformationList.get(1));
        assertNotNull(userInformationList.get(2));
    }

    @Test
    public void testDeleteUserInformationById(){
        UserInformation savedSecondUserInformation = userInformationRepository.save(new UserInformation());
        List<UserInformation> userInformationList = userInformationRepository.findAll();
        assertEquals(2, userInformationList.size());
        userInformationRepository.deleteById(savedSecondUserInformation.getId());
        userInformationList = userInformationRepository.findAll();
        assertEquals(1, userInformationList.size());
    }

}