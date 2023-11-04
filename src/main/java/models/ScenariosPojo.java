package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ScenariosPojo {
    @JsonProperty("scenarios")
    public List<ScenarioPojo> scenarios;
}
