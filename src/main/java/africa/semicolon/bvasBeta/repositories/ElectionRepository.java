package africa.semicolon.bvasBeta.repositories;

import africa.semicolon.bvasBeta.models.Address;
import africa.semicolon.bvasBeta.models.Election;
import africa.semicolon.bvasBeta.models.Voter;

import java.util.List;

public interface ElectionRepository {
    Election save(Election election);
    Election findById(String id);
    List<Election> findAll();
    void deleteById(String id);
}
