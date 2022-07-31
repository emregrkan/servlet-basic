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
    private String requestURI;
    private String requestURL;

    private PeopleService() {
    }

    public static PeopleService getInstance() {
        return PeopleServiceHolder.INSTANCE;
    }

    public PeopleService setRequestURI(final String requestURI) {
        this.requestURI = requestURI;
        return this;
    }

    public PeopleService setRequestURL(final String requestURL) {
        this.requestURL = requestURL;
        return this;
    }

    public Optional<Person> findOne(final String id) {
        final String baseUrl = requestURL.replaceAll(requestURL, apiURL);
        final String url = baseUrl.concat(id);

        final Person person = client.target(url).request(MediaType.APPLICATION_JSON).get(Person.class);

        return Optional.of(person);
    }

    public Response<PersonDto> findAll(final String page) {
        final String pageParam = "?page=".concat(page);
        final String url = apiURL.concat(pageParam);

        return getPersonResponse(url);
    }

    private Response<PersonDto> getPersonResponse(final String url) {
        final Response<PersonDto> response = client.target(url).request(MediaType.APPLICATION_JSON).get(new GenericType<Response<PersonDto>>() {});

        if (response.getNext() != null) {
            response.setNext(response.getNext().replaceAll(apiURL, requestURI));
        }

        if (response.getPrevious() != null) {
            response.setPrevious(response.getPrevious().replaceAll(apiURL, requestURI));
        }

        return response;
    }

    private static class PeopleServiceHolder {
        private static final PeopleService INSTANCE = new PeopleService();
    }
}
