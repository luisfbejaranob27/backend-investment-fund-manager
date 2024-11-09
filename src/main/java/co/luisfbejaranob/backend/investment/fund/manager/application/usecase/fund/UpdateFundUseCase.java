package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateFundUseCase
{
    private final FundRepository repository;

    public UpdateFundUseCase(FundRepository repository)
    {
        this.repository = repository;
    }

    public Fund update(String id, Fund fund) throws IllegalAccessException
    {
        return repository.update(id, fund);
    }
}
