package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.persistences.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "clients")
public class ClientDocument
{
    @Id
    private String id;
    private String identificationType;
    private String identificationNumber;
    private String names;
    private String surnames;
    private String email;
    private String cellphone;
    private String address;
    private Double balance;
    private String notification;
}
