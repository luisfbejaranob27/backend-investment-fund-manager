package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb.FundDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter

public class TransactionResponseDto
{
    private String id;
    private String clientId;
    private Fund fund;
    private String type;
    private Double amount;
    private Boolean notificationSent;
    private Date createAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updateAt;
}
