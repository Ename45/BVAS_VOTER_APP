package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Election;
import africa.semicolon.bvasBeta.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasElectionRepository implements ElectionRepository{
    List<Election> electionList = new ArrayList<>();

    @Override
    public Election save(Election election) {
        String id = AppUtils.generateId();
        election.setElectionId(id);
        electionList.add(election);
        return election;
    }

    @Override
    public Election findById(String id) {
        for (Election election:electionList) {
            if (election.getElectionId().equals(id)){
                return election;
            }
        }
        return null;
    }

    @Override
    public List<Election> findAll() {
        return electionList;
    }


    @Override
    public void deleteById(String id) {
        Election foundElection = findById(id);
        if (foundElection != null)electionList.remove(foundElection);
    }
}
