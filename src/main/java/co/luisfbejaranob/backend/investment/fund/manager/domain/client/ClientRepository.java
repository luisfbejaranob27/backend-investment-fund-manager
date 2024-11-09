package co.luisfbejaranob.backend.investment.fund.manager.domain.client;

import java.util.List;

public interface ClientRepository
{
    List<Client> findAll();
    Client findById(String id);
    Client create(Client client);
    Client update(String id, Client client) throws IllegalAccessException;
    void deleteById(String id);
}
