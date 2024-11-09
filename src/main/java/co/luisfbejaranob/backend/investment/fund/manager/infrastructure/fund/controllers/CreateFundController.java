package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.CreateFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundExceptions.FundNotFoundException;
import co.luisfbejaranob.backend.investment.fund.manager.shared.exceptions.dto.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funds")
public class CreateFundController
{
    private final CreateFundUseCase useCase;

    public CreateFundController(CreateFundUseCase useCase)
    {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Fund> create(@RequestBody Fund fund)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(useCase.create(fund));
    }
}
