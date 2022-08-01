package net.sni.servletbasic.service;

import net.sni.servletbasic.dto.PersonDto;
import net.sni.servletbasic.model.Person;
import net.sni.servletbasic.model.Response;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

public class PeopleService {

    private static final Client client = ClientBuilder.newClient();
    private static final String apiURL = "https://swapi.dev/api/people/";

    private PeopleService() {
    }

    public static PeopleService getInstance() {
        return PeopleServiceHolder.INSTANCE;
    }

    public Optional<Person> findOne(final String id) {
        final String url = apiURL.concat("/" + id);

        final Person person = client.target(url).request(MediaType.APPLICATION_JSON).get(Person.class);

        return Optional.of(person);
    }

    public Response<PersonDto> findAll(final String page) {
        final String pageParam = "?page=".concat(page);
        final String url = apiURL.concat(pageParam);

        return getPersonResponse(url);
    }

    private Response<PersonDto> getPersonResponse(final String url) {
        return client.target(url).request(MediaType.APPLICATION_JSON).get(new GenericType<Response<PersonDto>>() {});
    }

    private static class PeopleServiceHolder {
        private static final PeopleService INSTANCE = new PeopleService();
    }
}
