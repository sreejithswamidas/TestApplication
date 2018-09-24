//CORE!!
//Stores and processes transactions
package tcl.org.test;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionList {

    StatisticsModel statisticsModel;
    public static List<TransactionModel> transactions= new ArrayList<TransactionModel>();
    int count;
    float total;
    float average;
    float max;
    float min;

    TransactionList(){
        statisticsModel=new StatisticsModel();
    }

    //Add a new transaction
    public void add(TransactionModel transaction){

        transactions.add(transaction);
    }

    //Check a Time Stamp is within the limit of 60 seconds
    Boolean checkTimeStamp(long TimeStamp)
    {
        long EndDate= System.currentTimeMillis();
        long StartDate= EndDate-(1*60*1000);
        System.out.println(EndDate);
        if(TimeStamp<EndDate && TimeStamp>StartDate)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    //Setting precision for float value (INR xx.xx)
    float setDecimalPoints(float number){
        DecimalFormat decimalFormat=new DecimalFormat("00.00");
        String s=decimalFormat.format(number);
        number= Float.parseFloat(s);
        return  number;
    }
    //Set statistics model values
    public StatisticsModel setStatisticsModel(StatisticsModel statisticsModel)
    {
        count=0;
        total=0;
        average=0;
        max=0;
        min=100;
        boolean nocontent=true;
        for(TransactionModel transaction:transactions){
            float amount=transaction.getAmount();
            if(checkTimeStamp(transaction.getTimestamp())) {
                nocontent=false;
                count++;
                total += transaction.getAmount();
                average = total / count;
                if (amount > max)
                    max = amount;
                if (amount < min)
                    min = amount;
            }
        }

        statisticsModel.setCount(count);
        statisticsModel.setTotal(setDecimalPoints(total));
        statisticsModel.setAverage(setDecimalPoints(average));
        statisticsModel.setMax(max);
        //if no transaction i last 60 seconds
        if(nocontent){
            statisticsModel.setMin(0);
        }
        else
        statisticsModel.setMin(min);
        return statisticsModel;
    }
}
