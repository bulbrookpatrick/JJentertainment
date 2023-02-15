/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Patrick
 * Created: 10-Feb-2023
 */

DROP SCHEMA IF EXISTS `jjentertainmentdb`;
-- -----------------------------------------------------
-- Schema jjentertainmentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jjentertainmentdb` DEFAULT CHARACTER SET latin1;
USE `jjentertainmentdb` ;

-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`CLIENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`CLIENT` (
  `client_username` VARCHAR(255) NOT NULL,
  `client_email` VARCHAR(255) NOT NULL,
  `client_password` VARCHAR(16) NOT NULL,
  `client_first_name` VARCHAR(45) NOT NULL,
  `client_last_name` VARCHAR(45) NOT NULL,
  `client_phone_number` VARCHAR(10) NOT NULL,
  `client_preferred_contact` TINYINT(0),
  PRIMARY KEY (`client_username`),
  UNIQUE (`client_email`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`MANAGER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`MANAGER` (
  `manager_username` VARCHAR(255) NOT NULL,
  `manager_email` VARCHAR(255) NOT NULL,
  `manager_password` VARCHAR(16) NOT NULL,
  `manager_first_name` VARCHAR(45) NOT NULL,
  `manager_last_name` VARCHAR(45) NOT NULL,
  `manager_phone_number` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`manager_username`),
  UNIQUE (`manager_email`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`PERFORMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`PERFORMER` (
  `performer_username` VARCHAR(255) NOT NULL,
  `performer_email` VARCHAR(255) NOT NULL,
  `performer_password` VARCHAR(16) NOT NULL,
  `performer_first_name` VARCHAR(45) NOT NULL,
  `performer_last_name` VARCHAR(45) NOT NULL,
  `performer_phone_number`  VARCHAR(10) NOT NULL,
  `MANAGER_manager_username` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`performer_username`),
  UNIQUE (`performer_email`),
  CONSTRAINT `fk_PERFORMER_MANAGER1`
    FOREIGN KEY (`MANAGER_manager_username`)
    REFERENCES `jjentertainmentdb`.`MANAGER` (`manager_username`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`CATEGORY` (
  `category_id` INT AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `category_description` VARCHAR(255) NOT NULL,
  `category_rate` DOUBLE NOT NULL,
  `min_number_of_participants` INT NOT NULL,
  `min_number_of_performers` INT NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE (`category_name`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`EVENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`EVENT` (
  `event_id` INT AUTO_INCREMENT,
  `event_start_date` DATE NOT NULL,
  `event_end_date` DATE NOT NULL,
  `event_location` VARCHAR(255) NOT NULL,
  `event_status` TINYINT(0) NOT NULL DEFAULT 0,
  `event_interest` DOUBLE NOT NULL,
  `event_reservation_cost` DOUBLE NOT NULL,
  `CLIENT_client_username` VARCHAR(255) NOT NULL,
  `event_price` DOUBLE NULL,
  PRIMARY KEY (`event_id`),
  CONSTRAINT `fk_EVENT_CLIENT1`
    FOREIGN KEY (`CLIENT_client_username`)
    REFERENCES `jjentertainmentdb`.`CLIENT` (`client_username`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`SERIVCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`SERVICE` (
  `service_id` INT AUTO_INCREMENT,
  `service_start_date` DATETIME NOT NULL,
  `service_end_date` DATETIME NOT NULL,
  `service_duration` INT NULL,
  `service_price` DOUBLE NULL,
  `number_of_participants` INT NOT NULL,
  `number_of_performers_to_be_assigned` INT,
  `CATEGORY_category_id` INT NOT NULL,
  `EVENT_event_id` INT NOT NULL,
  PRIMARY KEY (`service_id`),
  CONSTRAINT `fk_SERVICE_EVENT1`
    FOREIGN KEY (`EVENT_event_id`)
    REFERENCES `jjentertainmentdb`.`EVENT` (`event_id`),
  CONSTRAINT `fk_SERVICE_CATEGORY1`
    FOREIGN KEY (`CATEGORY_category_id`)
    REFERENCES `jjentertainmentdb`.`CATEGORY` (`category_id`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`SERVICE_ASSIGN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`SERVICE_ASSIGN` (
  `PERFORMER_performer_username` VARCHAR(255) NOT NULL,
  `SERVICE_service_id` INT NOT NULL,
  CONSTRAINT `fk_SERVICE_ASSIGN_PERFORMER1`
    FOREIGN KEY (`PERFORMER_performer_username`)
    REFERENCES `jjentertainmentdb`.`PERFORMER` (`performer_username`),
  CONSTRAINT `fk_SERVICE_ASSIGN_SERVICE1`
    FOREIGN KEY (`SERVICE_service_id`)
    REFERENCES `jjentertainmentdb`.`SERVICE` (`service_id`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`PERFORMER_SPECIALTY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`PERFORMER_SPECIALTY` (
  `CATEGORY_category_id` INT NOT NULL,
  `PERFORMER_performer_username` VARCHAR(255) NOT NULL,
  CONSTRAINT `fk_PERFORMER_SPECIALTY_CATEGORY1`
    FOREIGN KEY (`CATEGORY_category_id`)
    REFERENCES `jjentertainmentdb`.`CATEGORY` (`category_id`),
  CONSTRAINT `fk_PERFORMER_SPECIALTY_PERFORMER1`
    FOREIGN KEY (`PERFORMER_performer_username`)
    REFERENCES `jjentertainmentdb`.`PERFORMER` (`performer_username`));
