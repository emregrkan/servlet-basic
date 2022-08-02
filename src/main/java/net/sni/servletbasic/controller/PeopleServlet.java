package net.sni.servletbasic.controller;

import net.sni.servletbasic.dto.PersonDto;
import net.sni.servletbasic.entity.Person;
import net.sni.servletbasic.entity.Planet;
import net.sni.servletbasic.entity.Response;
import net.sni.servletbasic.service.PeopleService;
import net.sni.servletbasic.service.PlanetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "peopleServlet", value = "/people/*")
public class PeopleServlet extends HttpServlet {

    private static final PeopleService peopleService = PeopleService.getInstance();
    private static final PlanetService planetService = PlanetService.getInstance();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() != null && req.getPathInfo().length() != 1) {
            processFindOneRequest(req, resp);
            return;
        }

        processFindAllRequest(req, resp);
    }

    @Override
    public void destroy() {
    }

    private void processFindAllRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String pageParam = req.getParameter("page");
        String page = "";

        if (pageParam != null && !pageParam.isEmpty()) {
            page = pageParam;
        }

        final Response<PersonDto> response = peopleService.findAll(page);

        req.setAttribute("response", response);
        req.setAttribute("page", page.isEmpty() ? 1 : Integer.parseInt(page));
        req.getRequestDispatcher("/people.jsp").forward(req, resp);
    }

    private void processFindOneRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String personId = req.getPathInfo().substring(1);

        final Optional<Person> person = peopleService.findOne(personId);

        if (person.isPresent()) {
            final String planetId = person.get().getHomeworld().replaceAll("\\D", "");
            final Optional<Planet> planet = planetService.findOne(planetId);

            planet.ifPresent(p -> {
                req.setAttribute("planetUrl", p.getUrl());
                person.get().setHomeworld(p.getName());
            });

            req.setAttribute("person", person.get());
        }

        req.getRequestDispatcher("/person.jsp").forward(req, resp);
    }
}
