package fitenssclub.view;


import fitenssclub.model.users.client.Client;

public class ClientDTO  {

    private final  Client client;

    public ClientDTO(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return this.client.getFirstName() + " " + this.client.getLastName();
    }

    public Client getContributor() {
        return this.client;
    }
}
