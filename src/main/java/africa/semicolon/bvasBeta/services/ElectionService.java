package africa.semicolon.bvasBeta.services;

import africa.semicolon.bvasBeta.dtos.requests.CreateElectionRequest;
import africa.semicolon.bvasBeta.dtos.responses.CreateElectionResponse;

public interface ElectionService {
    public CreateElectionResponse create(CreateElectionRequest createElectionRequest);
}
