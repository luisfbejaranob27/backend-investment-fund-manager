package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindFundUseCase
{
    private final FundRepository repository;

    public FindFundUseCase(FundRepository repository)
    {
        this.repository = repository;
    }

    public List<Fund> findAll()
    {
        return repository.findAll();
    }

    public Fund findById(String id)
    {
        return repository.findById(id);
    }

    public Fund findByName(String name)
    {
        return repository.findByName(name);
    }
}
