package org.fasttrackit.phoneagenda;

import org.fasttrackit.phoneagenda.persistance.AgendaContactRepository;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CreateAgendaContactRequest request = new CreateAgendaContactRequest();
        request.setFirstName("MIDASDAD");
        request.setLastName("MDSDASDASDFas");
        request.setPhoneNumber("0744903036");


        AgendaContactRepository agendaContactRepository = new AgendaContactRepository();
//        agendaContactRepository.createAgendaContact(request);
//        agendaContactRepository.updateAgendaContact(1, request);

//        agendaContactRepository.getAgendaContacts();

//        agendaContactRepository.getAgendaContactsByFirstNameOrLastName("POP", "0");
            agendaContactRepository.deleteAllAgendaContacts();
    }
}
