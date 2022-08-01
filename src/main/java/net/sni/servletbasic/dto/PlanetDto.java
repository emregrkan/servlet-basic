package net.sni.servletbasic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import net.sni.servletbasic.util.UrlDeserializer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"rotation_period", "orbital_period", "diameter", "climate", "gravity", "terrain", "residents", "films", "created", "edited"})
public class PlanetDto {
    private String name;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String population;
    @JsonDeserialize(using = UrlDeserializer.class)
    private String url;
}
