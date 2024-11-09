package co.luisfbejaranob.backend.investment.fund.manager.shared.mappers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.FindFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.Transaction;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto.TransactionRequestDto;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto.TransactionResponseDto;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.persistences.mondodb.TransactionDocument;

import java.util.List;
import java.util.stream.Collectors;

public final class TransactionMappers
{
    public static Transaction documentToRaw(TransactionDocument document)
    {
        return Transaction.builder()
                .id(document.getId())
                .clientId(document.getClientId())
                .fund(FundMappers.documentToRaw(document.getFund()))
                .type(document.getType())
                .amount(document.getAmount())
                .notificationSent(document.getNotificationSent())
                .createAt(document.getCreateAt())
                .updateAt(document.getUpdateAt())
                .build();
    }

    public static TransactionDocument rawToDocument(Transaction raw)
    {
        return TransactionDocument.builder()
//                .id(raw.getId())
                .clientId(raw.getClientId())
                .fund(FundMappers.rawToDocument(raw.getFund()))
                .type(raw.getType())
                .amount(raw.getAmount())
                .notificationSent(raw.getNotificationSent())
                .createAt(raw.getCreateAt())
                .updateAt(raw.getUpdateAt())
                .build();
    }

    public static List<Transaction> listDocumentToListRaw(List<TransactionDocument> listDocument)
    {
        return listDocument.stream()
                .map(TransactionMappers::documentToRaw)
                .collect(Collectors.toList());
    }

    public static Transaction dtoToRaw(TransactionRequestDto dto, Fund fund)
    {
        return Transaction.builder()
                .clientId(dto.getClientId())
                .fund(fund)
                .type(dto.getType())
                .amount(dto.getAmount())
                .build();
    }

    public static TransactionResponseDto rawToDto(Transaction raw)
    {
        return TransactionResponseDto.builder()
                .id(raw.getId())
                .clientId(raw.getClientId())
                .fund(raw.getFund())
                .type(raw.getType())
                .amount(raw.getAmount())
                .notificationSent(raw.getNotificationSent())
                .createAt(raw.getCreateAt())
                .updateAt(raw.getUpdateAt())
                .build();
    }

    public static List<TransactionResponseDto> listRawToListDto(List<Transaction> listRaw)
    {
        return listRaw.stream()
                .map(TransactionMappers::rawToDto)
                .collect(Collectors.toList());
    }
}
