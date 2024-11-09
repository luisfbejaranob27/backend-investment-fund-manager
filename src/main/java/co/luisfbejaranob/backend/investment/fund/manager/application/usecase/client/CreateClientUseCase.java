package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientInsufficientInitialAmountException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateClientUseCase
{
    private final ClientRepository repository;

    public CreateClientUseCase(ClientRepository repository)
    {
        this.repository = repository;
    }

    public Client create(Client client)
    {
        if(client.getBalance() < 500000)
        {
            throw new ClientInsufficientInitialAmountException();
        }

        return repository.create(client);
    }
}
