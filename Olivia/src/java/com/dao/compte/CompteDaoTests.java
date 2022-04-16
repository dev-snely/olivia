/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.compte;

import com.model.entities.Compte;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class CompteDaoTests {

    public static void main(String[] args) {
        CompteDaoImpl dao = new CompteDaoImpl();
        List<Compte> listeComptes = null;
        int choix = 0;
        Scanner lectureClavier = new Scanner(System.in);
        do {
            afficherMenu();
            choix = lectureClavier.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("********Test méthode findAll()******");
                    listeComptes = dao.findAll();
                    for (Compte compte : listeComptes) {
                        System.out.println(compte);
                    }
                    break;
                case 2:
                    System.out.println("********Test méthode findById()******");
                    System.out.println("Entrez l'ID du compte souhaité :");
                    int indice = lectureClavier.nextInt();
                    Compte compte1 = dao.findById(indice);
                    if (compte1 != null) {
                        System.out.println(compte1);
                    }
                    break;
                case 3:
                    System.out.println("********Test méthode create()******");
                    System.out.println("Entrez le courriel  :");
                    String courriel = lectureClavier.next();
                    System.out.println("Entrez le mot de passe  :");
                    String mdp = lectureClavier.next();
                    System.out.println("Entrez le type de compte  :");
                    String typeCompte = lectureClavier.next();

                    Compte compte2 = new Compte(courriel, mdp, typeCompte);

                    boolean retour = dao.create(compte2);
                    if (retour) {
                        listeComptes = dao.findAll();
                        System.out.println("*********Liste de compte nouvelle : *********");
                        for (Compte compte : listeComptes) {
                            System.out.println(compte);
                        }
                    }
                    break;
                case 4:
                    System.out.println("********Test méthode delete()******");
                    System.out.println("Entrez l'ID du compte souhaité :");
                    indice = lectureClavier.nextInt();
                    retour = dao.delete(indice);

                    if (retour) {
                        System.out.println("*********Liste de compte nouvelle : *********");
                        listeComptes = dao.findAll();
                        for (Compte compte : listeComptes) {
                            System.out.println(compte);
                        }
                    }
                    break;
                case 5:
                    System.out.println("********Test méthode update()******");

                    System.out.println("Entrez l'ID du compte souhaité :");
                    int indice1 = lectureClavier.nextInt();
                    Compte unAutreCompte = dao.findById(indice1);

                    System.out.println("Changer le courriel  :");
                    String courriel1 = lectureClavier.next();
                    System.out.println("Changer le mot de passe  :");
                    String mdp1 = lectureClavier.next();
                    System.out.println("Changer le type de compte  :");
                    String typeCompte1 = lectureClavier.next();

                    unAutreCompte.setCourriel(courriel1);
                    unAutreCompte.setPassword(mdp1);
                    unAutreCompte.setTypeCompte(typeCompte1);

                    retour = dao.update(unAutreCompte);
                    if (retour) {
                        System.out.println("*********Liste de compte nouvelle : *********");
                        listeComptes = dao.findAll();
                        for (Compte compte : listeComptes) {
                            System.out.println(compte);
                        }
                    }

                    break;

                case 6:
                    System.out.println("********Test méthode findByCourriel()******");
                    System.out.println("Entrez le courriel souhaité :");
                    String courrielDemande = lectureClavier.next();
                    Compte unCompte = dao.findByCourriel(courrielDemande);
                    if (unCompte != null) {
                        System.out.println(unCompte);
                    }
                    break;
                case 7:
                    System.out.println("*****Test methode findByPassword********");
                    System.out.println("Entrez le mot de passe souhaité :");
                    String mdp2 = lectureClavier.next();
                    List<Compte> comptes = dao.findByPassword(mdp2);
                    if (comptes != null) {
                        for (Compte compte : comptes) {
                            System.out.println(compte);
                        }
                    }
                    break;
                case 8:
                    System.out.println("*****Test methode findByTypeCompte********");
                    System.out.println("Entrez le type de compte souhaité :");
                    String typeCompte2 = lectureClavier.next();
                    List<Compte> comptes1 = dao.findByTypeCompte(typeCompte2);
                    if (comptes1 != null) {
                        comptes1.forEach((compte) -> {
                            System.out.println(compte);
                        });
                    }
                    break;
                case 9:
                    System.out.println("*****Test methode isExiste********");
                    System.out.println("Entrez le courriel souhaité ");
                      String email1 = lectureClavier.next();
                      System.out.println("Entrez le Password souhaité ");
                      String password1 = lectureClavier.next();
                      Compte compte= dao.isExiste(email1, password1);
                      if(compte!=null){
                           System.out.println("Bonjour : "+ compte.getCourriel()+", vous etes connecté ");
                       }else{
                          System.out.println("email ou mot de passe invalide");
                      }
                     break;
            }

        } while (choix
                != 10);
        
        System.out.println("Fermeture des tests.");
        System.exit(0);

    }

    private static void afficherMenu() {
        System.out.println("-------------Menu------------------ ");
        System.out.println("1. Afficher la liste des étudiants. ");
        System.out.println("2. Trouver un compte par son Id. ");
        System.out.println("3. Tester la création d'un compte. ");
        System.out.println("4. Tester la methode delete d'un compte.");
        System.out.println("5. Tester la methode update d'un compte.");
        System.out.println("6. Trouver un compte avec son courriel.");
        System.out.println("7. Tester la methode findByPassword.");
        System.out.println("8. Tester la methode findByTypeCompte.");
        System.out.println("9. Tester la methode isExiste.");
        System.out.println("10. Quitter");
    }
}
