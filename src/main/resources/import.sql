
-- -- Jeux de données prioritaire

-- #########################################################################################
-- Listing des d'evenements a choisir par le client lors de sa demande de prestation

 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('1', true, 'Anniversaire');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('2', true, 'Mariage');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('3', false,'Fête religieuse');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('4', true, 'Concert / Spectable');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('5', true, "Comité d'entreprise");
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('6', true, 'Séminaire');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('7', true, 'Soirée');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('8', false, 'Manifestation sportive');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES (9, false, "Fête de la musique")
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('10', false, 'Départ en retraite');
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('11', false, "Fête de fin d'année" );
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES ('12', false, "Défilé - periode de carnaval" );

-- #########################################################################################
-- Listing des status des demandes de prestations

 INSERT INTO `status_request_perform` (`id`,  `label`,`available`) VALUES ('1',"En attente de traitement" ,false);
 INSERT INTO `status_request_perform` (`id`,  `label`,`available`) VALUES ('2',"En cours de traitement" ,false);
 INSERT INTO `status_request_perform` (`id`,  `label`,`available`) VALUES ('3',"Valide" ,false);
 INSERT INTO `status_request_perform` (`id`,  `label`,`available`) VALUES ('4',"Refusé" ,false);
 INSERT INTO `status_request_perform` (`id`,  `label`,`available`) VALUES ('5',"Terminé" ,false);



-- #########################################################################################

-- adresses
 INSERT INTO `addresses` (`id`, `number_road`,`road`,`zip_code`,`city`,`country`)  VALUES ('1','24','rue de monopoly','92300','Monrouges','FRANCE');

-- customer pour tester au moins une demande
 INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`email`,`password`,`phone_number`, `account_closing_date`, `address_id` ) VALUES ('1','jeje','rom','1987-12-03',null, 'jeje@whum.com','none', '0607',null, '1');
 --INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`email`,`password`,`phone_number`, `account_closing_date`- ) VALUES ('1','jeje','rom','1987-12-03',null, 'jeje@whum.com','none', '0607',null);



