package org.fasttrackit.phoneagenda.persistance;

import org.fasttrackit.phoneagenda.domain.AgendaContact;
import org.fasttrackit.phoneagenda.transfer.CreateAgendaContactRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaContactRepository {

    public void createAgendaContact(CreateAgendaContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO agenda_contact (first_name, last_name, phone_number) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNumber());

            preparedStatement.executeUpdate();
        }

    }

    public void updateAgendaContact(long id, CreateAgendaContactRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE agenda_contact SET first_name=?, last_name=?, phone_number=? " +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getPhoneNumber());
            preparedStatement.setLong(4, id);

            preparedStatement.executeUpdate();

        }

    }

    public void deleteAgendaContact(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM agenda_contact WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        }
    }

    public List<AgendaContact> getAgendaContacts() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, first_name, last_name, phone_number FROM agenda_contact";

        List<AgendaContact> agendaContacts = new ArrayList<>();

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                AgendaContact agendaContact = new AgendaContact();
                agendaContact.setId(resultSet.getLong("id"));
                agendaContact.setFirstName(resultSet.getString("first_name"));
                agendaContact.setLastName(resultSet.getString("last_name"));
                agendaContact.setPhoneNumber(resultSet.getString("phone_number"));

                agendaContacts.add(agendaContact);
            }

        }
        System.out.println(agendaContacts);
        return agendaContacts;
    }
}
