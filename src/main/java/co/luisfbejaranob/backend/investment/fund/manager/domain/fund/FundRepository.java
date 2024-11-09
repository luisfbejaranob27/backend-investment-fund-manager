package co.luisfbejaranob.backend.investment.fund.manager.domain.fund;

import java.util.List;

public interface FundRepository
{
    List<Fund> findAll();
    Fund findById(String id);
    Fund findByName(String name);
    Fund save(Fund fund);
    Fund update(String id, Fund fund) throws IllegalAccessException;
    void deleteById(String id);
}
