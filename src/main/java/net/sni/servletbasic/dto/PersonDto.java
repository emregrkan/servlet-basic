package net.sni.servletbasic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"eye_color", "hair_color", "height", "mass", "skin_color", "homeworld", "films", "species", "starships", "vehicles", "url", "created", "edited"})
public class PersonDto {
    private String name;
    private String gender;
    @JsonProperty("birth_year")
    private String birthYear;
}
