package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.transaction;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.FindFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.Transaction;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindTransactionUseCase
{
    private final TransactionRepository repository;

    private final FindFundUseCase findFundUseCase;

    public FindTransactionUseCase(TransactionRepository repository, FindFundUseCase findFundUseCase)
    {
        this.repository = repository;
        this.findFundUseCase = findFundUseCase;
    }

    public List<Transaction> findAll()
    {
        return repository.findAll();
    }

    public List<Transaction> findAllByClientId(String clientId)
    {
        return repository.findAllByClientId(clientId);
    }

    public Transaction findById(String id)
    {
        return repository.findById(id);
    }
}
