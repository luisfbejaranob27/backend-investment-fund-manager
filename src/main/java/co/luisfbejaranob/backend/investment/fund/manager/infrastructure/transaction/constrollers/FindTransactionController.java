package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.transaction.FindTransactionUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto.TransactionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.TransactionMappers.listRawToListDto;

@RestController
@RequestMapping("transactions")
public class FindTransactionController
{
    private final FindTransactionUseCase useCase;

    public FindTransactionController(FindTransactionUseCase useCase)
    {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listRawToListDto(useCase.findAll()));
    }

    @GetMapping("{clientId}")
    public ResponseEntity<List<TransactionResponseDto>> findAllByClientId(@PathVariable String clientId)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listRawToListDto(useCase.findAllByClientId(clientId)));
    }
}
