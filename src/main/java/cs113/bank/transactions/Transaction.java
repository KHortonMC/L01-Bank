package cs113.bank.transactions;

import java.time.*;
import java.util.Date;

public class Transaction {
    public enum Type {
        InitialDeposit,
        Withdrawal,
        Deposit,
        Interest,
        NewAccountFee,
        OverdraftFee,
        EarlyWithdrawalFee
    }

    public enum Result {
        SUCCESS,
        INSUFFICIENT_FUNDS,
        LIMIT_EXCEEDED,
        NOT_IMPLEMENTED
    }

    public enum Errors {
        INSUFFICIENT_FUNDS,
        WITHDRAWAL_LIMIT_EXCEEDED,
    }

    Type transactionType;
    double amount;
    Date date;

    public Transaction(Type type, double amount) {
        this.transactionType = type;
        this.amount = amount;

        // Time & Date from chatGPT
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        java.time.Instant instant = zonedDateTime.toInstant();
        this.date = Date.from(instant);
    }

    public Type getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
    public Date getDate() { return date; }
    public String getTransactionDescription() { return transactionType.toString(); }
}
