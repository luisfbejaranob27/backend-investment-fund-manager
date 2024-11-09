package co.luisfbejaranob.backend.investment.fund.manager.domain.transaction;

public interface TransactionExceptions
{
    final class TransactionNotFoundException extends RuntimeException
    {
        public TransactionNotFoundException(String parameter, String value)
        {
            super("Transaction with %s: '%s' not found".formatted(parameter, value));
        }
    }

    final class TransactionInsufficientMinimumAmountException extends RuntimeException
    {
        public TransactionInsufficientMinimumAmountException()
        {
            super("Insufficient minimum amount for the transaction");
        }
    }

    final class TransactionTypeNotSupportedException extends RuntimeException
    {
        public TransactionTypeNotSupportedException(String type)
        {
            super("Transaction type: %s not supported".formatted(type));
        }
    }

    final class TransactionTypeAlreadyExistsException extends RuntimeException
    {
        public TransactionTypeAlreadyExistsException(String type)
        {
            super("Transaction type: %s already exists".formatted(type));
        }
    }
}
