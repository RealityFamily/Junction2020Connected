import java.io.Serializable;

public class Transaction implements Serializable {
    String timestamp;
    String paymentDate;
    String valueDate;
    String bookingDate;
    double amount;
    double balance;
    String currency;
    String message;
    String reference;
    String accountBic;
    String accountName;
    String accountIban;
    String archiveId;
    String objectId;
    String counterpartyAccountBic;
    String counterpartyAccountName;
    String counterpartyAccountIban;
    long vientiselitekd;
    long taplajikd;


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAccountBic() {
        return accountBic;
    }

    public void setAccountBic(String accountBic) {
        this.accountBic = accountBic;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountIban() {
        return accountIban;
    }

    public void setAccountIban(String accountIban) {
        this.accountIban = accountIban;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCounterpartyAccountBic() {
        return counterpartyAccountBic;
    }

    public void setCounterpartyAccountBic(String counterpartyAccountBic) {
        this.counterpartyAccountBic = counterpartyAccountBic;
    }

    public String getCounterpartyAccountName() {
        return counterpartyAccountName;
    }

    public void setCounterpartyAccountName(String counterpartyAccountName) {
        this.counterpartyAccountName = counterpartyAccountName;
    }

    public String getCounterpartyAccountIban() {
        return counterpartyAccountIban;
    }

    public void setCounterpartyAccountIban(String counterpartyAccountIban) {
        this.counterpartyAccountIban = counterpartyAccountIban;
    }

    public long getVientiselitekd() {
        return vientiselitekd;
    }

    public void setVientiselitekd(long vientiselitekd) {
        this.vientiselitekd = vientiselitekd;
    }

    public long getTaplajikd() {
        return taplajikd;
    }

    public void setTaplajikd(long taplajikd) {
        this.taplajikd = taplajikd;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timestamp='" + timestamp + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", message='" + message + '\'' +
                ", reference='" + reference + '\'' +
                ", accountBic='" + accountBic + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountIban='" + accountIban + '\'' +
                ", archiveId=" + archiveId +
                ", objectId='" + objectId + '\'' +
                ", counterpartyAccountBic='" + counterpartyAccountBic + '\'' +
                ", counterpartyAccountName='" + counterpartyAccountName + '\'' +
                ", counterpartyAccountIban='" + counterpartyAccountIban + '\'' +
                ", vientiselitekd=" + vientiselitekd +
                ", taplajikd=" + taplajikd +
                '}';
    }
}
