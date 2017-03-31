import java.util.Date;

public interface ReceiptFormatter {

  enum TransactionType {
    INQUIRY, WITHDRAW, TRANSFER
  }

  Date getDate();

  TransactionType getTransType();

  void setTransType(TransactionType transType);

  Account getAcc();

  void setAcc(Account acc);
}
