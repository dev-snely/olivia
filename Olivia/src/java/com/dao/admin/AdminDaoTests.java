/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.admin;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Compte;
import java.util.List;
import java.util.Scanner;

/**
 * @author gabri
 */
public class AdminDaoTests {

	public static void main(String[] args) {
		AdminDaoImpl dao = new AdminDaoImpl();

		List<Admin> listeAdmins = null;

		int choix;
		Scanner lectureClavier = new Scanner(System.in);
		do {
			afficherMenu();
			choix = lectureClavier.nextInt();
			switch (choix) {
				case 1:
					System.out.println("********Test méthode findAll()******");
					listeAdmins = dao.findAll();
					for (Admin admin : listeAdmins) {
						System.out.println(admin);
					}
					break;
				case 2:
					System.out.println("********Test méthode findById()******");
					System.out.println("Entrez l'ID de l'admin souhaité :");
					int indice = lectureClavier.nextInt();
					Admin admin = dao.findById(indice);
					if (admin != null) {
						System.out.println(admin);
					}
					break;
				case 3:
					System.out.println("********Test méthode create()******");

					//Création des 2 premiers params pour ADMIN
					System.out.println("Entrez le Nom  :");
					String nom = lectureClavier.next();
					System.out.println("Entrez le Prenom  :");
					String prenom = lectureClavier.next();

					// Création du compte de l'admin avec 3 valeurs que l'on connait.
					// Le futur Id incrémenté du compte est inconnu, mais trouvable
					// par le courriel préconfiguré ci-dessous
					System.out.println("Entrez le courriel  :");
					String courriel = lectureClavier.next();
					System.out.println("Entrez le mot de passe  :");
					String mdp = lectureClavier.next();
					System.out.println("Entrez le type de compte  :");
					String typeCompte = lectureClavier.next();

					// Objet compte va maintenant être inséré dans la BDD
					// avec les 3 params ci-dessus
					Compte compte2 = new Compte(courriel, mdp, typeCompte);
					CompteDaoImpl daoCompte = new CompteDaoImpl();
					boolean valeur = daoCompte.create(compte2);

					// Le compte est créé et inséré dans la base de données et on
					// accède à son id avec la méthode DAO findByCourriel, puisqu'on
					// connait son courriel qui est d'ailleurs unique.
					compte2 = daoCompte.findByCourriel(courriel);

					// Création de l'objet Admin qu''on insére dans la BDD
					Admin admin2 = new Admin();
					admin2.setNom(nom);
					admin2.setPrenom(prenom);
					admin2.setCompte(compte2);

					boolean retour = dao.create(admin2);
					if (retour) {
						listeAdmins = dao.findAll();
						System.out.println("*********Liste de admins nouvelle : *********");
						for (Admin unAdmin : listeAdmins) {
							System.out.println(unAdmin);
						}
					}

					break;
				case 4:
					System.out.println("********Test méthode delete()******");
					System.out.println("Entrez l'ID du Admin souhaité :");
					int indiceAdminADetruire = lectureClavier.nextInt();

					// Détruire l'admin, puis le compte en lien avec l'admin
					CompteDaoImpl daoCompte2 = new CompteDaoImpl();
					Admin adminADetruire = dao.findById(indiceAdminADetruire);
					int indiceCompteADetruire = adminADetruire.getCompte().getId();
					Compte unCompte = daoCompte2.findById(indiceCompteADetruire);

					retour = dao.delete(indiceAdminADetruire);
					daoCompte2.delete(unCompte.getId());

					if (retour) {
						System.out.println("*********Liste de Admins nouvelle : *********");
						List<Admin> listeAdmin = dao.findAll();
						for (Admin admi3 : listeAdmin) {
							System.out.println(admi3);
						}
					}
					break;
				case 5:
					System.out.println("********Test méthode update()******");

					System.out.println("Entrez l'ID de l'admin souhaité :");
					int indice1 = lectureClavier.nextInt();
					Admin unAdmin = dao.findById(indice1);

					System.out.println("Changer le Nom  :");
					String nom1 = lectureClavier.next();
					System.out.println("Changer le Prenom  :");
					String prenom1 = lectureClavier.next();

					unAdmin.setNom(nom1);
					unAdmin.setPrenom(prenom1);

					retour = dao.update(unAdmin);
					if (retour) {
						System.out.println("*********Liste de admin nouvelle : *********");
						listeAdmins = dao.findAll();
						for (Admin admin1 : listeAdmins) {
							System.out.println(admin1);
						}
					}

					break;

				case 6:
					System.out.println("********Test méthode findByNom()******");
					System.out.println("Entrez le Nom souhaité :");
					String nom12 = lectureClavier.next();
					List<Admin> desAdmin = dao.findByNom(nom12);
					if (desAdmin != null) {
						System.out.println(desAdmin);
					}
					break;
				case 7:
					System.out.println("*****Test methode findByPrenom********");
					System.out.println("Entrez le prenom souhaité :");
					String prenom12 = lectureClavier.next();
					List<Admin> desAdmin1 = dao.findByPrenom(prenom12);
					if (desAdmin1 != null) {
						System.out.println(desAdmin1);
					}
					break;
			}
		} while (choix != 8);

		System.out.println("Fermeture des tests.");
		System.exit(0);
	}

	private static void afficherMenu() {
		System.out.println("-------------Menu------------------ ");
		System.out.println("1. Afficher la liste des admins. ");
		System.out.println("2. Trouver un admin par son Id. ");
		System.out.println("3. Tester la création d'un admin. ");
		System.out.println("4. Tester la methode delete d'un admin.");
		System.out.println("5. Tester la methode update d'un admin.");
		System.out.println("6. Trouver un admin avec son nom.");
		System.out.println("7. Trouver un admin avec son prenom.");
		System.out.println("8. Quitter");
	}


}
