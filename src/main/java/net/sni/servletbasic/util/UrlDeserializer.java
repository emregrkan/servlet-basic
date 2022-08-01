package net.sni.servletbasic.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.sni.servletbasic.context.ServerContext;

import java.io.IOException;

public class UrlDeserializer extends StdDeserializer<String> {

    private static final String hostURL = ServerContext.getInstance().getUrl();
    private static final String apiURL = "https://swapi.dev/api/";

    public UrlDeserializer() {
        this(String.class);
    }

    protected UrlDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return jsonParser.getText().replaceAll(apiURL, hostURL);
    }
}
