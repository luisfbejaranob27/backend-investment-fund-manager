package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.persistences.mongodb;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientNotFoundException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.ClientMappers.*;
import static co.luisfbejaranob.backend.investment.fund.manager.shared.utils.ObjectUtil.updateValues;

@Repository
public class ClientRepositoryImpl implements ClientRepository
{
    private final ClientMongoRepository repository;

    public ClientRepositoryImpl(ClientMongoRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll()
    {
        return listDocumentToListRaw(repository.findAll());
    }

    @Override
    public Client findById(String id)
    {
        return documentToRaw(
                repository.findById(id)
                        .orElseThrow(() -> new ClientNotFoundException(id))
        );
    }

    @Override
    public Client create(Client client)
    {
        return documentToRaw(repository.save(rawToDocument(client)));
    }

    @Override
    public Client update(String id, Client client) throws IllegalAccessException
    {
        Client clientFound = findById(id);

        return documentToRaw(repository.save(rawToDocument(updateValues(clientFound, client)))  );
    }

    @Override
    public void deleteById(String id)
    {
        boolean exists = repository.existsById(id);

        if (!exists)
        {
            throw new ClientNotFoundException(id);
        }

        repository.deleteById(id);
    }
}
