package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.FindFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.transaction.CreateTransactionUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientInsufficientBalanceTransactionException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundExceptions.FundNotFoundException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionExceptions.*;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto.TransactionRequestDto;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.transaction.constrollers.dto.TransactionResponseDto;
import co.luisfbejaranob.backend.investment.fund.manager.shared.exceptions.dto.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.TransactionMappers.dtoToRaw;
import static co.luisfbejaranob.backend.investment.fund.manager.shared.mappers.TransactionMappers.rawToDto;

@RestController
@RequestMapping("transactions")
public class CreateTransactionController
{
    private final CreateTransactionUseCase useCase;

    private final FindFundUseCase findFundUseCase;

    public CreateTransactionController(CreateTransactionUseCase useCase, FindFundUseCase findFundUseCase)
    {
        this.useCase = useCase;
        this.findFundUseCase = findFundUseCase;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> create(@RequestBody TransactionRequestDto transaction) throws IllegalAccessException
    {
        Fund fund = findFundUseCase.findByName(transaction.getFundName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rawToDto(useCase.create(dtoToRaw(transaction, fund))));
    }

    @ExceptionHandler(FundNotFoundException.class)
    public ResponseEntity<Object> handleFundNotFoundException(FundNotFoundException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.NOT_FOUND, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(ClientInsufficientBalanceTransactionException.class)
    public ResponseEntity<Object> handleClientInsufficientBalanceException(ClientInsufficientBalanceTransactionException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(TransactionInsufficientMinimumAmountException.class)
    public ResponseEntity<Object> handleTransactionInsufficientMinimumAmountException(TransactionInsufficientMinimumAmountException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(TransactionTypeAlreadyExistsException.class)
    public ResponseEntity<Object> handleTransactionTypeAlreadyExistsException(TransactionTypeAlreadyExistsException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
