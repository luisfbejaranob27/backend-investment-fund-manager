package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientUseCase
{
    private final ClientRepository repository;

    public UpdateClientUseCase(ClientRepository repository)
    {
        this.repository = repository;
    }

    public Client update(String id, Client client) throws IllegalAccessException
    {
        return repository.update(id, client);
    }
}
