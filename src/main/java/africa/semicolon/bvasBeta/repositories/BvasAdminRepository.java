package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAdminRepository implements AdminRepository{

    List<Admin> adminList = new ArrayList<>();

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
}
