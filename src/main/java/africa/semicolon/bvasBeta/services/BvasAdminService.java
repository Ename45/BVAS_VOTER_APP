package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.AdminRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.AdminRegistrationResponse;
import africa.semicolon.bvasBeta.dtos.responses.DeleteAdminResponse;
import africa.semicolon.bvasBeta.dtos.responses.DeletePartyResponse;
import africa.semicolon.bvasBeta.dtos.responses.PartyRegistrationResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.repositories.AdminRepository;
import africa.semicolon.bvasBeta.repositories.BvasAdminRepository;

import java.util.List;

public class BvasAdminService implements AdminService{
    AdminRepository adminRepository = new BvasAdminRepository();
    @Override
    public AdminRegistrationResponse register(AdminRegistrationRequest adminRegistrationRequest) throws RegistrationException {
        String userName = adminRegistrationRequest.getUserName();
        String password = adminRegistrationRequest.getPassword();

        Admin admin = new Admin();
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(userName);
        userInformation.setPassword(password);
        admin.setUserInformation(userInformation);

        Admin savedAdmin = adminRepository.save(admin);
        if (savedAdmin == null) throw new RegistrationException("Admin registration failed");


        AdminRegistrationResponse adminRegistrationResponse = new AdminRegistrationResponse();
        adminRegistrationResponse.setMessage("Admin Registered");
        return adminRegistrationResponse;
    }

    @Override
    public Admin getAdminById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public DeleteAdminResponse deleteById(String id) {
        adminRepository.deleteById(id);
        DeleteAdminResponse deleteAdminResponse = new DeleteAdminResponse();
        deleteAdminResponse.setMessage("Admin deleted");
        return deleteAdminResponse;
    }
}
