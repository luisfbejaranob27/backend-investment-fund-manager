package co.luisfbejaranob.backend.investment.fund.manager.application.usecase.transaction;

import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.OperationsBalanceClientUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.application.usecase.client.FindClientUseCase;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.Client;
import co.luisfbejaranob.backend.investment.fund.manager.domain.client.ClientExceptions.ClientInsufficientBalanceTransactionException;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.Transaction;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionExceptions.*;
import co.luisfbejaranob.backend.investment.fund.manager.domain.transaction.TransactionRepository;
import co.luisfbejaranob.backend.investment.fund.manager.infrastructure.notifications.email.SendEmail;
import org.springframework.stereotype.Component;

@Component
public class CreateTransactionUseCase
{
    private final TransactionRepository repository;

    private final FindClientUseCase findClientUseCase;
    
    private final OperationsBalanceClientUseCase operationsBalanceClientUseCase;

    private final SendEmail sendEmail;

    public CreateTransactionUseCase(TransactionRepository repository, FindClientUseCase findClientUseCase, OperationsBalanceClientUseCase operationsBalanceClientUseCase, SendEmail sendEmail)
    {
        this.repository = repository;
        this.findClientUseCase = findClientUseCase;
        this.operationsBalanceClientUseCase = operationsBalanceClientUseCase;
        this.sendEmail = sendEmail;
    }

    public Transaction create(Transaction transaction) throws IllegalAccessException
    {
        Client client = findClientUseCase.findById(transaction.getClientId());

        if(transaction.getFund().getMinimumAmount() > client.getBalance())
        {
            throw new ClientInsufficientBalanceTransactionException(transaction.getFund().getName());
        }

        if(transaction.getFund().getMinimumAmount() > transaction.getAmount())
        {
            throw new TransactionInsufficientMinimumAmountException();
        }

        Transaction transactionFound = repository.findByClientIdAndFund(transaction.getClientId(), transaction.getFund());

        if(transactionFound != null)
        {
            if(transactionFound.getType().equals("Opening") && transaction.getType().equals("Cancellation"))
            {
                operationsBalanceClientUseCase.creditBalance(client, transactionFound.getAmount());
            }
            else if(transactionFound.getType().equals("Opening") && transaction.getType().equals("Opening"))
            {
                throw new TransactionTypeAlreadyExistsException(transaction.getType());
            }
            else if(transactionFound.getType().equals("Cancellation") && transaction.getType().equals("Cancellation"))
            {
                throw new TransactionTypeAlreadyExistsException(transaction.getType());
            }
            else{
                throw new TransactionTypeNotSupportedException(transaction.getType());
            }
        }

        if(transaction.getType().equals("Opening"))
        {
            operationsBalanceClientUseCase.debitAmount(client, transaction.getAmount());
        }

        if(client.getNotification().equals("EMAIL"))
        {
            sendEmail.execute(client.getEmail(), transaction.getFund().getName());
            transaction.setNotificationSent(true);
        }

        return repository.create(transaction);
    }
}
