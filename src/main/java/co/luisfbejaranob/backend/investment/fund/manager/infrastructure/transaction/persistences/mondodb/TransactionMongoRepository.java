package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.persistences.mondodb;

import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb.FundDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionMongoRepository extends MongoRepository<TransactionDocument, String>
{
    Optional<List<TransactionDocument>> findAllByClientId(String clientId);
    Optional<TransactionDocument> findFirstByClientIdAndFundOrderByCreateAtDesc(String clientId, FundDocument fund);
}
