package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FundMongoRepository extends MongoRepository<FundDocument, String>
{
    Optional<FundDocument> findByName(String name);
}
