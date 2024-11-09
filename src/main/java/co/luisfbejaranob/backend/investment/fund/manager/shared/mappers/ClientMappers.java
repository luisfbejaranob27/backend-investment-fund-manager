package co.luisfbejaranob.backend.investment.fund.manager.shared.mappers;

import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.persistences.mongodb.ClientDocument;

import java.util.List;
import java.util.stream.Collectors;

public final class ClientMappers
{
    private ClientMappers()
    {}

    public static Client documentToRaw(ClientDocument document)
    {
        return Client.builder()
                .id(document.getId())
                .identificationType(document.getIdentificationType())
                .identificationNumber(document.getIdentificationNumber())
                .names(document.getNames())
                .surnames(document.getSurnames())
                .email(document.getEmail())
                .cellphone(document.getCellphone())
                .address(document.getAddress())
                .balance(document.getBalance())
                .notification(document.getNotification())
                .build();
    }

    public static ClientDocument rawToDocument(Client raw)
    {
        return ClientDocument.builder()
                .id(raw.getId())
                .identificationType(raw.getIdentificationType())
                .identificationNumber(raw.getIdentificationNumber())
                .names(raw.getNames())
                .surnames(raw.getSurnames())
                .email(raw.getEmail())
                .cellphone(raw.getCellphone())
                .address(raw.getAddress())
                .balance(raw.getBalance())
                .notification(raw.getNotification())
                .build();
    }

    public static List<Client> listDocumentToListRaw(List<ClientDocument> listDocument)
    {
        return listDocument.stream()
                .map(ClientMappers::documentToRaw)
                .collect(Collectors.toList());
    }
}
