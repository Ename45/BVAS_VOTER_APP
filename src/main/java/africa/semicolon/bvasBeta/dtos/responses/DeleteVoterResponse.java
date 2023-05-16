package africa.semicolon.bvasBeta.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteVoterResponse {
    private String message;
}
