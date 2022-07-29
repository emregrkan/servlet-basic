package net.sni.servletbasic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
    private Float count;
    private String next;
    private String previous;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<T> results;
}
