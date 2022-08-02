package net.sni.servletbasic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import net.sni.servletbasic.util.LocalDateDeserializer;
import net.sni.servletbasic.util.UrlDeserializer;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"residents", "films"})
public class Planet {
    private String name;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String population;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate created;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate edited;
    @JsonDeserialize(using = UrlDeserializer.class)
    private String url;
}
