package tcl.org.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StatisticsController {
    StatisticsBL statisticsBL;
    StatisticsModel statisticsModel;

    public StatisticsController() {
        statisticsModel=new StatisticsModel();
        statisticsBL=new StatisticsBL();
    }

    @GetMapping(value = "/statistics",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public StatisticsModel statistics(){
        statisticsModel=statisticsBL.setStatisticsModel();
        return statisticsModel;
    }

}
