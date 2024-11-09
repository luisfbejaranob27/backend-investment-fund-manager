package co.luisfbejaranob.backend.investment.fund.manager.domain.fund;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fund
{
    private String id;
    private String name;
    private Double minimumAmount;
    private String category;
}
