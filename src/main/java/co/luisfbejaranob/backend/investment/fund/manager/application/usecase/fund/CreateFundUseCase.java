package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateFundUseCase
{
    private final FundRepository repository;

    public CreateFundUseCase(FundRepository repository)
    {
        this.repository = repository;
    }

    public Fund create(Fund fund)
    {
        return repository.save(fund);
    }
}
