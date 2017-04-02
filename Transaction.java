import java.sql.Date;

/*
 * Each transaction that is made in the ATM will be stored as this object. Transactions include (and
 * are not limited to): withdrawing, depositing, last four digits of cc number when card is put into
 * the machine, number of invalid pin code attempts, the amount of money left in the machine after
 * each withdraw or deposit.
 */
abstract class Transaction {
  // the time that the transaction took place
  private Date transDate;
  private Integer transNumber;

  // the account that the transaction belongs to
  Account acc;

  public Date getTransDate() {
    return transDate;
  }

  public int getTransNumber() {
    if (this.transNumber == null) {
      this.transNumber = Utilities.randNumber(100000, 10000000);
    }
    return this.transNumber;
  }

  public void setTransDate(Date transDate) {
    this.transDate = transDate;
  }

  public float getAmount() {
    // TODO Auto-generated method stub
    return 0;
  }

}
