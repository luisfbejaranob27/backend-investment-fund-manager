package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientUseCase
{
    private final ClientRepository repository;

    public DeleteClientUseCase(ClientRepository repository)
    {
        this.repository = repository;
    }

    public void deleteById(String id)
    {
        repository.deleteById(id);
    }
}
