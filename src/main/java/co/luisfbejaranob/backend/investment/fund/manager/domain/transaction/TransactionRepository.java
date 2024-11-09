package co.luisfbejaranob.backend.investment.fund.manager.domain.transaction;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;

import java.util.List;

public interface TransactionRepository
{
    List<Transaction> findAll();
    List<Transaction> findAllByClientId(String id);
    Transaction findById(String id);
    Transaction findByClientIdAndFund(String clientId, Fund fund);
    Transaction create(Transaction transaction);
}
