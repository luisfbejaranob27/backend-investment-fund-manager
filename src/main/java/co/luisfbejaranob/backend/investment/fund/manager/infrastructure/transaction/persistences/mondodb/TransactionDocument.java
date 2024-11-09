package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.persistences.mondodb;

import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb.FundDocument;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "transactions")
public class TransactionDocument
{
    @Id
    private String id;
    private String clientId;
    private FundDocument fund;
    private String type;
    private Double amount;
    private Boolean notificationSent;
    private Date createAt;
    private Date updateAt;
}
