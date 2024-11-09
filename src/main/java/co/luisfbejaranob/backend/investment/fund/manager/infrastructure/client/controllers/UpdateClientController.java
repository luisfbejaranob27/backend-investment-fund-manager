package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.UpdateClientUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class UpdateClientController
{
    private final UpdateClientUseCase useCase;

    public UpdateClientController(UpdateClientUseCase useCase)
    {
        this.useCase = useCase;
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@PathVariable String id, @RequestBody Client client) throws IllegalAccessException
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.update(id, client));
    }
}
