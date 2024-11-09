package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindClientUseCase
{
    private final ClientRepository repository;

    public FindClientUseCase(ClientRepository repository)
    {
        this.repository = repository;
    }

    public List<Client> findAll()
    {
        return repository.findAll();
    }

    public Client findById(String id)
    {
        return repository.findById(id);
    }
}
