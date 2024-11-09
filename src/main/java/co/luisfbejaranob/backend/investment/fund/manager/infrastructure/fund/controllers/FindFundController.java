package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.FindFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.FundExceptions;
import co.luisfbejaranob.backend.investment.fund.manager.shared.exceptions.dto.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funds")
public class FindFundController
{
    private final FindFundUseCase useCase;

    public FindFundController(FindFundUseCase useCase)
    {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<Fund>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Fund> findById(@PathVariable String id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Fund> findByName(@PathVariable String name)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.findByName(name));
    }

    @ExceptionHandler(FundExceptions.FundNotFoundException.class)
    public ResponseEntity<Object> handleFundNotFoundException(FundExceptions.FundNotFoundException ex)
    {
        ApiErrorDto apiError =
                new ApiErrorDto(HttpStatus.NOT_FOUND, ex.getMessage());

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
