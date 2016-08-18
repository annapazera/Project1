package project.shop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class InMemoryClientRepository implements ClientRepository {
    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    ArrayList<Client> clients = new ArrayList<Client>();

}
