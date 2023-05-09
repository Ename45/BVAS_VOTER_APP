package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Party;
import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasPartyRepository implements PartyRepository{
    List<Party> partyList = new ArrayList<>();

    private final UserInformationRepository userInformationRepository = new BvasUserInformationRepository();

    @Override
    public Party save(Party party) {
        String id = AppUtils.generateId();
        party.setPartyId(id);
        boolean isPartyWithUserInformation = party.getUserInformation() != null;
        if (isPartyWithUserInformation){
            saveUserInformation(party);
        }
        partyList.add(party);
        return party;
    }

    private void saveUserInformation(Party party) {
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getPartyId();
        String userInformationId = savedUserInformation.getId();
        AppUtils.linkUserToUserInformation(partyId, userInformationId);
    }

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for (Party party:partyList) {
            if (party.getPartyId().equals(id)){
                foundParty =  party;
            }
        }
        if (foundParty != null){
            String userInformation = AppUtils.getUserInformationId(foundParty.getPartyId());
            UserInformation userInformation1 = userInformationRepository.findById(userInformation);
            foundParty.setUserInformation(userInformation1);
        }
        return foundParty;
//        return partyList.stream().filter(party -> party.getPartyId().equals(id)).fi
    }

    @Override
    public List<Party> findAll() {
        List<Party> foundPoliticalParties = new ArrayList<>();
        for (Party party: partyList) {
            String userInformationId = AppUtils.getUserInformationId(party.getPartyId());
            if (userInformationId != null){
                UserInformation foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
            foundPoliticalParties.add(party);
        }
        return foundPoliticalParties;
    }

    @Override
    public void deleteById(String id) {
        Party foundParty = findById(id);
        if (foundParty != null)partyList.remove(foundParty);
    }
}
