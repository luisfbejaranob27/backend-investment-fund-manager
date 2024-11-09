package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class TransactionRequestDto
{
    private String clientId;
    private String fundName;
    private String type;
    private Double amount;
}
