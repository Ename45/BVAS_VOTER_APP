package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.AdminRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.requests.PartyRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.AdminRegistrationResponse;
import africa.semicolon.bvasBeta.dtos.responses.PartyRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static africa.semicolon.bvasBeta.utils.AppUtils.ONE;
import static africa.semicolon.bvasBeta.utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class BvasAdminServiceTest {

    AdminService adminService;
    AdminRegistrationRequest adminRegistrationRequest;
    AdminRegistrationResponse adminRegistrationResponse;
    @BeforeEach
    void setUp() {
        adminService = new BvasAdminService();
        adminRegistrationRequest = new AdminRegistrationRequest();
        adminRegistrationResponse = new AdminRegistrationResponse();
    }

    @Test
    void registerTest() throws RegistrationException {
        AdminRegistrationRequest adminRegistrationRequest = buildAdminRegistrationRequest();

        AdminRegistrationResponse adminRegistrationResponse = adminService.register(adminRegistrationRequest);
        assertNotNull(adminRegistrationResponse);
        assertNotNull(adminRegistrationResponse.getMessage());
    }
    private static AdminRegistrationRequest buildAdminRegistrationRequest() {
        AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();
        adminRegistrationRequest.setUserName("Inem");
        adminRegistrationRequest.setPassword("1234");
        return adminRegistrationRequest;
    }

    @Test
    void getAdminByIdTest() throws RegistrationException {
        adminRegistrationRequest.setUserName("Inem");
        adminRegistrationRequest.setPassword("1234");
        var registrationResponse = adminService.register(adminRegistrationRequest);
        List<Admin> adminList = adminService.getAllAdmin();
        Admin lastRegisteredAdmin = adminList.get(adminList.size()-1);
        Admin foundAdmin = adminService.getAdminById(lastRegisteredAdmin.getAdminId());
        assertNotNull(foundAdmin);
        assertNotNull(registrationResponse);
        assertEquals(adminRegistrationRequest.getUserName(), foundAdmin.getUserInformation().getUsername());
    }

    @Test
    void getAllAdminTest() throws RegistrationException {
        var response = adminService.register(adminRegistrationRequest);
        assertNotNull(response);
        List<Admin> adminList = adminService.getAllAdmin();
        assertEquals(1, adminList.size());
        assertNotNull(adminList);
    }

    @Test
    void deleteByIdTest() throws RegistrationException {
        adminService.register(adminRegistrationRequest);
        List<Admin> adminList = adminService.getAllAdmin();
        assertEquals(ONE, adminList.size());
        Admin lastRegisteredAdmin = adminList.get(adminList.size()-ONE);
        Admin foundAdmin = adminService.getAdminById(lastRegisteredAdmin.getAdminId());
        adminService.deleteById(foundAdmin.getAdminId());
        assertEquals(0, adminService.getAllAdmin().size());
        adminList = adminService.getAllAdmin();
        assertEquals(ZERO, adminList.size());
    }
}