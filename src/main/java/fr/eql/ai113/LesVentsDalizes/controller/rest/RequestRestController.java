package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.RequestPerform;
import fr.eql.ai113.LesVentsDalizes.service.RequestManagmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("request")
public class RequestRestController {
    Logger logger = LoggerFactory.getLogger(getClass());



    //injecté par le setter
    RequestManagmentService requestManagmentService;


    @PostMapping("member/new")
    RequestPerform processOfCreationOfRequestOfPerform(@RequestBody RequestPerform requestPerform){


        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>\r\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //a tester dans Postman : http://localhost:8097/request/member/new
        //json
       /*
        {
            "id":"4",
                "dateCreationRequest": "2023-04-03",
                "datePerformRequested": "2023-06-09",
                "startTime": "09:30:45",
                "endTime": "12:30:45",
                "descriptionRequest": "Ce n'est qu'une tentative..",
                "StatusRequestPerform":{
                     "id":"4",
                    "label": "en phase de test man",
                    "available": true
                },
                "event":{
                    "id":"4",
                    "label": "mariage",
                    "available": true
        },
            "customer":
            {
                "id": 4776777,
                    "name": "jeje",
                    "surname" : "whum",
                    "birthdate" : "1987-12-03",
                    "subscriptionDate" : null,
                    "email" : "jeje@whum.com",
                    "password" : "caporal",
                    "phoneNumber" :"07234(é",
                    "accountClosingDate" : null,
                    "address" :{
                "id":"23",
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
        return requestManagmentService.applyingForPerformance(requestPerform);
    }


    /// SETTERS ///

    @Autowired
    public void setRequestManagmentService(RequestManagmentService requestManagmentService) {
        this.requestManagmentService = requestManagmentService;
    }
}
