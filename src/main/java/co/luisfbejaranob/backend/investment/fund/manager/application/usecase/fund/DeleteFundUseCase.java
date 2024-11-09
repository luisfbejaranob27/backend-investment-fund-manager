package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteFundUseCase
{
    private final FundRepository repository;

    public DeleteFundUseCase(FundRepository repository)
    {
        this.repository = repository;
    }

    public void deleteById(String id)
    {
        repository.deleteById(id);
    }
}
