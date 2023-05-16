package africa.semicolon.bvasBeta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Election {
    private String electionId;
    private LocalDate date;
    private Category category;
    private List<Party> parties;
}
