package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.UpdateFundUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.fund.Fund;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funds")
public class UpdateFundController
{
    private final UpdateFundUseCase useCase;

    public UpdateFundController(UpdateFundUseCase useCase)
    {
        this.useCase = useCase;
    }

    @PutMapping("{id}")
    public ResponseEntity<Fund> update(@PathVariable String id, @RequestBody Fund fund) throws IllegalAccessException
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.update(id, fund));
    }
}
