package tcl.org.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransactionController {

    TransactionBL transactionBL;

    TransactionController(){
        transactionBL=new TransactionBL();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/transact",consumes = "application/json",produces = "application/json")
   public  ResponseEntity<Object> transact(@RequestBody TransactionModel transaction){

        if(transactionBL.checkTimeStamp(transaction.getTimestamp()))
        {
            //If within 60 seconds
           transactionBL.add(transaction);
           //HTTP 201
           return new ResponseEntity<>(HttpStatus.CREATED);
       }
       else
           //HTTP 204
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }



}
