package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.persistences.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientMongoRepository extends MongoRepository<ClientDocument, String>
{}
