package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.UserInformation;
import africa.semicolon.bvasBeta.models.Voter;

import java.util.List;

public interface VoterRepository {

    Voter save(Voter voter);
    Voter findById(String id);
    List<Voter> findAll();
    void deleteById(String id);
}
