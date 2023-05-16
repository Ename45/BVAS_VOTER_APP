package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Admin;
import africa.semicolon.bvasBeta.models.Party;

import java.util.List;

public interface PartyRepository {
    Party save(Party party);
    Party findById(String id);
    Party findByName(String name);
    List<Party> findAll();
    void deleteById(String id);

}
