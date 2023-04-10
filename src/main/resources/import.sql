
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
 INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`email`,`password`,`phone_number`, `account_closing_date`, `address_id`, `dtype` ) VALUES ('1','jeje','rom','1987-12-03',NULL, 'jeje@whum.com','none', '0607',NULL, '1', 'Customer');
 --INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`email`,`password`,`phone_number`, `account_closing_date`- ) VALUES ('1','jeje','rom',NOW(),null, 'jeje@whum.com','none', '0607',null);



-- #########################################################################################
-- DATA pour les instruments de musique

-- Table connexe : categories_instruments

 INSERT INTO `categories_instruments` (`id`,`label`,`available`) VALUES ('1', "Perciussions", true);
 INSERT INTO `categories_instruments` (`id`,`label`,`available`) VALUES ('2', "Cuivres", true);
 INSERT INTO `categories_instruments` (`id`,`label`,`available`) VALUES ('3', "Cordes", true);
 INSERT INTO `categories_instruments` (`id`,`label`,`available`) VALUES ('4', "Autres intruments", true);

-- Table connexe : status_instrument

 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (1, "Neuf", true);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (2, "Comme neuf", false);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (3, "Excellent état", false);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (4, "Bon état", true);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (5, "Usé", true);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (6, "Endommagé", true);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (7, "En réparation", false);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (8, "Perdu", false);
 INSERT INTO `status_instrument` (`id`,`label`,`available`) VALUES (9, "Volé", false);


-- Les instruments (version simplifé)
-- Guadeloupe : Percussions
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (1, "Gwo-ka", "Ensemble de percussions comprenant un tambour ka, un tambour boulas et un tambour makè. Tradition associée : musique gwo-ka, une forme de musique traditionnelle guadeloupéenne et un genre de musique du monde.",true,1,1);
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (2, "Tambour ka", "Tambour cylindrique à deux peaux frappées avec les mains. Tradition associée : musique guadeloupéenne et martiniquaise.",true,1,5);
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (3, "Tambour basses", "Ensemble de tambours cylindriques à une peau frappés avec des baguettes. Tradition associée : musique guadeloupéenne..",true,1,1);
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (4, "Ti-bwa", "Bâton en bambou frappé au sol. Tradition associée : danse traditionnelle guadeloupéenne et martiniquaise.",true,1,1);
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (5, "Chacha", "Maracas en bois. Tradition associée : musique guadeloupéenne et martiniquaise",true,1,1);
 INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (6, "Tanbouyé", "Tambour en bois recouvert de peau de cabri. Tradition associée : musique guadeloupéenne.",true,1,1);
-- Martinique : Percussions (exclusion des doublons)
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (7, "Tambour bèlè", "tambour à fûts parallèles avec deux peaux frappées avec les mains. Tradition associée : musique bèlè, une forme de musique traditionnelle martiniquaise.",true,1,1);
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (8, "Boulas", "Tambour bèlè basse. Tradition associée : musique bèlè..",true,1,1);
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (9, "Ka-shakers", "maracas avec des graines de ka. Tradition associée : musique martiniquaise.",true,1,1);

-- Guadeloupe / Martiniquaise: Cuvires
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (10, "Trompettes", "Tradition associée : musique guadeloupéenne et martiniquaise.",true,2,1);
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (11, "Trombones", "Tradition associée : musique guadeloupéenne et martiniquaise.",true,2,1);

-- Guadeloupe / Martiniquaise: Cordes
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (12, "Guitares créoles", "Tradition associée : musique guadeloupéenne et martiniquaise.",true,3,1);
INSERT INTO `instruments` (`id`,`label`,`description`,`available` ,`category_instrument_id`, `status_instrument_id` ) VALUES (13, "Banjos", "Tradition associée : musique guadeloupéenne et martiniquaise.",true,3,1);
