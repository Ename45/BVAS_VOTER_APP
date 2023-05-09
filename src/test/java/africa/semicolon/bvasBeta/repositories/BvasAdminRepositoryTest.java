package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdminRepositoryTest {

    Admin savedAdmin;
    private UserInformation userInformation = new UserInformation();
    private final AdminRepository adminRepository = new BvasAdminRepository();

    @BeforeEach
    public void setUp(){
        Admin admin = buildTestAdmin();
        savedAdmin = adminRepository.save(admin);
    }

    @Test
    public void testSaveAdmin(){
        assertNotNull(savedAdmin);
        assertNotNull(savedAdmin.getAdminId());
    }

    private Admin buildTestAdmin(){
        Admin admin = new Admin();
        userInformation.setUsername("Inem");
        userInformation.setPassword("1234");
        admin.setUserInformation(userInformation);
        return admin;
    }

    @Test
    public void testFindById(){
        Admin foundAdmin = adminRepository.findById(savedAdmin.getAdminId());
        assertNotNull(foundAdmin);
        assertNotNull(foundAdmin.getUserInformation());
    }

    @Test
    public void testFindAllAdmins(){
        adminRepository.save(new Admin());
        adminRepository.save(new Admin());

        List<Admin> admins = adminRepository.findAll();
        assertEquals(3, admins.size());
        assertNotNull(admins.get(0));
        assertNotNull(admins.get(1));
        assertNotNull(admins.get(2));
    }

    @Test
    public void testDeleteAdminById(){
        Admin savedSecondAdmin = adminRepository.save(new Admin());
        List<Admin> adminList = adminRepository.findAll();
        assertEquals(2, adminList.size());
        adminRepository.deleteById(savedSecondAdmin.getAdminId());
        adminList = adminRepository.findAll();
        assertEquals(1, adminList.size());
    }
}