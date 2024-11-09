package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.DeleteClientUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class DeleteClientController
{
    private final DeleteClientUseCase useCase;

    public DeleteClientController(DeleteClientUseCase useCase)
    {
        this.useCase = useCase;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id)
    {
        useCase.deleteById(id);
        
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
