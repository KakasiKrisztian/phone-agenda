package org.fasttrackit.phoneagenda.transfer;

public class GetAgendaContactsRequest {
    //The request for the find by first or last name method

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "getAgendaContactsRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
