package africa.semicolon.bvasBeta.dtos.requests;

import lombok.Data;

import java.util.List;
@Data
public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    private List<String> state;
    private List<String> parties;
    private List<String> localGovernmentArea;
}
