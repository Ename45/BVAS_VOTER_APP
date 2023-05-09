package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Party;

import java.util.List;

public interface PartyRepository {
    Party save(Party party);
    Party findById(String id);
    List<Party> findAll();
    void deleteById(String id);
//    Party findById(String id);
//    List<Party> findAll();
//    int countAdmin();
//    void save(Party party);
//    void deleteById(String id);
}
