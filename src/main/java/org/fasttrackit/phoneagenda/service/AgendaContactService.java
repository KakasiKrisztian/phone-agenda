package org.fasttrackit.phoneagenda.service;

import org.fasttrackit.phoneagenda.domain.AgendaContact;
import org.fasttrackit.phoneagenda.persistance.AgendaContactRepository;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;
import org.fasttrackit.phoneagenda.transfer.GetAgendaContactsRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AgendaContactService {

    private AgendaContactRepository agendaContactRepository = new AgendaContactRepository();

    public void createAgendaContact(CreateAgendaContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating agenda-contact: " + request);

        agendaContactRepository.createAgendaContact(request);

    }

    public void updateAgendaContact(long id, CreateAgendaContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating agenda-contact: " + id);

        agendaContactRepository.updateAgendaContact(id, request);


    }

    public void deleteAgendaContact(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting agenda-contact: " + id);

        agendaContactRepository.deleteAgendaContact(id);
    }

    public void deleteAllAgendaContacts() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting all agenda-contacts");

        agendaContactRepository.deleteAllAgendaContacts();

    }

    public List<AgendaContact> getAgendaContacts() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving all agenda-contacts");

        return agendaContactRepository.getAgendaContacts();

    }

    public List<AgendaContact> getAgendaContactsByFirstNameOrLastName(GetAgendaContactsRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving agenda-contacts by first or last name:");

        return agendaContactRepository.getAgendaContactsByFirstNameOrLastName(request);

    }
}
