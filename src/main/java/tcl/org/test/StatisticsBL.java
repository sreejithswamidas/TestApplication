//Add Business Logic for Statistics API Here
package tcl.org.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StatisticsBL {
    @Autowired
    TransactionList transactionList;
    StatisticsModel statisticsModel;
    StatisticsBL(){
        transactionList= new TransactionList();
        statisticsModel=new StatisticsModel();
    }

    public StatisticsModel setStatisticsModel() {

        statisticsModel=transactionList.setStatisticsModel(statisticsModel);

        return statisticsModel;

    }
}
