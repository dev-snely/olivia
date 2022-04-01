
use instage;
INSERT INTO `instage`.`compte`
(`Courriel`,
`Password`,
`TypeCompte`)
VALUES
("admin@gmail.com",
"admin",
"adm");

INSERT INTO `instage`.`compte`
(`Courriel`,
`Password`,
`TypeCompte`)
VALUES
("entreprise@gmail.com",
"123",
"ent");


INSERT INTO `instage`.`compte` 
(`Courriel`,
`Password`,
`TypeCompte`)
VALUES
("etudiant@gmail.com",
"123",
"etu");

INSERT INTO `instage`.`compte` 
(`Courriel`,
`Password`,
`TypeCompte`)
VALUES
("Professeur@gmail.com",
"123",
"pro");
INSERT INTO `instage`.`admin`
(`Nom`,
`Prenom`,
`Compte_IdCompte`)
VALUES
("Boisvert",
"Gabriel",
1);
INSERT INTO `instage`.`cv`
(`Resume`,
`ExperienceTravail`,
`Education`,
`Certification`,
`Competence`,
`Langue`)
VALUES
("un résumé blabla bla",
"aucune expérience",
"Finissant diplôme collégial en programmation",
"aucune",
"efficace",
"Français et Anglais"); 

INSERT INTO `instage`.`entreprise`
(`Description`,
`PersonneReference`,
`Compte_IdCompte`,
`Offre_IdOffre`,
`Publicite_idPublicite`)
VALUES
("je suis une entreprise",
"Pipin",
2,
1,
1);

INSERT INTO `instage`.`etudiant`
(`Nom`,
`Prenom`,
`NumeroDA`,
`Compte_IdCompte`,
`CV_IdCV`,
`LettreMotivation_IdLettreMotivation`
)
VALUES
("Smith",
"John",
1234567,
3,
1,
1);

INSERT INTO `instage`.`lettremotivation`
(`Contenu`,
`Titre`)
VALUES
("BLABLABLA Contenu ...",
"Blablabla titre ...");

INSERT INTO `instage`.`occupation`
(`DateDebut`,
`DateFinl`,
`Disponible`,
`Offre_IdOffre`)
VALUES
('2022-12-04',
'2023-02-04',
0,
1);

INSERT INTO `instage`.`offre`
(`Poste`,
`Description`,
`Remuneration`,
`Entreprise_IdEntreprise`,
`Entreprise_Compte_IdCompte`)
VALUES
("Stagiaire Programmeur",
"blablabla description",
20.50,
1);



INSERT INTO `instage`.`professeur`
(`Nom`,
`Prenom`,
`NumeroDa`,
`Compte_IdCompte`,
`Etudiant_IdEtudiant`)
VALUES
("Pattinson",
"Paul",
41343543,
4,
1);

INSERT INTO `instage`.`publicite`
(
`Contenu`,
`ImgLink`)
VALUES
("contenu ....",
"Pub.png");
