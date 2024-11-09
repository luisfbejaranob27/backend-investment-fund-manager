package co.luisfbejaranob.backend.investment.fund.manager.domain.client;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client
{
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
