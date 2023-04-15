package fr.eql.ai113.LesVentsDalizes.config;

import fr.eql.ai113.LesVentsDalizes.service.PasswordUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * this class is a custom configuration to call the method of changing passwords from the
 * imported data sets, especially for customers and their passwords
 */
@Configuration
public class PasswordConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    private PasswordUpdateService passwordUpdateService;

    @EventListener(ApplicationReadyEvent.class)
    public  void onApplicationReady(){

        passwordUpdateService.updateColumnPasswordWithBcrypt(
                "cutomers",
                "password",
                1 ,
                98);

        logger.info("Votre application avec configuration personnalisée a été démarrée avec succès !");
    }

    /// SETTER ///
    @Autowired
    public void setPasswordUpdateService(PasswordUpdateService passwordUpdateService) {
        this.passwordUpdateService = passwordUpdateService;
    }
}
