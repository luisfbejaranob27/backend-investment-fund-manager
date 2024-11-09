package co.luisfbejaranob.backend.investment.fund.manager.domain.client;

public interface ClientExceptions
{
    final class ClientNotFoundException extends RuntimeException
    {
        public ClientNotFoundException(String id)
        {
            super("Client with Id: %s not found".formatted(id));
        }
    }

    final class ClientInsufficientInitialAmountException extends RuntimeException
    {
        public ClientInsufficientInitialAmountException()
        {
            super("Insufficient initial amount");
        }
    }

    final class ClientInsufficientBalanceException extends RuntimeException
    {
        public ClientInsufficientBalanceException()
        {
            super("Insufficient balance");
        }
    }

    final class ClientInsufficientBalanceTransactionException extends RuntimeException
    {
        public ClientInsufficientBalanceTransactionException(String fund)
        {
            super("You do not have available balance to link to the fund: %s".formatted(fund));
        }
    }
}

