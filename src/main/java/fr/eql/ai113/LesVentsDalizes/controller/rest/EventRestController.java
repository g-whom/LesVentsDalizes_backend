package fr.eql.ai113.LesVentsDalizes.controller.rest;

import fr.eql.ai113.LesVentsDalizes.entity.Event;
import fr.eql.ai113.LesVentsDalizes.entity.Response;
import fr.eql.ai113.LesVentsDalizes.service.RequestManagmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("events")
public class EventRestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    RequestManagmentService requestManagmentService;

    //WIP

    @GetMapping("/show/all")
    public ResponseEntity<?> retrieveEvents(){
        /*
        Dans postMan : http://localhost:8097/events/show/all
         */

        List<Event> eventList = new ArrayList<>();
        try{
            eventList = requestManagmentService.showAllEvents();
        }catch(Exception e){
            logger.info("Impossible de recupérer la liste des événements");
            return ResponseEntity.badRequest().body("Une anomalie s'est produite");
        }

        return ResponseEntity.ok(eventList);
    }

    /**
     * for adding an event...
     * @param event
     * @return
     */
    @PostMapping("/new")
    public ResponseEntity<?> saveNewEvent(@RequestBody Event event){
        /*
        Dans postMan : http://localhost:8097/events/new

        Json:
            {
                "label":"Test twone",
                "available": true
            }
         */
        Event eventToCheck= null;
        try {
             eventToCheck = requestManagmentService.feedEvents(event);
        }catch (Exception e){

            logger.info("L'ajout du nouvelle évenement n'a pu aboutir en base de données "+e);
            return ResponseEntity.badRequest().body(" Une annomalie s'est produite"); //+e.getMessage());
        }
        if( eventToCheck==null){
            return ResponseEntity.badRequest().body("Une anomalie s'est produite lors de l'ajout de l'Evenement");
        }


       return ResponseEntity.ok(eventToCheck);
    }






    /// SETTERS ///
    @Autowired
    public void setRequestManagmentService(RequestManagmentService requestManagmentService) {
        this.requestManagmentService = requestManagmentService;
    }
}
