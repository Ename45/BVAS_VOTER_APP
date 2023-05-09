package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasUserInformationRepository implements UserInformationRepository{
    UserInformation userInformation;
    private List<UserInformation> userInformationList = new ArrayList<>();

    public BvasUserInformationRepository(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        String id = AppUtils.generateId();
        userInformation.setId(id);
        userInformationList.add(userInformation);
        return userInformation;
    }

    @Override
    public UserInformation findById(String id) {
        for (UserInformation userInformation:userInformationList) {
            if (userInformation.getId().equals(id)){
                return userInformation;
            }
        }
        return null;
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformationList;
    }

    @Override
    public void deleteById(String id) {
        UserInformation foundUserInformation = findById(id);
        if (foundUserInformation!=null)userInformationList.remove(foundUserInformation);
    }
}
