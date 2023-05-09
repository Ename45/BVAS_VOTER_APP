package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Voter;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasVoterRepository implements VoterRepository{

    List<Voter> voterList = new ArrayList<>();

    @Override
    public Voter save(Voter voter) {
        String id = AppUtils.generateId();
        voter.setVoterId(id);
        voterList.add(voter);
        return voter;
    }

    @Override
    public Voter findById(String id) {
        for (Voter voter:voterList) {
            if (voter.getVoterId().equals(id)){
                return voter;
            }
        }
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voterList;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if (foundVoter!=null)voterList.remove(foundVoter);
    }
}
