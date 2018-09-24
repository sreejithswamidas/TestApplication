//Business Logic for Transaction Processing
package tcl.org.test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class TransactionBL {

    List transactions;
    @Autowired
    TransactionList transactionList;
    StatisticsModel statisticsModel;


    TransactionBL(){
        transactionList = new TransactionList();
        statisticsModel= new StatisticsModel();
    }
    Boolean checkTimeStamp(long timeStamp){
        return transactionList.checkTimeStamp(timeStamp);
    }

    void add(TransactionModel transaction){
        transactionList.add(transaction);
    }


}
