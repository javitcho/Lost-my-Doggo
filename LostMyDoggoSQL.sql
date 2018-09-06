-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema LostMyDoggo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LostMyDoggo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LostMyDoggo` DEFAULT CHARACTER SET utf8 ;
USE `LostMyDoggo` ;

-- -----------------------------------------------------
-- Table `LostMyDoggo`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LostMyDoggo`.`Login` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(25) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LostMyDoggo`.`Doggos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LostMyDoggo`.`Doggos` (
  `ID_Doggos` INT NOT NULL AUTO_INCREMENT,
  `Doggo_Name` VARCHAR(45) NOT NULL,
  `Color` VARCHAR(20) NOT NULL,
  `Descripcion` VARCHAR(256) NULL,
  `Imagen` BLOB NULL,
  `Duenio_ID` INT NOT NULL,
  PRIMARY KEY (`ID_Doggos`, `Duenio_ID`),
  UNIQUE INDEX `ID_Doggos_UNIQUE` (`ID_Doggos` ASC) VISIBLE,
  INDEX `fk_Doggos_Login1_idx` (`Duenio_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Doggos_Login1`
    FOREIGN KEY (`Duenio_ID`)
    REFERENCES `LostMyDoggo`.`Login` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LostMyDoggo`.`Alert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LostMyDoggo`.`Alert` (
  `ID_Alert` INT NOT NULL AUTO_INCREMENT,
  `Doggo_name` VARCHAR(45) NOT NULL,
  `Range` INT NOT NULL,
  `Time_miss` INT NOT NULL,
  `Doggos_ID_Doggos` INT NOT NULL,
  PRIMARY KEY (`ID_Alert`, `Doggos_ID_Doggos`),
  UNIQUE INDEX `ID_Alert_UNIQUE` (`ID_Alert` ASC) VISIBLE,
  UNIQUE INDEX `Doggo_name_UNIQUE` (`Doggo_name` ASC) VISIBLE,
  INDEX `fk_Alert_Doggos_idx` (`Doggos_ID_Doggos` ASC) VISIBLE,
  CONSTRAINT `fk_Alert_Doggos`
    FOREIGN KEY (`Doggos_ID_Doggos`)
    REFERENCES `LostMyDoggo`.`Doggos` (`ID_Doggos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
