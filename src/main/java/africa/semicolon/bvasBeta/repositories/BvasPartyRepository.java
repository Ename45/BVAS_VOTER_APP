package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasPartyRepository implements PartyRepository{
    List<Party> partyList = new ArrayList<>();
    UserInformation userInformation;

    public BvasPartyRepository(UserInformation userInformation) {
        this.userInformation = userInformation;
    }



    @Override
    public Party save(Party party) {
        String id = AppUtils.generateId();
        party.setPartyId(id);
        partyList.add(party);
        return party;
    }

    @Override
    public Party findById(String id) {
        for (Party party:partyList) {
            if (party.getPartyId().equals(id)){
                return party;
            }
        }
        return null;
    }

    @Override
    public List<Party> findAll() {
        return partyList;
    }

    @Override
    public void deleteById(String id) {
        Party foundParty = findById(id);
        if (foundParty != null)partyList.remove(foundParty);
    }


//    private int idCount;
//
//    @Override
//    public void save(Party party) {
//        if (party.getUserInformation().getId() != null){
//            update(party);
//        }
//        else {
//            saveNewParty(party);
//        }
//    }
//
//    private void update(Party party) {
//        Party savedParty = findById(party.getUserInformation().getId());
//        int indexOfSavedParty = partyList.indexOf(savedParty);
//        partyList.set(indexOfSavedParty, party);
//    }
//
//    private void saveNewParty(Party party) {
//        String id = generateId();
//        party.getUserInformation().setId(id);
//        partyList.add(party);
//    }
//
//    private String generateId() {
//        return String.valueOf(idCount += 1);
//    }
//
//
//    @Override
//    public Party findById(String id) {
//        for (Party party: partyList) {
//            if (party.getUserInformation().getId().equals(id)){
//                return party;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Party> findAll() {
//        return partyList;
//    }
//
//    @Override
//    public int countAdmin() {
//        return partyList.size();
//    }
//
//
//    @Override
//    public void deleteById(String id) {
//        Party foundPartyId = findById(id);
//        partyList.remove(foundPartyId);
//        idCount--;
//    }
}
