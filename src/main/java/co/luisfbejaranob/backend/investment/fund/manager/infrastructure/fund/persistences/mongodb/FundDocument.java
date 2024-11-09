package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "funds")
public class FundDocument
{
    @Id
    private String id;
    private String name;
    private Double minimumAmount;
    private String category;
}
