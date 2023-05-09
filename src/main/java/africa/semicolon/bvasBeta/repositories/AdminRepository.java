package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Voter;

import java.util.List;

public interface AdminRepository {

    Admin save(Admin admin);
    Admin findById(String id);
    List<Admin> findAll();
    void deleteById(String id);
//    Admin findById(String id);
//    List<Admin> findAll();
//    int countAdmin();
//    void save(Admin admin);
//    void deleteById(String id);
}
