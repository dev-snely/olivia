-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema InStage
-- -----------------------------------------------------
-- BD pour l'application InStage
DROP SCHEMA IF EXISTS `InStage` ;

-- -----------------------------------------------------
-- Schema InStage
--
-- BD pour l'application InStage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `InStage` ;
USE `InStage` ;

-- -----------------------------------------------------
-- Table `InStage`.`Compte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Compte` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Compte` (
  `IdCompte` INT NOT NULL AUTO_INCREMENT COMMENT 'Table des Comptes',
  `Courriel` VARCHAR(319) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `TypeCompte` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdCompte`),
  UNIQUE INDEX `courriel_UNIQUE` (`Courriel` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`CV`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`CV` ;

CREATE TABLE IF NOT EXISTS `InStage`.`CV` (
  `IdCV` INT NOT NULL AUTO_INCREMENT,
  `Resume` TEXT NULL,
  `ExperienceTravail` TEXT NULL,
  `Education` TEXT NULL,
  `Certification` TEXT NULL,
  `Competence` TEXT NULL,
  `Langue` VARCHAR(45) NULL,
  PRIMARY KEY (`IdCV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`LettreMotivation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`LettreMotivation` ;

CREATE TABLE IF NOT EXISTS `InStage`.`LettreMotivation` (
  `IdLettreMotivation` INT NOT NULL,
  `Contenu` TEXT NOT NULL,
  `Titre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdLettreMotivation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Entreprise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Entreprise` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Entreprise` (
  `IdEntreprise` INT NOT NULL AUTO_INCREMENT,
  `Description` TEXT NULL,
  `PersonneReference` VARCHAR(45) NULL,
  `Compte_IdCompte` INT NOT NULL,
  PRIMARY KEY (`IdEntreprise`, `Compte_IdCompte`),
  UNIQUE INDEX `IdEntreprise_UNIQUE` (`IdEntreprise` ASC) VISIBLE,
  INDEX `fk_Entreprise_Compte1_idx` (`Compte_IdCompte` ASC) VISIBLE,
  CONSTRAINT `fk_Entreprise_Compte1`
    FOREIGN KEY (`Compte_IdCompte`)
    REFERENCES `InStage`.`Compte` (`IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Offre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Offre` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Offre` (
  `IdOffre` INT NOT NULL AUTO_INCREMENT,
  `Poste` VARCHAR(45) NOT NULL,
  `Description` TEXT NOT NULL,
  `Remuneration` FLOAT NOT NULL,
  `Entreprise_IdEntreprise` INT NOT NULL,
  `Entreprise_Compte_IdCompte` INT NOT NULL,
  PRIMARY KEY (`IdOffre`, `Entreprise_IdEntreprise`, `Entreprise_Compte_IdCompte`),
  UNIQUE INDEX `IdOffre_UNIQUE` (`IdOffre` ASC) VISIBLE,
  INDEX `fk_Offre_Entreprise1_idx` (`Entreprise_IdEntreprise` ASC, `Entreprise_Compte_IdCompte` ASC) VISIBLE,
  CONSTRAINT `fk_Offre_Entreprise1`
    FOREIGN KEY (`Entreprise_IdEntreprise` , `Entreprise_Compte_IdCompte`)
    REFERENCES `InStage`.`Entreprise` (`IdEntreprise` , `Compte_IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Occupation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Occupation` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Occupation` (
  `IdOccupation` INT NOT NULL AUTO_INCREMENT,
  `DateDebut` DATE NULL,
  `DateFinl` DATE NULL,
  `Disponible` TINYINT(1) NOT NULL,
  `Offre_IdOffre` INT NOT NULL,
  PRIMARY KEY (`IdOccupation`, `Offre_IdOffre`),
  UNIQUE INDEX `IdOccupation_UNIQUE` (`IdOccupation` ASC) VISIBLE,
  INDEX `fk_Occupation_Offre1_idx` (`Offre_IdOffre` ASC) VISIBLE,
  CONSTRAINT `fk_Occupation_Offre1`
    FOREIGN KEY (`Offre_IdOffre`)
    REFERENCES `InStage`.`Offre` (`IdOffre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Etudiant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Etudiant` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Etudiant` (
  `IdEtudiant` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Prenom` VARCHAR(45) NOT NULL,
  `NumeroDA` INT(7) NOT NULL,
  `Compte_IdCompte` INT NOT NULL,
  `CV_IdCV` INT NOT NULL,
  `LettreMotivation_IdLettreMotivation` INT NOT NULL,
  `Postulation_Offre_IdOffre` INT NOT NULL,
  `Postulation_Offre_Entreprise_IdEntreprise` INT NOT NULL,
  `Postulation_Offre_Entreprise_Compte_IdCompte` INT NOT NULL,
  `Postulation_Etudiant_Occupation_IdOccupation` INT NOT NULL,
  `Occupation_IdOccupation` INT NOT NULL,
  `Occupation_Offre_IdOffre` INT NOT NULL,
  PRIMARY KEY (`IdEtudiant`, `Compte_IdCompte`, `CV_IdCV`, `LettreMotivation_IdLettreMotivation`, `Postulation_Offre_IdOffre`, `Postulation_Offre_Entreprise_IdEntreprise`, `Postulation_Offre_Entreprise_Compte_IdCompte`, `Postulation_Etudiant_Occupation_IdOccupation`, `Occupation_IdOccupation`, `Occupation_Offre_IdOffre`),
  UNIQUE INDEX `Id_UNIQUE` (`IdEtudiant` ASC) VISIBLE,
  UNIQUE INDEX `NumeroDA_UNIQUE` (`NumeroDA` ASC) VISIBLE,
  INDEX `fk_Etudiant_Compte1_idx` (`Compte_IdCompte` ASC) VISIBLE,
  INDEX `fk_Etudiant_CV1_idx` (`CV_IdCV` ASC) VISIBLE,
  INDEX `fk_Etudiant_LettreMotivation1_idx` (`LettreMotivation_IdLettreMotivation` ASC) VISIBLE,
  INDEX `fk_Etudiant_Occupation1_idx` (`Occupation_IdOccupation` ASC, `Occupation_Offre_IdOffre` ASC) VISIBLE,
  CONSTRAINT `fk_Etudiant_Compte1`
    FOREIGN KEY (`Compte_IdCompte`)
    REFERENCES `InStage`.`Compte` (`IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiant_CV1`
    FOREIGN KEY (`CV_IdCV`)
    REFERENCES `InStage`.`CV` (`IdCV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiant_LettreMotivation1`
    FOREIGN KEY (`LettreMotivation_IdLettreMotivation`)
    REFERENCES `InStage`.`LettreMotivation` (`IdLettreMotivation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiant_Occupation1`
    FOREIGN KEY (`Occupation_IdOccupation` , `Occupation_Offre_IdOffre`)
    REFERENCES `InStage`.`Occupation` (`IdOccupation` , `Offre_IdOffre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Professeur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Professeur` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Professeur` (
  `IdProfesseur` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Prenom` VARCHAR(45) NOT NULL,
  `NumeroDa` INT(7) NOT NULL,
  `Compte_IdCompte` INT NOT NULL,
  `Entreprise_IdEntreprise` INT NOT NULL,
  `Entreprise_Compte_IdCompte` INT NOT NULL,
  PRIMARY KEY (`IdProfesseur`, `Compte_IdCompte`, `Entreprise_IdEntreprise`, `Entreprise_Compte_IdCompte`),
  INDEX `fk_Professeur_Compte1_idx` (`Compte_IdCompte` ASC) VISIBLE,
  INDEX `fk_Professeur_Entreprise1_idx` (`Entreprise_IdEntreprise` ASC, `Entreprise_Compte_IdCompte` ASC) VISIBLE,
  CONSTRAINT `fk_Professeur_Compte1`
    FOREIGN KEY (`Compte_IdCompte`)
    REFERENCES `InStage`.`Compte` (`IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professeur_Entreprise1`
    FOREIGN KEY (`Entreprise_IdEntreprise` , `Entreprise_Compte_IdCompte`)
    REFERENCES `InStage`.`Entreprise` (`IdEntreprise` , `Compte_IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Admin` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Admin` (
  `IdAdmin` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NOT NULL,
  `Prenom` VARCHAR(45) NOT NULL,
  `Compte_IdCompte` INT NOT NULL,
  PRIMARY KEY (`IdAdmin`, `Compte_IdCompte`),
  UNIQUE INDEX `IdAdmin_UNIQUE` (`IdAdmin` ASC) VISIBLE,
  INDEX `fk_Admin_Compte1_idx` (`Compte_IdCompte` ASC) VISIBLE,
  CONSTRAINT `fk_Admin_Compte1`
    FOREIGN KEY (`Compte_IdCompte`)
    REFERENCES `InStage`.`Compte` (`IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Publicite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Publicite` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Publicite` (
  `idPublicite` INT NOT NULL AUTO_INCREMENT,
  `Contenu` TEXT NOT NULL,
  `ImgLink` VARCHAR(45) NOT NULL,
  `Entreprise_IdEntreprise` INT NOT NULL,
  `Entreprise_Compte_IdCompte` INT NOT NULL,
  PRIMARY KEY (`idPublicite`, `Entreprise_IdEntreprise`, `Entreprise_Compte_IdCompte`),
  UNIQUE INDEX `idPublicite_UNIQUE` (`idPublicite` ASC) VISIBLE,
  INDEX `fk_Publicite_Entreprise1_idx` (`Entreprise_IdEntreprise` ASC, `Entreprise_Compte_IdCompte` ASC) VISIBLE,
  CONSTRAINT `fk_Publicite_Entreprise1`
    FOREIGN KEY (`Entreprise_IdEntreprise` , `Entreprise_Compte_IdCompte`)
    REFERENCES `InStage`.`Entreprise` (`IdEntreprise` , `Compte_IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InStage`.`Postulation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InStage`.`Postulation` ;

CREATE TABLE IF NOT EXISTS `InStage`.`Postulation` (
  `Etudiant_IdEtudiant` INT NOT NULL,
  `Etudiant_Compte_IdCompte` INT NOT NULL,
  `Etudiant_CV_IdCV` INT NOT NULL,
  `Etudiant_LettreMotivation_IdLettreMotivation` INT NOT NULL,
  `Etudiant_Postulation_Offre_IdOffre` INT NOT NULL,
  `Etudiant_Postulation_Offre_Entreprise_IdEntreprise` INT NOT NULL,
  `Etudiant_Postulation_Offre_Entreprise_Compte_IdCompte` INT NOT NULL,
  `Etudiant_Postulation_Etudiant_Occupation_IdOccupation` INT NOT NULL,
  `Etudiant_Occupation_IdOccupation` INT NOT NULL,
  `Etudiant_Occupation_Offre_IdOffre` INT NOT NULL,
  `Offre_IdOffre` INT NOT NULL,
  `Offre_Entreprise_IdEntreprise` INT NOT NULL,
  `Offre_Entreprise_Compte_IdCompte` INT NOT NULL,
  `Signature` TINYINT(1) NOT NULL,
  `Acceptation` TINYINT(1) NOT NULL,
  PRIMARY KEY (`Etudiant_IdEtudiant`, `Etudiant_Compte_IdCompte`, `Etudiant_CV_IdCV`, `Etudiant_LettreMotivation_IdLettreMotivation`, `Etudiant_Postulation_Offre_IdOffre`, `Etudiant_Postulation_Offre_Entreprise_IdEntreprise`, `Etudiant_Postulation_Offre_Entreprise_Compte_IdCompte`, `Etudiant_Postulation_Etudiant_Occupation_IdOccupation`, `Etudiant_Occupation_IdOccupation`, `Etudiant_Occupation_Offre_IdOffre`, `Offre_IdOffre`, `Offre_Entreprise_IdEntreprise`, `Offre_Entreprise_Compte_IdCompte`),
  INDEX `fk_Etudiant_has_Offre_Offre1_idx` (`Offre_IdOffre` ASC, `Offre_Entreprise_IdEntreprise` ASC, `Offre_Entreprise_Compte_IdCompte` ASC) VISIBLE,
  INDEX `fk_Etudiant_has_Offre_Etudiant1_idx` (`Etudiant_IdEtudiant` ASC, `Etudiant_Compte_IdCompte` ASC, `Etudiant_CV_IdCV` ASC, `Etudiant_LettreMotivation_IdLettreMotivation` ASC, `Etudiant_Postulation_Offre_IdOffre` ASC, `Etudiant_Postulation_Offre_Entreprise_IdEntreprise` ASC, `Etudiant_Postulation_Offre_Entreprise_Compte_IdCompte` ASC, `Etudiant_Postulation_Etudiant_Occupation_IdOccupation` ASC, `Etudiant_Occupation_IdOccupation` ASC, `Etudiant_Occupation_Offre_IdOffre` ASC) VISIBLE,
  CONSTRAINT `fk_Etudiant_has_Offre_Etudiant1`
    FOREIGN KEY (`Etudiant_IdEtudiant` , `Etudiant_Compte_IdCompte` , `Etudiant_CV_IdCV` , `Etudiant_LettreMotivation_IdLettreMotivation` , `Etudiant_Postulation_Offre_IdOffre` , `Etudiant_Postulation_Offre_Entreprise_IdEntreprise` , `Etudiant_Postulation_Offre_Entreprise_Compte_IdCompte` , `Etudiant_Postulation_Etudiant_Occupation_IdOccupation` , `Etudiant_Occupation_IdOccupation` , `Etudiant_Occupation_Offre_IdOffre`)
    REFERENCES `InStage`.`Etudiant` (`IdEtudiant` , `Compte_IdCompte` , `CV_IdCV` , `LettreMotivation_IdLettreMotivation` , `Postulation_Offre_IdOffre` , `Postulation_Offre_Entreprise_IdEntreprise` , `Postulation_Offre_Entreprise_Compte_IdCompte` , `Postulation_Etudiant_Occupation_IdOccupation` , `Occupation_IdOccupation` , `Occupation_Offre_IdOffre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiant_has_Offre_Offre1`
    FOREIGN KEY (`Offre_IdOffre` , `Offre_Entreprise_IdEntreprise` , `Offre_Entreprise_Compte_IdCompte`)
    REFERENCES `InStage`.`Offre` (`IdOffre` , `Entreprise_IdEntreprise` , `Entreprise_Compte_IdCompte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
