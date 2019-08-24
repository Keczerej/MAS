package fitenssclub.view;


import fitenssclub.model.users.client.Client;

public class ClientDTO  {

    private final  Client client;

    public ClientDTO(Client client) {
        this.client = client;
    }

    public static String getDetailsString(Client contributor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Login: " + contributor.getLogin() + "\n");
        stringBuilder.append("Wiek: " + contributor.getAge() + "\n");
        if(contributor.getAddresses().size() > 0){
            stringBuilder.append("Adres: \n");
            contributor.getAddresses().forEach(address ->
                    stringBuilder.append("  " + address.getCity() + ", " + address.getAddress())
            );
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.client.getFirstName() + " " + this.client.getLastName();
    }

    public Client getContributor() {
        return this.client;
    }
}
