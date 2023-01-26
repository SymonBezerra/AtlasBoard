package ifpb.edu.br.atlasboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskPriority {
    
    LOW("low"), MEDIUM("medium"), HIGH("high");

    private String priority;

}
