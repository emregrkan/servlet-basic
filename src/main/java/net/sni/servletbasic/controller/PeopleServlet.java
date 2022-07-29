package net.sni.servletbasic.controller;

import net.sni.servletbasic.model.Person;
import net.sni.servletbasic.model.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(name = "peopleServlet", value = "/people-servlet")
public class PeopleServlet extends HttpServlet {
    private Client client;

    @Override
    public void init() throws ServletException {
        this.client = ClientBuilder.newClient();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageParam = "";
        final String page = req.getParameter("page");

        if (page != null && !page.isEmpty()) {
            pageParam = "page=".concat(page);
        }

        final Response<Person> response = this.client.target("https://swapi.dev/api/people".concat(pageParam)).request(MediaType.APPLICATION_JSON).get(new GenericType<Response<Person>>() {
        });

        req.setAttribute("response", response);
        req.getRequestDispatcher("/people.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
    }


}
