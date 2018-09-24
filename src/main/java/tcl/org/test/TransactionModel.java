//Model class for Transaction API
package tcl.org.test;

import java.util.Date;

public class TransactionModel {
    private float amount;
    private long timestamp;

    public float getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
