package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdminRepositoryTest {

    Admin savedAdmin;
    UserInformation userInformation = new UserInformation();
    private final AdminRepository adminRepository = new BvasAdminRepository(userInformation);

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


//
//    Admin admin;
//    AdminRepository adminRepository;
//    UserInformation userInformation;
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//        admin = new Admin();
//        adminRepository = new BvasAdminRepository();
//        userInformation = new UserInformation();
//    }
//
//    @Test
//    @DisplayName("Save a Admin")
//    public void saveOneAdminTest() {
//        assertEquals(0, adminRepository.countAdmin());
//
//        adminRepository.save(admin);
//        assertEquals(1, adminRepository.countAdmin());
//    }
//
//    @Test
//    @DisplayName("Save two Admins")
//    public void saveTwoAdminTest() {
//        adminRepository.save(admin);
//        assertEquals(1, adminRepository.countAdmin());
//
//        Admin secondAdmin = new Admin();
//        adminRepository.save(secondAdmin);
//        assertEquals(2, adminRepository.countAdmin());
//    }
//
//    @Test
//    @DisplayName("Can generate ID test for 1 Admin")
//    public void saveOneAdmin_IdCountIsNotNull() {
//        assertNull(admin.getAdminId());
//
//        adminRepository.save(admin);
//        assertEquals("1", admin.getAdminId());
//    }
//
//    @Test
//    @DisplayName("Can generate ID test for 2 Admins")
//    public void saveTwoAdmins_IdCountIsNotNull() {
//        assertNull(admin.getAdminId());
//
//        adminRepository.save(admin);
//        assertEquals("1", admin.getAdminId());
//
//        Admin admin1 = new Admin();
//        adminRepository.save(admin1);
//        assertEquals("2", admin1.getAdminId());
//    }
//
//    @Test
//    @DisplayName("Find Admin by ID")
//    public void saveOneAdmin_findAdminById_returnsSavedAdminTest() {
//        userInformation.setUsername("Inem");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin);
//
//        Admin foundAdmin = adminRepository.findById("1");
//        assertNotNull(foundAdmin.getAdminId());
//        assertEquals(admin, foundAdmin);
//        assertEquals(1, adminRepository.countAdmin());
//        assertEquals("1", admin.getAdminId());
//        assertEquals("Inem", admin.getUserInformation().getUsername());
//    }
//
//    @Test
//    @DisplayName("Update test")
//    public void saveTwoAdminsWithSameId_countIsOneTest(){
//        userInformation.setUsername("Inem");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin);
//        Admin savedOneAdmin = adminRepository.findById("1");
//        assertEquals(admin, savedOneAdmin);
//
//
//        Admin secondAdmin = new Admin();
//        secondAdmin.setAdminId("1");
//        userInformation.setUsername("Legends");
//        admin.setUserInformation(userInformation);
//
//        adminRepository.save(secondAdmin);
//
//        Admin foundAdmin = adminRepository.findById("1");
//
//        assertEquals(foundAdmin, secondAdmin);
//        assertEquals("1", admin.getAdminId());
//        assertNotEquals(foundAdmin, admin);
//    }
//
//    @Test
//    @DisplayName("Delete test")
//    public void deleteAdminTest(){
//        Admin admin = new Admin();
//        Admin admin2 = new Admin();
//        Admin admin3 = new Admin();
//
//        adminRepository.save(admin);
//        adminRepository.save(admin2);
//        adminRepository.save(admin3);
//
//        adminRepository.deleteById(admin2.getAdminId());
//
//        assertEquals("1", admin.getAdminId());
//        assertEquals("2", admin2.getAdminId());
//        assertEquals("3", admin3.getAdminId());
//        assertEquals(2, adminRepository.countAdmin());
//
//        Admin admin4 = new Admin();
//        adminRepository.save(admin4);
//
//        assertEquals(3, adminRepository.countAdmin());
//        assertEquals("3", admin4.getAdminId());
//    }
//
//    @Test
//    @DisplayName("Find all Admin")
//    public void findAllAdminTest() {
//        userInformation.setUsername("Inem");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin);
//
//        Admin admin2 = new Admin();
//        userInformation.setUsername("Joe");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin2);
//
//        Admin admin3 = new Admin();
//        userInformation.setUsername("Tony");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin3);
//
//        Admin admin4 = new Admin();
//        userInformation.setUsername("Legends");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin4);
//
//        Admin admin5 = new Admin();
//        userInformation.setUsername("Ned");
//        admin.setUserInformation(userInformation);
//        adminRepository.save(admin5);
//
//        List<Admin> allAdmins = adminRepository.findAll();
//        System.out.println(allAdmins);
//        assertEquals(allAdmins, adminRepository.findAll());
//    }

}