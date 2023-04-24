
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
 INSERT INTO `event` (`id`,  `available`,`label`) VALUES (9, false, "Fête de la musique");
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
INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`username`,`password`,`phone_number`, `account_closing_date`, `address_id`, `dtype` ) VALUES ('1','jeje','rom','1987-12-03',NULL, 'jeje@whum.com','none', '0607',NULL, '1', 'Customer');
--INSERT INTO `customers` (`id`, `name`, `surname`,`birthdate`,`subscription_date`,`username`,`password`,`phone_number`, `account_closing_date`- ) VALUES ('1','jeje','rom',NOW(),NULL, 'jeje@whum.com','none', '0607',NULL);




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


-- #########################################################################################
-- DATA pour : status_member
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (1,"Président",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (2,"Secrétaire",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (3,"Trésorier",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (4,"Danseur",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (5,"Musicien",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (6,"Photographe",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (7,"Porteur de drapeau",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (8,"Chorégraphe",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (9,"Couturière",true);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (10,"Bénévole",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (11,"Membre bienfaiteur",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (12,"Sécurité",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (13,"Gestionnaire de communauté",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (14,"DJ",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (15,"Monteur vidéo",false);
 INSERT INTO `status_member` (`id`,`label`,`available`) VALUES (16,"Logisticien",false);




--
-- -- #########################################################################################
--
-- -- DATA pour : adresses (customers) (phase 02)
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (2, '2 finger in the nose', '1 Everett Trail', '75013 CEDEX', 'Paris', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (3, '3 Mosinee Road', '1 Everett Trail', '91424 CEDEX', 'Morangis', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (4, '6500 Golden Leaf Drive', '6515 Sommers Center', '14908 CEDEX 9', 'Caen', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (5, '0 Lotheville Pass', '124 Buhler Place', '74304 CEDEX', 'Cluses', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (6, '5809 Carberry Court', '41309 Northfield Terrace', '35914 CEDEX 9', 'Rennes', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (7, '071 Warrior Circle', '856 Heath Crossing', '24111 CEDEX', 'Bergerac', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (8, '82 Pearson Pass', '22169 Mendota Plaza', '75659 CEDEX 13', 'Paris 13', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (9, '277 Russell Alley', '3187 Upham Way', '61042 CEDEX', 'Alençon', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (10, '18275 Summerview Junction', '48 Corben Avenue', '13293 CEDEX 08', 'Marseille', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (11, '7 Westridge Hill', '2719 Goodland Avenue', '91154 CEDEX', 'Étampes', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (12, '046 Burrows Pass', '65263 Farwell Drive', '67504 CEDEX', 'Haguenau', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (13, '8654 Mallard Circle', '40 Wayridge Point', '13674 CEDEX', 'Aubagne', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (14, '04966 Towne Lane', '65811 Glacier Hill Drive', '21019 CEDEX', 'Dijon', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (15, '35 Mockingbird Crossing', '327 Portage Park', '61304 CEDEX', 'L''Aigle', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (16, '5 Prairieview Street', '36652 Dorton Lane', '35513 CEDEX', 'Cesson-Sévigné', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (17, '193 Nova Pass', '5379 Susan Pass', '79042 CEDEX 9', 'Niort', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (18, '23342 Bobwhite Hill', '6138 Division Park', '71109 CEDEX', 'Chalon-sur-Saône', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (19, '0261 Meadow Valley Trail', '18329 Jenna Park', '39104 CEDEX', 'Dole', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (20, '186 Boyd Avenue', '952 Vidon Junction', '94631 CEDEX 1', 'Rungis', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (21, '15835 Mcguire Alley', '118 Eastwood Drive', '13792 CEDEX 3', 'Aix-en-Provence', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (22, '1 Warbler Plaza', '4 Kings Park', '53085 CEDEX 9', 'Laval', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (23, '336 International Point', '8 Northridge Parkway', '33911 CEDEX 9', 'Bordeaux', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (24, '24186 Shopko Alley', '453 Badeau Lane', '68064 CEDEX 3', 'Mulhouse', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (25, '5 Manley Road', '519 Ronald Regan Street', '38009 CEDEX 1', 'Grenoble', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (26, '529 Judy Lane', '36620 Saint Paul Hill', '20292 CEDEX', 'Bastia', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (27, '334 Clyde Gallagher Way', '9316 Utah Terrace', '79004 CEDEX', 'Niort', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (28, '67 Clarendon Point', '8405 Rieder Junction', '13444 CEDEX 06', 'Marseille', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (29, '7 Melrose Pass', '78573 Scott Lane', '38164 CEDEX', 'Saint-Marcellin', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (30, '9537 Superior Park', '097 Mcguire Alley', '83484 CEDEX', 'Puget-sur-Argens', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (31, '103 Sycamore Hill', '53824 Parkside Drive', '76204 CEDEX', 'Dieppe', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (32, '0217 Express Terrace', '2 Hansons Terrace', '83613 CEDEX', 'Fréjus', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (33, '2 Pond Parkway', '70 Eliot Parkway', '35009 CEDEX', 'Rennes', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (34, '3067 Union Drive', '911 Hoepker Street', '57609 CEDEX', 'Forbach', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (35, '65 Prairie Rose Terrace', '97 Sullivan Avenue', '97435', 'Saint-Paul', 'Reunion');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (36, '6799 Bunker Hill Avenue', '00 Farragut Terrace', '13548 CEDEX', 'Gardanne', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (37, '40 Lake View Trail', '78 6th Pass', '15015 CEDEX', 'Aurillac', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (38, '041 Ludington Parkway', '936 Monument Road', '59002 CEDEX', 'Lille', 'France');
-- insert into `addresses` (`id`, `number_road`, `road`, `zip_code`, `city`, `country`) values (39, '5310 Tomscot Street', '4872 Nevada Trail', '77794 CEDEX', 'Nemours', 'France');
--
--
--
-- -- DATA pour : customers (phase 02)
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (2, 'Dredi', 'Broxton', '2016-09-09', '2023-04-05', 'dbroxton0@theguardian.com', '2mMJDbv5V3l3', '+351 (500) 730-4615', null, 16, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (3, 'Federico', 'O''Mara', '1987-07-14', '2022-01-22', 'fomara1@oaic.gov.au', 'kKzEQbXSaITj', '+46 (763) 283-6037', null, 13, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (4, 'Pammi', 'Comi', '1946-08-09', '2022-05-11', 'pcomi2@yahoo.com', 'bqJibKs', '+358 (643) 462-6648', null, 29, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (5, 'Gabi', 'Pollock', '1998-08-05', '2022-07-09', 'gpollock3@seesaa.net', 'fpLYbWOI', '+7 (517) 904-3864', null, 27, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (6, 'Cara', 'Jeannot', '1960-06-15', '2023-01-20', 'cjeannot4@gnu.org', 'bK9JrvKYPXj', '+86 (871) 155-1331', null, 29, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (7, 'Dolley', 'Kener', '1960-09-05', '2020-09-11', 'dkener5@geocities.com', 'hrEqgrBzW3', '+48 (868) 181-7720', null, 10, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (8, 'Berri', 'Harriday', '1938-09-24', '2021-09-01', 'bharriday6@sitemeter.com', 'JdBlntb7ah', '+33 (735) 801-3279', null, 4, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (9, 'Rosmunda', 'Brend', '2009-06-23', '2021-10-01', 'rbrend7@networksolutions.com', 'HwgCDEQAbI', '+62 (477) 689-9621', null, 33, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (10, 'Dilly', 'Fussell', '1970-08-21', '2021-03-02', 'dfussell8@huffingtonpost.com', 'Xj51Seist1', '+7 (974) 482-6661', null, 4, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (11, 'Myrvyn', 'Perrins', '1944-08-26', '2020-05-23', 'mperrins9@oracle.com', 'BUQg5kDQ5Y', '+7 (731) 373-2246', null, 1, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (12, 'Bowie', 'McKitterick', '1963-05-13', '2020-05-17', 'bmckittericka@1688.com', '3scqWaQhN4', '+880 (304) 852-1320', null, 10, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (13, 'Bethanne', 'O''Brogan', '1954-10-17', '2021-05-26', 'bobroganb@patch.com', 'BxDPux', '+86 (874) 432-2906', null, 3, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (14, 'Minette', 'Bush', '1981-05-22', '2021-12-18', 'mbushc@youtube.com', '9uKcmXHi5wj', '+86 (914) 813-3174', null, 38, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (15, 'Catherine', 'Cleveley', '1974-02-13', '2020-05-16', 'ccleveleyd@abc.net.au', 'TDpUrLin91Nn', '+86 (788) 830-4857', null, 34, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (16, 'Zacherie', 'Sweeting', '1951-02-02', '2020-04-19', 'zsweetinge@virginia.edu', 'EU0zfh3LB', '+86 (471) 941-2377', null, 21, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (17, 'Ronna', 'Wyles', '1955-04-12', '2021-05-26', 'rwylesf@mozilla.com', 'IbE8FqRF', '+86 (998) 259-5007', null, 5, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (18, 'Agnes', 'Secretan', '1967-03-23', '2020-06-29', 'asecretang@slideshare.net', 'kpTLUgR', '+375 (633) 501-1254', null, 4, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (19, 'Brady', 'Sheehan', '1972-02-19', '2022-06-02', 'bsheehanh@meetup.com', 'BMOi1BMgOgL7', '+254 (324) 200-5538', null, 13, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (20, 'Verine', 'Whiley', '1956-11-18', '2022-05-07', 'vwhileyi@oakley.com', 'dm1Svj1YKhRd', '+46 (345) 883-5205', null, 14, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (21, 'Florenza', 'Dedrick', '1947-05-06', '2021-06-19', 'fdedrickj@so-net.ne.jp', 'JE9HT2', '+370 (358) 243-9082', null, 2, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (22, 'Axe', 'Straughan', '1968-08-20', '2021-08-09', 'astraughank@opensource.org', 'mjfmUzZGQlt7', '+358 (738) 135-8303', null, 28, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (23, 'Aurea', 'Doget', '2001-03-14', '2021-05-26', 'adogetl@imgur.com', 'hj8eVrkvnnzd', '+1 (360) 860-1602', null, 29, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (24, 'Willard', 'Bellchamber', '1947-06-27', '2021-06-06', 'wbellchamberm@redcross.org', 'PzG9j8', '+7 (160) 695-5573', null, 30, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (25, 'Natalee', 'Grieger', '1973-03-18', '2021-06-30', 'ngriegern@weather.com', '5Gkp4g', '+81 (949) 750-3304', null, 38, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (26, 'Quintina', 'Torresi', '1946-02-25', '2020-07-28', 'qtorresio@wufoo.com', 'RL0NpPGiMPiR', '+7 (840) 531-8175', null, 31, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (27, 'Tymothy', 'Saterweyte', '1987-07-31', '2021-11-05', 'tsaterweytep@smh.com.au', '5wMecYA5y4s', '+57 (273) 482-7630', null, 11, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (28, 'Clarinda', 'Barthelet', '1998-01-12', '2022-09-10', 'cbartheletq@census.gov', 'uM8CYgDRAgu', '+86 (530) 926-0591', null, 11, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (29, 'Bunnie', 'Goodge', '1977-12-09', '2021-06-05', 'bgoodger@fastcompany.com', 'x97Z6ZMrKW', '+86 (172) 441-4845', null, 9, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (30, 'Jenine', 'Bush', '1943-04-21', '2021-12-27', 'jbushs@trellian.com', 'RQ9lAJb9', '+63 (184) 357-6150', null, 25, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (31, 'Mateo', 'Jossum', '1992-02-16', '2022-07-28', 'mjossumt@cornell.edu', 'ybfLuGrfRbu', '+383 (185) 715-5316', null, 29, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (32, 'Rutherford', 'Grzegorczyk', '1952-12-18', '2021-01-15', 'rgrzegorczyku@jimdo.com', 'DYt366', '+86 (479) 486-5324', null, 31, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (33, 'Stefano', 'Treharne', '1960-11-02', '2020-12-15', 'streharnev@pinterest.com', 'YNLbpUu5', '+420 (840) 541-6258', null, 31, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (34, 'Myra', 'Drewery', '1944-07-12', '2021-09-13', 'mdreweryw@nifty.com', 'fZAu3H', '+351 (228) 735-9341', null, 36, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (35, 'Laverna', 'Brasted', '1948-06-03', '2022-11-17', 'lbrastedx@elpais.com', 'XLQPfey2cJ', '+86 (470) 498-8962', null, 2, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (36, 'Justino', 'Zarfat', '1948-07-03', '2021-12-19', 'jzarfaty@cam.ac.uk', 'wHRkOv', '+387 (120) 317-3699', null, 3, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (37, 'Ely', 'Sheeran', '1943-09-07', '2020-10-31', 'esheeranz@theglobeandmail.com', 'Mta6z4mO', '+212 (348) 688-3442', null, 15, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (38, 'Rafaello', 'Noone', '1947-07-11', '2022-06-05', 'rnoone10@noaa.gov', 'h0HzH2Q', '+234 (142) 583-7404', null, 37, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (39, 'Roanna', 'Latehouse', '2009-02-04', '2022-03-01', 'rlatehouse11@wp.com', 'BuGDKUzZvOy', '+62 (330) 881-5789', null, 26, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (40, 'Bessie', 'De Giorgio', '1937-11-05', '2021-09-22', 'bdegiorgio12@creativecommons.org', 'C9FkxnygwylK', '+1 (516) 500-6901', null, 32, 'Customer');
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (41, 'Selig', 'Kilday', '1957-09-29', '2022-02-02', 'skilday13@squidoo.com', 'eyQHlVYUI', '+420 (172) 949-5015', null, 7, 'Customer');
--
--
-- -- DATA pour : adresses (Memeber) (phase 02)
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('3 Hooker Point', '48 East Street', '06182 CEDEX 2', 'Nice', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('4512 Waubesa Terrace', '28 Utah Crossing', '20184 CEDEX 1', 'Ajaccio', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('74098 5th Trail', '57905 Hayes Way', '59704 CEDEX', 'Marcq-en-Barœul', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('48 Lien Avenue', '042 Graceland Lane', '66013 CEDEX 9', 'Perpignan', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('03744 Shelley Avenue', '911 Luster Street', '79099 CEDEX 9', 'Niort', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('17 Bluestem Hill', '571 Division Street', '11860 CEDEX 9', 'Carcassonne', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('8644 Kinsman Plaza', '7 Starling Terrace', '57032 CEDEX 01', 'Metz', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('22615 Scoville Junction', '35 Clove Hill', '80004 CEDEX 1', 'Amiens', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('71 3rd Junction', '3232 Morning Road', '84309 CEDEX', 'Cavaillon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('664 Shasta Hill', '8107 Donald Avenue', '13155 CEDEX', 'Tarascon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('8 Golf Park', '9766 Dayton Trail', '31774 CEDEX', 'Colomiers', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('1166 Waubesa Point', '30379 Clarendon Avenue', '13369 CEDEX 11', 'Marseille', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('2286 Stone Corner Drive', '513 Center Place', '93335 CEDEX', 'Neuilly-sur-Marne', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('7 Dawn Drive', '787 Autumn Leaf Point', '97717 CEDEX 9', 'Saint-Denis', 'Reunion');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('16 La Follette Lane', '30 Carberry Hill', '21900 CEDEX 9', 'Dijon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('3302 Schlimgen Alley', '9 Elmside Junction', '14409 CEDEX', 'Bayeux', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('507 Hintze Point', '97810 South Place', '97204 CEDEX', 'Fort-de-France', 'Martinique');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('61406 Butterfield Crossing', '70325 Melody Avenue', '06173 CEDEX 2', 'Nice', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('84 Haas Street', '57 Monica Circle', '60406 CEDEX', 'Noyon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('955 Valley Edge Street', '934 Lien Point', '44966 CEDEX 9', 'Nantes', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('9248 Oneill Circle', '133 Graedel Plaza', '44474 CEDEX', 'Carquefou', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('45239 Elmside Junction', '788 Pine View Trail', '25117 CEDEX', 'Baume-les-Dames', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('1 Village Crossing', '5 Russell Trail', '78504 CEDEX', 'Sartrouville', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('1 Victoria Circle', '78 Vermont Center', '38354 CEDEX', 'La Tour-du-Pin', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('9866 Ridge Oak Hill', '291 Namekagon Hill', '95711 CEDEX 1', 'Roissy Charles-de-Gaulle', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('2429 Crownhardt Street', '65 Declaration Place', '75240 CEDEX 05', 'Paris 05', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('767 Cordelia Point', '83 Vera Road', '53009 CEDEX', 'Laval', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('2 Marquette Plaza', '0664 Amoth Drive', '69939 CEDEX 20', 'Lyon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('30 Homewood Terrace', '21 Duke Point', '38509 CEDEX', 'Voiron', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('113 Ohio Street', '30 Heath Terrace', '97204 CEDEX', 'Fort-de-France', 'Martinique');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('4 Meadow Valley Pass', '3 Stang Pass', '92174 CEDEX', 'Vanves', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('5 Fuller Way', '4247 Vera Circle', '69604 CEDEX', 'Villeurbanne', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('87296 Clyde Gallagher Park', '146 Springs Drive', '54529 CEDEX', 'Laxou', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('287 Eastwood Trail', '352 Messerschmidt Trail', '67953 CEDEX 9', 'Strasbourg', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('88258 Summit Center', '31036 Moose Place', '95154 CEDEX', 'Taverny', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('5 Dayton Way', '29 Pine View Parkway', '31403 CEDEX 9', 'Toulouse', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('10592 Park Meadow Circle', '77 Anhalt Park', '79304 CEDEX', 'Bressuire', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('70399 Vernon Pass', '29 Forest Dale Park', '57404 CEDEX', 'Sarrebourg', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('9874 Barby Junction', '5996 Merry Plaza', '25045 CEDEX', 'Besançon', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('239 Prentice Plaza', '0 Cody Way', '54204 CEDEX', 'Toul', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('25 Jackson Point', '171 Village Lane', '10104 CEDEX', 'Romilly-sur-Seine', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('1919 Jana Hill', '4 Moland Drive', '12030 CEDEX 9', 'Rodez', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('877 Grover Avenue', '8 Montana Place', '31004 CEDEX 6', 'Toulouse', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('392 Jay Park', '4145 Sunbrook Point', '94726 CEDEX', 'Fontenay-sous-Bois', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('530 Red Cloud Center', '91328 Michigan Park', '06905 CEDEX', 'Sophia Antipolis', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('95 Fair Oaks Crossing', '881 Logan Parkway', '67124 CEDEX', 'Molsheim', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('740 Stephen Place', '34250 Calypso Place', '75353 SP 07', 'Paris 07', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('284 Nevada Pass', '1268 Autumn Leaf Circle', '36104 CEDEX', 'Issoudun', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('057 Eggendart Way', '980 Eastwood Trail', '25215 CEDEX', 'Montbéliard', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('6695 Eastlawn Circle', '32900 Westerfield Circle', '78093 CEDEX 9', 'Saint-Quentin-en-Yvelines', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('61 Springs Pass', '40 Briar Crest Crossing', '92393 CEDEX', 'Villeneuve-la-Garenne', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('74 2nd Drive', '733 Hoard Center', '76152 CEDEX', 'Maromme', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('94 Drewry Road', '24380 Hauk Way', '75737 CEDEX 15', 'Paris 15', 'France');
-- insert into `addresses` (`number_road`, `road`, `zip_code`, `city`, `country`) values ('35 Stuart Plaza', '2 Derek Circle', '75171 CEDEX 19', 'Paris 19', 'France');
--
--
--
-- -- DATA pour : Members (phase 02)
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Urbanus', 'Febry', '2003-01-25', '2022-01-07', 'ufebry0@gmpg.org', 'Ot20yWoqMp4', '+86 (454) 768-7614', null, 56, 'member', '2022-09-14', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Edie', 'Kubin', '1959-11-12', '2021-06-24', 'ekubin1@arizona.edu', 'nGKyEWJa', '+86 (301) 142-1392', null, 91, 'member', '2021-04-07', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Maddy', 'Peoples', '1936-10-23', '2023-01-18', 'mpeoples2@yolasite.com', 'vCoMCPjl5y2', '+7 (731) 794-1324', null, 62, 'member', '2020-05-18', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Maison', 'Merrell', '1954-12-07', '2020-06-14', 'mmerrell3@jiathis.com', '7QIFDE', '+81 (372) 709-4510', null, 46, 'member', '2019-12-05', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Sayre', 'MacBain', '1980-10-04', '2021-05-18', 'smacbain4@blogger.com', 'unogeKMbn', '+62 (261) 889-8564', null, 87, 'member', '2021-12-23', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Dena', 'Halladey', '1972-05-27', '2021-01-24', 'dhalladey5@sourceforge.net', 'QWoJ3Ar', '+62 (166) 269-2288', null, 59, 'member', '2020-07-23', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Adele', 'Hearst', '2016-07-14', '2021-05-06', 'ahearst6@youtu.be', 't4GTpaMhScyN', '+86 (115) 982-8816', null, 69, 'member', '2020-02-03', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Blanca', 'Vernalls', '1949-05-18', '2020-10-10', 'bvernalls7@wikia.com', 'DaUGSzWqzQ', '+63 (630) 202-7408', null, 85, 'member', '2019-08-13', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Cleon', 'Laxen', '1947-04-03', '2021-05-04', 'claxen8@jugem.jp', 'hs6qA2zQCF', '+7 (954) 793-2146', null, 52, 'member', '2022-01-21', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Ingrim', 'Andreasson', '1943-07-21', '2023-03-22', 'iandreasson9@wisc.edu', 'CqJ9vo', '+381 (848) 531-7492', null, 83, 'member', '2021-11-22', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Sadye', 'Kerrey', '1971-05-22', '2020-11-20', 'skerreya@unicef.org', 'fkhFeMrG', '+86 (656) 962-9134', null, 76, 'member', '2021-12-30', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Lorrie', 'Gruczka', '1971-09-22', '2021-08-05', 'lgruczkab@sun.com', 'bR6eVw8HZ8h', '+380 (958) 511-1809', null, 61, 'member', '2020-04-10', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Wynn', 'Bevar', '1961-09-13', '2021-12-12', 'wbevarc@unc.edu', 'MvqPDXi9', '+51 (156) 925-6489', null, 89, 'member', '2022-10-03', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Heloise', 'Sawdon', '1986-10-20', '2020-07-18', 'hsawdond@biglobe.ne.jp', 'XOlWkMeVemgE', '+47 (326) 253-5780', null, 65, 'member', '2020-02-07', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Allina', 'Finlater', '2001-07-29', '2020-12-10', 'afinlatere@newyorker.com', 'r4Wk0DNut0V', '+264 (999) 519-2899', null, 49, 'member', '2021-12-27', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Floria', 'O''Grada', '1965-12-27', '2020-11-09', 'fogradaf@cbslocal.com', '5PN4ZeMm', '+63 (556) 456-3534', null, 70, 'member', '2021-09-19', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Florentia', 'Collin', '2014-04-03', '2022-08-17', 'fcolling@ucla.edu', 'MxFcCCjF0LeA', '+48 (488) 296-1718', null, 74, 'member', '2021-08-30', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Jaymie', 'Douris', '1970-11-28', '2022-02-22', 'jdourish@washington.edu', 'NaZwUsZU0', '+62 (711) 864-5513', null, 89, 'member', '2020-09-14', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Sarah', 'Seignior', '1986-09-07', '2022-09-11', 'sseigniori@disqus.com', 'D9Lhmwf52Vs', '+52 (176) 491-7413', null, 63, 'member', '2022-02-22', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Evangelina', 'Hurworth', '1986-06-13', '2022-08-29', 'ehurworthj@tripadvisor.com', 'm4l8nu0wvn7h', '+34 (330) 769-8886', null, 75, 'member', '2023-01-11', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Ameline', 'Camp', '1970-06-17', '2020-10-15', 'acampk@paginegialle.it', 'mD0FpgV', '+63 (262) 970-8392', null, 62, 'member', '2022-11-12', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Berny', 'Mathivon', '1988-06-15', '2021-08-31', 'bmathivonl@amazon.co.uk', 'kj5eBk4PFZC', '+86 (845) 206-2529', null, 90, 'member', '2021-06-03', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Tallie', 'Hawford', '1963-11-21', '2022-02-14', 'thawfordm@odnoklassniki.ru', 'oAcXD7qw5d', '+62 (590) 721-6582', null, 69, 'member', '2019-07-08', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Allin', 'Rockhill', '1958-12-13', '2021-05-09', 'arockhilln@w3.org', 'aC0yqlK', '+7 (495) 129-2398', null, 58, 'member', '2019-07-18', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Branden', 'Ceillier', '2005-06-26', '2020-10-12', 'bceilliero@examiner.com', '248QgGc1', '+27 (568) 745-7496', null, 57, 'member', '2020-03-05', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Nona', 'Pennazzi', '1992-07-25', '2021-09-03', 'npennazzip@joomla.org', 'oQiyxhmu4', '+86 (145) 862-8871', null, 70, 'member', '2020-08-26', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Burke', 'Sumshon', '1965-06-23', '2020-11-13', 'bsumshonq@nymag.com', 'BplbaG9X', '+86 (695) 788-4403', null, 53, 'member', '2020-01-06', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Aura', 'Speers', '1965-08-02', '2021-11-27', 'aspeersr@umich.edu', 'M09uf0dH', '+86 (965) 558-0452', null, 69, 'member', '2020-03-04', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Lars', 'McQuillin', '1975-10-17', '2022-12-01', 'lmcquillins@cdc.gov', '71qm9KVUj', '+93 (315) 108-9811', null, 47, 'member', '2022-06-26', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Min', 'Schustl', '1983-06-07', '2020-06-13', 'mschustlt@bing.com', 'p892n1', '+84 (558) 745-2238', null, 56, 'member', '2020-03-18', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Luella', 'Workman', '1952-11-07', '2020-07-18', 'lworkmanu@php.net', 'qeyBAcS', '+63 (982) 795-3543', null, 67, 'member', '2022-03-11', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Moises', 'Ovenden', '2007-04-29', '2023-03-21', 'movendenv@whitehouse.gov', 'DO2KXmly0v', '+60 (597) 466-2737', null, 81, 'member', '2020-05-04', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Rube', 'Kingzett', '1988-07-08', '2020-10-17', 'rkingzettw@nps.gov', '309CxJMkG', '+54 (902) 778-8453', null, 57, 'member', '2021-04-22', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Godiva', 'Songhurst', '1944-08-14', '2022-05-09', 'gsonghurstx@latimes.com', '8XaQety1', '+351 (770) 374-6291', null, 81, 'member', '2019-06-17', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Moyna', 'Halladay', '1966-06-23', '2020-11-14', 'mhalladayy@is.gd', '8mQJHz', '+30 (756) 611-7840', null, 77, 'member', '2020-01-19', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Michal', 'Schubart', '1960-02-07', '2020-08-13', 'mschubartz@ed.gov', 'sNT410bxCn4A', '+234 (328) 408-8329', null, 53, 'member', '2021-12-29', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Lelah', 'Meers', '1995-04-22', '2023-03-17', 'lmeers10@vistaprint.com', 'T1tr81', '+86 (620) 170-0305', null, 69, 'member', '2022-06-12', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Lorrie', 'Duffield', '1943-03-19', '2022-09-11', 'lduffield11@example.com', 'kkhuDf4cf', '+7 (604) 308-6518', null, 62, 'member', '2020-07-09', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Florentia', 'Tayler', '1967-01-27', '2022-12-01', 'ftayler12@engadget.com', 'RaCJU4n', '+261 (512) 776-8347', null, 47, 'member', '2020-02-19', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Meredith', 'Beattie', '1988-06-21', '2021-12-11', 'mbeattie13@nifty.com', '1xJPpPk6', '+33 (158) 999-5103', null, 91, 'member', '2019-07-02', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Edlin', 'Tschirschky', '1974-12-19', '2021-12-22', 'etschirschky14@comcast.net', 'iecP1ZljiJM', '+52 (340) 279-0726', null, 75, 'member', '2019-08-18', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Delphinia', 'Imore', '1968-04-15', '2021-02-23', 'dimore15@yahoo.com', 'pgP0x9CYolE', '+93 (506) 717-8519', null, 67, 'member', '2022-11-27', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Sallyann', 'Bearsmore', '1950-07-03', '2021-04-09', 'sbearsmore16@businessinsider.com', 'Hztry6BBmtdF', '+351 (937) 191-2276', null, 89, 'member', '2021-07-26', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Stanfield', 'Willcot', '1980-04-23', '2022-01-20', 'swillcot17@si.edu', 'iGtYTs1M', '+54 (340) 134-0400', null, 57, 'member', '2021-02-20', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Mona', 'Skase', '1959-04-16', '2022-06-28', 'mskase18@usa.gov', 'F22FOPZeGtMz', '+81 (105) 692-3233', null, 61, 'member', '2019-06-23', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Ashien', 'Brosoli', '2011-07-20', '2020-05-31', 'abrosoli19@delicious.com', '5I1tYi7y', '+256 (205) 292-9060', null, 84, 'member', '2019-09-20', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Helena', 'Deacon', '1970-09-26', '2022-02-09', 'hdeacon1a@chron.com', '74VwVsl', '+86 (283) 928-5928', null, 62, 'member', '2020-10-31', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Hal', 'Attiwill', '1952-06-25', '2020-11-26', 'hattiwill1b@mediafire.com', '7TClAn5DVC', '+237 (826) 279-1277', null, 81, 'member', '2019-05-22', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Madelle', 'Knipe', '1995-10-05', '2020-06-21', 'mknipe1c@baidu.com', 'IbJAokq2s', '+30 (305) 255-9232', null, 54, 'member', '2022-08-05', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Harper', 'Marven', '1959-04-07', '2021-12-10', 'hmarven1d@toplist.cz', 'nxLzQ2F', '+62 (594) 249-0290', null, 63, 'member', '2022-01-28', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Gib', 'Scholler', '1946-09-24', '2021-12-17', 'gscholler1e@cafepress.com', 'GSkXE2OfCVj', '+7 (261) 648-2930', null, 93, 'member', '2022-12-25', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Pascale', 'Macon', '1954-05-24', '2020-10-18', 'pmacon1f@psu.edu', '6jjda7', '+227 (216) 502-7193', null, 76, 'member', '2020-04-23', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Phylys', 'Streeting', '2011-07-16', '2023-01-16', 'pstreeting1g@weather.com', 'Aj9jDP8yJE', '+81 (370) 776-7623', null, 58, 'member', '2020-09-24', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Willabella', 'Jelphs', '1964-02-16', '2022-09-19', 'wjelphs1h@mail.ru', '91huxxaB4A', '+86 (320) 124-1371', null, 82, 'member', '2021-10-02', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Hilary', 'Kment', '1942-07-30', '2021-07-12', 'hkment1i@cdbaby.com', 'wlts8U1', '+34 (144) 467-9762', null, 91, 'member', '2021-07-11', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Magda', 'Chartres', '1942-07-31', '2022-09-23', 'mchartres1j@yandex.ru', '9iwgAcgeu0', '+86 (113) 450-7116', null, 68, 'member', '2021-02-12', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Johnette', 'Childrens', '1973-04-20', '2022-05-20', 'jchildrens1k@marriott.com', 'QOLT61c4ow', '+62 (642) 593-4602', null, 82, 'member', '2019-12-12', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Rupert', 'Bush', '2002-03-12', '2023-03-22', 'rbush1l@jigsy.com', 'ZSuz8ERo', '+62 (685) 914-3067', null, 59, 'member', '2020-09-19', 50, true, false);
-- insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`, `date_of_membership`, `registration_fee`, `up_to_date`, `customer_becoming_member`) values ('Fiona', 'Cockitt', '1957-09-30', '2022-12-17', 'fcockitt1m@cafepress.com', 'gYXpUv', '+7 (898) 598-7146', null, 52, 'member', '2022-08-04', 50, true, false);


-- CUSTOMMER password: eR3#£_\éé
  insert into `customers` (`name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values ('Audrey', 'cops', '1957-09-30', '2022-12-17', 'audrey@cop.com', '$2y$10$oUFvvM4MLkVKgZgWKdAOnuvqjbOGZVcCxD6KV7DdcXZdysoCvLlYW', '+7 (898) 598-7146', null, 1, 'Customer');
--
-- insert into `customers` (`id`, `name`, `surname`, `birthdate`, `subscription_date`, `username`, `password`, `phone_number`, `account_closing_date`, `address_id`, `dtype`) values (41, 'Selig', 'Kilday', '1957-09-29', '2022-02-02', 'skilday13@squidoo.com', 'eyQHlVYUI', '+420 (172) 949-5015', null, 7, 'Customer');
-
--
--
--
-- --- demande de prestation
--
-- insert into `request_perform` ( `date_creation_request`, `date_perform_requested`, `start_time`, `end_time`, `description_request`, `status_request_perform_id`, `event_id`, `customer_id`) values ( '2023-03-09', '2023-07-12', '8:30:00', '13:30:00', "aller hop c'est pour faire un test.", 1, 1, 1);
-- insert into `request_perform` ( `date_creation_request`, `date_perform_requested`, `start_time`, `end_time`, `description_request`, `status_request_perform_id`, `event_id`, `customer_id`) values ( '2022-11-09', '2023-08-23', '8:30:00', '13:30:00', 'la surprise pour le futur marié.', 1, 2, 26);
-- insert into `request_perform` ( `date_creation_request`, `date_perform_requested`, `start_time`, `end_time`, `description_request`, `status_request_perform_id`, `event_id`, `customer_id`) values ( '2022-12-20', '2023-12-24', '8:30:00', '13:30:00', "Pour la fete de fin d'année du comité d'entreprise.", 1, 5, 80);
-- insert into `request_perform` ( `date_creation_request`, `date_perform_requested`, `start_time`, `end_time`, `description_request`, `status_request_perform_id`, `event_id`, `customer_id`) values ( '2022-11-09', '2023-12-24', '8:30:00', '13:30:00', 'Maecenas tincidunt lacus at velit.', 1, 1, 14);


--- gestion des rôles
-- insert into `role` ( `name`) VALUES ("Super Administrateur");
insert into `role` ( `name`) VALUES ("ROLE_SUPER_ADMIN");
-- insert into `role` ( `name`) VALUES ("Administrateur");
insert into `role` ( `name`) VALUES ("ROLE_ADMIN");
-- insert into `role` ( `name`) VALUES ("Membre");
insert into `role` ( `name`) VALUES ("ROLE_STAFF");
-- insert into `role` ( `name`) VALUES ("Client");
insert into `role` ( `name`) VALUES ("ROLE_USER");
-- insert into `role` ( `name`) VALUES ("Visiteur");
insert into `role` ( `name`) VALUES ("ROLE_GUEST");
-- insert into `role` ( `name`) VALUES ("Coordinateur d''événements");
-- insert into `role` ( `name`) VALUES ("Coordinateur d''événements");
-- insert into `role` ( `name`) VALUES ("Gestionnaire des ressources");
-- insert into `role` ( `name`) VALUES ("Gestionnaire des ressources");
-- insert into `role` ( `name`) VALUES ("Trésorier");
-- insert into `role` ( `name`) VALUES ("Responsable des bénévoles");
-- insert into `role` ( `name`) VALUES ("Responsable de la communication");



