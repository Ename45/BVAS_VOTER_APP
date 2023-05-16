package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.CreateElectionRequest;
import africa.semicolon.bvasBeta.dtos.responses.CreateElectionResponse;
import africa.semicolon.bvasBeta.repositories.BvasElectionRepository;
import africa.semicolon.bvasBeta.repositories.ElectionRepository;

public class BvasElectionService implements ElectionService{
    private final ElectionRepository electionRepository = new BvasElectionRepository();
    @Override
    public CreateElectionResponse create(CreateElectionRequest createElectionRequest) {
        return null;
    }
}
