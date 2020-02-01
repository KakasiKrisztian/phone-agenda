package org.fasttrackit.phoneagenda.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.phoneagenda.service.AgendaContactService;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/agenda-contacts")
public class AgendaContactServlet extends HttpServlet {

    private AgendaContactService agendaContactService = new AgendaContactService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        CreateAgendaContactRequest request = objectMapper.readValue(req.getReader(), CreateAgendaContactRequest.class);
        try {
            agendaContactService.createAgendaContact(request);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
