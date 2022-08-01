package net.sni.servletbasic.service;

import net.sni.servletbasic.dto.PersonDto;
import net.sni.servletbasic.dto.PlanetDto;
import net.sni.servletbasic.model.Planet;
import net.sni.servletbasic.model.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

public class PlanetService {
    private static final Client client = ClientBuilder.newClient();
    private static final String apiURL = "https://swapi.dev/api/planets/";

    private PlanetService() {
    }

    public static PlanetService getInstance() {
        return PlanetServiceHolder.INSTANCE;
    }

    public Optional<Planet> findOne(final String id) {
        final String url = apiURL.concat("/" + id);

        final Planet planet = client.target(url).request(MediaType.APPLICATION_JSON).get(Planet.class);

        return Optional.of(planet);
    }

    public Response<PlanetDto> findAll(final String page) {
        final String pageParam = "?page=".concat(page);
        final String url = apiURL.concat(pageParam);

        return client.target(url).request(MediaType.APPLICATION_JSON).get(new GenericType<Response<PlanetDto>>() {});
    }

    private static class PlanetServiceHolder {
        private static final PlanetService INSTANCE = new PlanetService();
    }
}
