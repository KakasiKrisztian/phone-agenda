package org.fasttrackit.phoneagenda.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.fasttrackit.phoneagenda.domain.AgendaContact;
import org.fasttrackit.phoneagenda.service.AgendaContactService;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;
import org.fasttrackit.phoneagenda.transfer.GetAgendaContactsRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/agenda-contacts")
public class AgendaContactServlet extends HttpServlet {

    private AgendaContactService agendaContactService = new AgendaContactService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        CreateAgendaContactRequest request = objectMapper.readValue(req.getReader(), CreateAgendaContactRequest.class);
        try {
            agendaContactService.createAgendaContact(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") != null) {
            String id = req.getParameter("id");

            try {
                agendaContactService.deleteAgendaContact(Long.parseLong(id));
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal Server Error: " + e.getMessage());
            }
        } else {
            try {
                agendaContactService.deleteAllAgendaContacts();
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal Server Error: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ObjectMapper objectMapper = new ObjectMapper();
        CreateAgendaContactRequest request = objectMapper.readValue(req.getReader(), CreateAgendaContactRequest.class);


        try {
            agendaContactService.updateAgendaContact(Long.parseLong(id), request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        GetAgendaContactsRequest request = new GetAgendaContactsRequest();
        String response;
        try {
            request = objectMapper.readValue(req.getReader(), GetAgendaContactsRequest.class);
        } catch (MismatchedInputException e) {
            System.out.println("Error on readValue, continuing with get all");
            try {
                List<AgendaContact> agendaContacts = agendaContactService.getAgendaContacts();

                response = objectMapper.writeValueAsString(agendaContacts);
                resp.getWriter().print(response);
            } catch (SQLException | ClassNotFoundException f) {
                resp.sendError(500, "Internal Server Error: " + f.getMessage());
            }
        }

        if (request.getName() != null) {


            try {
                List<AgendaContact> agendaContactsByFirstNameOrLastName =
                        agendaContactService.getAgendaContactsByFirstNameOrLastName(request);

                String firstResponse = objectMapper.writeValueAsString(agendaContactsByFirstNameOrLastName);
                resp.getWriter().print(firstResponse);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal Server Error: " + e.getMessage());
            }
        }


    }
}
