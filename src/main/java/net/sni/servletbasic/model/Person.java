package net.sni.servletbasic.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> films;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> species;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> starships;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> vehicles;
    private String url;
    private String created;
    private String edited;
}
