//CORE!!
//Stores and processes transactions
package tcl.org.test;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(TimeStamp>System.currentTimeMillis())
            return Boolean.FALSE;
        long EndDate= System.currentTimeMillis();
        long StartDate= EndDate-(60*1000);
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
   public StatisticsModel setStatisticsModel(StatisticsModel statisticsModel){
        transactions=transactions.stream().filter(t->checkTimeStamp(t.getTimestamp())).collect(Collectors.toList());
       count=0;
       total=0;
       average=0;
       max=0;
       min=100;
        if(!transactions.isEmpty()) {
            count = (int) transactions.stream().count();
            total = (float) transactions.stream().mapToDouble(TransactionModel::getAmount).sum();
            average = (float) transactions.stream().mapToDouble(TransactionModel::getAmount).average().getAsDouble();
            min = (float) transactions.stream().mapToDouble(TransactionModel::getAmount).min().getAsDouble();
            max = (float) transactions.stream().mapToDouble(TransactionModel::getAmount).max().getAsDouble();
            statisticsModel.setMin(min);
        }
        //if no transaction i last 60 seconds
        else statisticsModel.setMin(0);
        statisticsModel.setCount(count);
        statisticsModel.setTotal(setDecimalPoints(total));
        statisticsModel.setAverage(setDecimalPoints(average));
        statisticsModel.setMax(max);
        return statisticsModel;

        }


   }


