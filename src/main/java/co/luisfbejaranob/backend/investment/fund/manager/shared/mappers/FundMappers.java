package co.luisfbejaranob.backend.investment.fund.manager.shared.mappers;

import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.persistences.mongodb.FundDocument;

import java.util.List;
import java.util.stream.Collectors;

public final class FundMappers
{
    public static Fund documentToRaw(FundDocument document)
    {
        return Fund.builder()
                .id(document.getId())
                .name(document.getName())
                .minimumAmount(document.getMinimumAmount())
                .category(document.getCategory())
                .build();
    }

    public static FundDocument rawToDocument(Fund raw)
    {
        return FundDocument.builder()
                .id(raw.getId())
                .name(raw.getName())
                .minimumAmount(raw.getMinimumAmount())
                .category(raw.getCategory())
                .build();
    }

    public static List<Fund> listDocumentToListRaw(List<FundDocument> listDocument)
    {
        return listDocument.stream()
                .map(FundMappers::documentToRaw)
                .collect(Collectors.toList());
    }
}
