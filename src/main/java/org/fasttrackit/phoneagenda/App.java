package org.fasttrackit.phoneagenda;

import org.fasttrackit.phoneagenda.persistance.AgendaContactRepository;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;
import org.fasttrackit.phoneagenda.web.AgendaContactServlet;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CreateAgendaContactRequest request = new CreateAgendaContactRequest();
        request.setFirstName("MIHUT");
        request.setLastName("DANUT");
        request.setPhoneNumber("0744912219");


        AgendaContactRepository agendaContactRepository = new AgendaContactRepository();
//        agendaContactRepository.createAgendaContact(request);
//        agendaContactRepository.updateAgendaContact(1, request);

//        agendaContactRepository.getAgendaContacts();

//        agendaContactRepository.getAgendaContactsByFirstNameOrLastName("PO");
//            agendaContactRepository.deleteAllAgendaContacts();


        AgendaContactServlet agendaContactServlet = new AgendaContactServlet();

//        agendaContactServlet.
    }
}
