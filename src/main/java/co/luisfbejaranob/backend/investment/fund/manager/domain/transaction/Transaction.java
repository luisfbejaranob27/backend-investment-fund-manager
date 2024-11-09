package co.luisfbejaranob.backend.investment.fund.manager.domain.transaction;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction
{
    private String id;
    private String clientId;
    private Fund fund;
    private String type;
    private Double amount;
    private Boolean notificationSent;
    private Date createAt;
    private Date updateAt;
}
