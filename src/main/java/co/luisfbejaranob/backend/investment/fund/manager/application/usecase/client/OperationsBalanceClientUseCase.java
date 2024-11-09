package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientInsufficientBalanceException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class OperationsBalanceClientUseCase
{
    private final ClientRepository repository;

    public OperationsBalanceClientUseCase(ClientRepository repository)
    {
        this.repository = repository;
    }

    public void debitAmount(Client client, Double amount) throws IllegalAccessException
    {
        Double currentBalance = client.getBalance();

        if(amount > currentBalance)
        {
            throw new ClientInsufficientBalanceException();
        }
        client.setBalance(currentBalance - amount);

        repository.update(client.getId(), client);
    }

    public void creditBalance(Client client, Double amount) throws IllegalAccessException
    {
        Double currentBalance = client.getBalance();

        client.setBalance(currentBalance + amount);

        repository.update(client.getId(), client);
    }
}
