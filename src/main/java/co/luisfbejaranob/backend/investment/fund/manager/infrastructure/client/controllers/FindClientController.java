package co.luisfbejaranob.backend.investment.fund.manager.infrastructure.client.controllers;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.FindClientUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
public class FindClientController
{
    private final FindClientUseCase useCase;

    public FindClientController(FindClientUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> findById(@PathVariable String id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.findById(id));
    }
}
