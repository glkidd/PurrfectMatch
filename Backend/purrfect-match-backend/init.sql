CREATE TABLE `breeds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `breed_name` varchar(100) NOT NULL,
  `species` enum('DOG','CAT','OTHER') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `breed_name_UNIQUE` (`breed_name`)
);

CREATE TABLE `shelter_accounts` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(256) NOT NULL,
  `password_hash` varchar(256) NOT NULL,
  `password_salt` varchar(256) NOT NULL,
  `shelter_name` varchar(256) NOT NULL,
  `street` varchar(256) NOT NULL,
  `city` varchar(256) NOT NULL,
  `state` enum('AK','AL','AR','AZ',
	       'CA','CO','CT','DE',
	       'FL','GA','HI','IA',
               'ID','IL','IN','KS',
               'KY','LA','MA','MD',
               'ME','MI','MN','MO',
               'MS','MT','NC','ND',
               'NE','NH','NJ','NM',
               'NV','NY','OH','OK',
               'OR','PA','RI','SC',
               'SD','TN','TX','UT',
               'VA','VT','WA','WI',
               'WV','WY') NOT NULL,
  `zip_code` int(11) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `website` varchar(256) NOT NULL,
  `auth_token` varchar(256) NOT NULL,
  `auth_timeout` bigint(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `recently_adopted` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `breed` int(11) NOT NULL,
  `date_adopted` datetime DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `breed` (`breed`),
  CONSTRAINT `recently_adopted_breed_fk` FOREIGN KEY (`breed`) REFERENCES `breeds` (`id`)
);

CREATE TABLE `success_stories` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `breed` int(11) NOT NULL,
  `date_adopted` datetime NOT NULL,
  `gender` enum('MALE','FEMALE','OTHER') NOT NULL,
  `message` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `breed` (`breed`),
  CONSTRAINT `success_stories_breed_fk` FOREIGN KEY (`breed`) REFERENCES `breeds` (`id`)
);

CREATE TABLE `dogs` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `breed` int(11) NOT NULL,
  `gender` enum('MALE','FEMALE','OTHER') NOT NULL,
  `fur_length` enum('NOHAIR','SHORT','MEDIUM','LONG') NOT NULL,
  `bio` varchar(1000) NOT NULL,
  `shelter_id` bigint(255) NOT NULL,
  `date_arrived` datetime NOT NULL,
  `euthanized_date` datetime DEFAULT NULL,
  `spayed/neutured` tinyint(1) NOT NULL,
  `size` enum('SMALL','MEDIUM','LARGE','XLARGE') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shelter_id` (`shelter_id`),
  KEY `breed` (`breed`),
  CONSTRAINT `dogs_shelter_id_fk` FOREIGN KEY (`shelter_id`) REFERENCES `shelter_accounts` (`id`),
  CONSTRAINT `dogs_breed_fk` FOREIGN KEY (`breed`) REFERENCES `breeds` (`id`)
);

CREATE TABLE `cats` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `breed` int(11) NOT NULL,
  `gender` enum('MALE','FEMALE','OTHER') NOT NULL,
  `fur_length` enum('NOHAIR','SHORT','MEDIUM','LONG') NOT NULL,
  `bio` varchar(1000) NOT NULL,
  `shelter_id` bigint(255) NOT NULL,
  `date_arrived` datetime NOT NULL,
  `euthanized_date` datetime DEFAULT NULL,
  `spayed/neutured` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shelter_id` (`shelter_id`),
  KEY `breed` (`breed`),
  CONSTRAINT `cats_shelter_id_fk` FOREIGN KEY (`shelter_id`) REFERENCES `shelter_accounts` (`id`),
  CONSTRAINT `cats_breed_fk` FOREIGN KEY (`breed`) REFERENCES `breeds` (`id`)
);

CREATE TABLE `other_animals` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `image` varchar(256) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `species` int(11) NOT NULL,
  `gender` enum('MALE','FEMALE','OTHER') NOT NULL,
  `bio` varchar(1000) NOT NULL,
  `shelter_id` bigint(255) NOT NULL,
  `date_arrived` datetime NOT NULL,
  `euthanized_date` datetime DEFAULT NULL,
  `spayed/neutured` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shelter_id` (`shelter_id`),
  KEY `species` (`species`),
  CONSTRAINT `other_animals_shelter_id_fk` FOREIGN KEY (`shelter_id`) REFERENCES `shelter_accounts` (`id`),
  CONSTRAINT `other_animals_species_fk` FOREIGN KEY (`species`) REFERENCES `breeds` (`id`)
); 
