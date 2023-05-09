package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAdminRepository implements AdminRepository{

    UserInformation userInformation;
    List<Admin> adminList = new ArrayList<>();

    public BvasAdminRepository(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public Admin save(Admin admin) {
        String id = AppUtils.generateId();
        admin.setAdminId(id);
        adminList.add(admin);
        return admin;
    }

    @Override
    public Admin findById(String id) {
        for (Admin admin:adminList) {
            if (admin.getAdminId().equals(id)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return adminList;
    }

    @Override
    public void deleteById(String id) {
        Admin foundAdmin = findById(id);
        if (foundAdmin != null)adminList.remove(foundAdmin);
    }


//    List<Admin> adminList = new ArrayList<>();
//    private int idCount;
//
//    @Override
//    public void save(Admin admin) {
//        if (admin.getAdminId() != null){
//            update(admin);
//        }
//        else {
//            saveNewAdmin(admin);
//        }
//    }
//
//    private void update(Admin admin) {
//        Admin savedAdmin = findById(admin.getAdminId());
//        int indexOfSavedAdmin = adminList.indexOf(savedAdmin);
//        adminList.set(indexOfSavedAdmin, admin);
//    }
//
//    private void saveNewAdmin(Admin admin) {
//        String id = generateId();
//        admin.setAdminId(id);
//        adminList.add(admin);
//    }
//
//    private String generateId() {
//        return String.valueOf(idCount += 1);
//    }
//
//    @Override
//    public Admin findById(String id) {
//        for (Admin admin: adminList) {
//            if (admin.getAdminId().equals(id)){
//                return admin;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Admin> findAll() {
//        return adminList;
//    }
//
//    public int countAdmin() {
//        return adminList.size();
//    }
//
//    @Override
//    public void deleteById(String id) {
//        Admin foundAdminId = findById(id);
//        adminList.remove(foundAdminId);
//        idCount--;
//    }
}
