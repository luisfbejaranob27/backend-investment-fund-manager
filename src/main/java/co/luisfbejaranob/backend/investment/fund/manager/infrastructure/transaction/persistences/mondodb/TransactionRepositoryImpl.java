package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.persistences.mondodb;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.Transaction;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionExceptions.*;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionRepository;
import co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.FundMappers;
import co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.TransactionMappers;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.TransactionMappers.*;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository
{
    private final TransactionMongoRepository repository;

    public TransactionRepositoryImpl(TransactionMongoRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Transaction> findAll()
    {
        return listDocumentToListRaw(repository.findAll());
    }

    @Override
    public List<Transaction> findAllByClientId(String id) {
        Optional<List<TransactionDocument>> listTransactionsDocumentFound = repository.findAllByClientId(id);

        return listTransactionsDocumentFound.map(TransactionMappers::listDocumentToListRaw).orElse(List.of());
    }

    @Override
    public Transaction findById(String id)
    {
        return documentToRaw(repository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Id", id)));
    }

    @Override
    public Transaction findByClientIdAndFund(String clientId, Fund fund)
    {
        Optional<TransactionDocument> transactionDocumentFound = repository.findFirstByClientIdAndFundOrderByCreateAtDesc(clientId, FundMappers.rawToDocument(fund));

        return transactionDocumentFound.map(TransactionMappers::documentToRaw).orElse(null);
    }

    @Override
    public Transaction create(Transaction transaction)
    {
        transaction.setCreateAt(new Date());
        return documentToRaw(repository.save(rawToDocument(transaction)));
    }
}
