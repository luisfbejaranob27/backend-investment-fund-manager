package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.fund.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.fund.DeleteFundUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funds")
public class DeleteFundController
{
    private final DeleteFundUseCase useCase;

    public DeleteFundController(DeleteFundUseCase useCase)
    {
        this.useCase = useCase;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id)
    {
        useCase.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
