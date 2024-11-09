package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundExceptions.FundNotFoundException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.FundMappers.*;
import static co.luisfbejaranob.backend.investment.fund.manager.shared.utils.ObjectUtil.updateValues;

@Repository
public class FundRepositoryImpl implements FundRepository
{
    private final FundMongoRepository repository;

    public FundRepositoryImpl(FundMongoRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Fund> findAll()
    {
        return listDocumentToListRaw(repository.findAll());
    }

    @Override
    public Fund findById(String id)
    {
        return documentToRaw(repository.findById(id).orElseThrow(() -> new FundNotFoundException("Id",id)));
    }

    @Override
    public Fund findByName(String name)
    {
        return documentToRaw(repository.findByName(name).orElseThrow(() -> new FundNotFoundException("Name", name)));
    }

    @Override
    public Fund save(Fund fund)
    {
        return documentToRaw(repository.save(rawToDocument(fund)));
    }

    @Override
    public Fund update(String id, Fund fund) throws IllegalAccessException
    {
        Fund fundFound = findById(id);

        return documentToRaw(repository.save(rawToDocument(updateValues(fundFound, fund))));
    }

    @Override
    public void deleteById(String id)
    {
        boolean exists = repository.existsById(id);

        if(!exists)
        {
            throw new FundNotFoundException("Id", id);
        }

        repository.deleteById(id);
    }
}
