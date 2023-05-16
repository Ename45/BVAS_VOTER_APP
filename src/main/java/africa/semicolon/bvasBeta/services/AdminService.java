package africa.semicolon.bvasBeta.services;


import africa.semicolon.bvasBeta.dtos.requests.AdminRegistrationRequest;
import africa.semicolon.bvasBeta.dtos.responses.AdminRegistrationResponse;
import africa.semicolon.bvasBeta.dtos.responses.DeleteAdminResponse;
import africa.semicolon.bvasBeta.exceptions.RegistrationException;
import africa.semicolon.bvasBeta.models.Admin;

import java.util.List;

public interface AdminService {
    public AdminRegistrationResponse register(AdminRegistrationRequest adminRegistrationRequest) throws RegistrationException;
    Admin getAdminById(String id);
    List<Admin> getAllAdmin();
    DeleteAdminResponse deleteById(String id);
}
