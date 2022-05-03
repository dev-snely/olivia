use instage;
INSERT INTO `instage`.`compte`
(`IdCompte`,
`Courriel`,
`Password`,
`TypeCompte`)
VALUES
(1,
"Admin@gmail.com",
"admin",
"admin");

INSERT INTO `instage`.`compte`
(`IdCompte`,
`Courriel`,
`Password`,
`TypeCompte`)
VALUES
(2,
"Prof@gmail.com",
"prof",
"professeur");

INSERT INTO `instage`.`compte`
(`IdCompte`,
`Courriel`,
`Password`,
`TypeCompte`)
VALUES
(3,
"Entr@gmail.com",
"entr",
"entreprise");

INSERT INTO `instage`.`compte`
(`IdCompte`,
`Courriel`,
`Password`,
`TypeCompte`)
VALUES
(4,
"Etu@gmail.com",
"etu",
"etudiant");

INSERT INTO `instage`.`admin`
(`IdAdmin`,
`Nom`,
`Prenom`,
`Compte_IdCompte`)
VALUES
(1,
"Smith",
"Adam",
1);




INSERT INTO `instage`.`cv`
(`IdCV`,
`Resume`,
`ExperienceTravail`,
`Education`,
`Certification`,
`Competence`,
`Langue`)
VALUES
(1,
"Blabla resumé",
"Épicerie Métro",
"DEC Programmation",
"Cisco",
"Travaillant",
"Français, Anglais");

INSERT INTO `instage`.`entreprise`
(`IdEntreprise`,
`Description`,
`Nom`,
`PersonneReference`,
`Compte_IdCompte`)
VALUES
(1,
"entreprise Minéraux",
"Rio tinto",
"Jack Sparrow",
 3);


INSERT INTO `instage`.`lettremotivation`
(`IdLettreMotivation`,
`Contenu`,
`Titre`)
VALUES
(1,
"Contenu etc ...",
"Ma lettre");

INSERT INTO `instage`.`occupation`
(`IdOccupation`,
`DateDebut`,
`DateFinl`,
`Disponible`)
VALUES
(1,
'2022-01-01' ,
'2023-01-01' ,
0);
INSERT INTO `instage`.`etudiant`
(`IdEtudiant`,
`Nom`,
`Prenom`,
`NumeroDA`,
`LettreMotivation_IdLettreMotivation`,
`CV_IdCV`,
`Occupation_IdOccupation`,
`Compte_IdCompte`)
VALUES
(1,
"Bison",
"Carl",
12345,
1,
1,
1,
4);



INSERT INTO `instage`.`offre`
(`IdOffre`,
`Poste`,
`Description`,
`Remuneration`,
`Entreprise_IdEntreprise`)
VALUES
(1,
"Développeur Web",
"Back-end",
20.50,
1);

INSERT INTO `instage`.`postulation`
(`Signature`,
`Acceptation`,
`Offre_IdOffre`,
`Etudiant_IdEtudiant`)
VALUES
(0,
1,
1,
1);

INSERT INTO `instage`.`professeur`
(`IdProfesseur`,
`Nom`,
`Prenom`,
`NumeroDa`,
`Compte_IdCompte`)
VALUES
(1,
"Sacquet",
"Frodo",
4321,
2);

INSERT INTO `instage`.`publicite`
(`idPublicite`,
`Contenu`,
`ImgLink`,
`Entreprise_IdEntreprise`)
VALUES
(1,
"Contenu blabla bla",
"pub.png",
1);
