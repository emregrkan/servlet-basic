package net.sni.servletbasic.entity;

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
@Builder
@JsonIgnoreProperties(value = {"starships", "vehicles", "films", "species"})
public class Person {
    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String mass;
    @JsonProperty("skin_color")
    private String skinColor;
    private String homeworld;
    @JsonDeserialize(using = UrlDeserializer.class)
    private String url;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate created;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate edited;
}
