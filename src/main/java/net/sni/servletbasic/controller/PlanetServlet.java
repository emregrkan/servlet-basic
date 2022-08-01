package net.sni.servletbasic.controller;

import net.sni.servletbasic.dto.PersonDto;
import net.sni.servletbasic.dto.PlanetDto;
import net.sni.servletbasic.model.Person;
import net.sni.servletbasic.model.Planet;
import net.sni.servletbasic.model.Response;
import net.sni.servletbasic.service.PlanetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "planetServlet", value = "/planets/*")
public class PlanetServlet extends HttpServlet {

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

    private void processFindOneRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String planetId = req.getPathInfo().substring(1);

        final Optional<Planet> response = planetService.findOne(planetId);

        response.ifPresent(planet -> req.setAttribute("response", planet));
        req.getRequestDispatcher("/planet.jsp").forward(req, resp);
    }

    private void processFindAllRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String pageParam = req.getParameter("page");
        String page = "";

        if (pageParam != null && !pageParam.isEmpty()) {
            page = pageParam;
        }

        final Response<PlanetDto> response = planetService.findAll(page);

        req.setAttribute("response", response);
        req.setAttribute("page", page.isEmpty() ? 1 : Integer.parseInt(page));
        req.getRequestDispatcher("/planets.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
    }

}
