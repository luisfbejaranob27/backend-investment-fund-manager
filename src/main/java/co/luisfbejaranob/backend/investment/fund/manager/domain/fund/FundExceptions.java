package co.luisfbejaranob.backend.investment.fund.manager.domain.fund;

public interface FundExceptions
{
    final class FundNotFoundException extends RuntimeException
    {
        public FundNotFoundException(String parameter, String value)
        {
            super("Fund with %s: '%s' not found".formatted(parameter, value));
        }
    }
}
