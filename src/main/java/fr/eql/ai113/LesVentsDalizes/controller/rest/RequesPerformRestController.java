package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentCustomerException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentEventException;
import fr.eql.ai113.LesVentsDalizes.exceptions.NonExistentStatusPerformException;
import fr.eql.ai113.LesVentsDalizes.exceptions.RequestPerformRegistrationFailedException;
import fr.eql.ai113.LesVentsDalizes.service.RequestManagmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request")
public class RequesPerformRestController {
    Logger logger = LoggerFactory.getLogger(getClass());



    //injecté par le setter
    RequestManagmentService requestManagmentService;


    @PostMapping("member/new")
    public ResponseEntity< ? > processOfCreationOfRequestOfPerform(@RequestBody RequestPerform requestPerform)  {


        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>\r\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //a tester dans Postman : http://localhost:8097/request/member/new
        //json
       /*

        {
            "id":"1",
                "dateCreationRequest": "2023-04-03",
                "datePerformRequested": "2023-06-09",
                "startTime": "09:30:45",
                "endTime": "12:30:45",
                "descriptionRequest": "Ce n'est qu'une tentative. yoyoyoyoyo .",
                "statusRequestPerform":{
                     "id":"1",
                    "label": "en phase de test man",
                    "available": true
                },
                "event":{
                    "id":"2",
                    "label": "mariage",
                    "available": true
        },
            "customer":
            {
                "id": 1,
                    "name": "jeje",
                    "surname" : "whum",
                    "birthdate" : "1987-12-03",
                    "subscriptionDate" : null,
                    "email" : "jejeh@whum.com",
                    "password" : "caporal",
                    "phoneNumber" :"07234(é",
                    "accountClosingDate" : null,
                    "address" :{
                "id":"1",
                        "numberRoad": "94",
                        "road":"cJoisy ",
                        "zipCode":"94413",
                        "city":"VAl",
                        "country": "France"
            },
                "dateOfMembership":"2023-01-04",
                    "registrationFee":50.0,
                    "upToDate":true,
                    "customerBecomingMember":false,
                    "annualFeesList":null
            }
        }

        */
        RequestPerform requestPerformChecked = null;
        try {
            requestPerformChecked = requestManagmentService.applyingForPerformance(requestPerform);
            logger.info("controle\t\r\n"+requestPerformChecked.toString());
        }catch(NonExistentCustomerException e){
           // return ResponseEntity.badRequest().body(e);
            logger.info("La demande de prestation à échouée car "+e);
            return ResponseEntity.badRequest().body(""+e.getMessage());
        }catch(NonExistentEventException e){
            logger.info("La demande de prestation à échouée car "+e);
            return  ResponseEntity.badRequest().body(""+e.getMessage());
        }catch(NonExistentStatusPerformException e){
            logger.info("La demade de prestatuon à échoué car "+e);
            return  ResponseEntity.badRequest().body(""+e.getMessage());
        }catch(RequestPerformRegistrationFailedException e){
            logger.info("La demade de prestatuon à échoué car "+e);
            return ResponseEntity.badRequest().body("La demade de prestatuon n'a pu aboutir.. "+e.getMessage());
        }

        return ResponseEntity.ok(requestPerformChecked);
    }


    /// SETTERS ///

    @Autowired
    public void setRequestManagmentService(RequestManagmentService requestManagmentService) {
        this.requestManagmentService = requestManagmentService;
    }
}
