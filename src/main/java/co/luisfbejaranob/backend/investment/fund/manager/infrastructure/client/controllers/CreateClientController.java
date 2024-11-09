package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.CreateClientUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientInsufficientInitialAmountException;
import co.luisfbejaranob.backend.investment.fund.manager.shared.exceptions.dto.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class CreateClientController
{
    private final CreateClientUseCase useCase;

    public CreateClientController(CreateClientUseCase useCase)
    {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(useCase.create(client));
    }

    @ExceptionHandler(ClientInsufficientInitialAmountException.class)
    public ResponseEntity<Object> handleInsufficientInitialAmountException(ClientInsufficientInitialAmountException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
