package com.dao.compte;

import com.model.entities.Compte;
import java.util.List;

public class CompteDaoTests2 {

	public static void main(String[] args) {
		CompteDaoImpl dao = new CompteDaoImpl();
		List<Compte> lesComptes = null;
		Compte compte = null;
		lesComptes = dao.findAll();
		System.out.println("-------------------------- findAll --------------------------");
		for (Compte uneCompte : lesComptes) {
			System.out.println(uneCompte);

		}
		System.out.println("-------------------------- findById --------------------------");
		compte = dao.findById(1);
		System.out.println(compte);

		System.out.println("-------------------------- Create --------------------------");

		Compte leCompte = new Compte("test@gmail.com", "root", "etu");
		dao.create(leCompte);
		//Affichage de toutes les offres maintenant que c ajouté
		lesComptes = dao.findAll();
		for (Compte compte1 : lesComptes) {
			System.out.println(compte1);

		}
		System.out.println("-------------------------- Delete --------------------------");

		dao.delete(5);
		//Affichage de toutes les offres maintenant que c ajouté
		lesComptes = dao.findAll();
		for (Compte compte1 : lesComptes) {
			System.out.println(compte1);

		}
		System.out.println("-------------------------- Delete --------------------------");

		Compte unCOmpte2 = dao.findById(1);
		unCOmpte2.setCourriel("admin@hotmail.com");

		dao.update(unCOmpte2);
		//Affichage de toutes les offres maintenant que c ajouté
		lesComptes = dao.findAll();
		for (Compte compte1 : lesComptes) {
			System.out.println(compte1);

		}
		System.out.println("-------------------------- FindByEmail --------------------------");

		unCOmpte2 = dao.findByCourriel("Etu@gmail.com");

		System.out.println(unCOmpte2);
		System.out.println("-------------------------- FindByPassword --------------------------");

		lesComptes = dao.findByPassword("entr");

		for (Compte compte1 : lesComptes) {
			System.out.println(compte1);

		}
		System.out.println("-------------------------- FindByType --------------------------");

		lesComptes = dao.findByTypeCompte("etu");

		for (Compte compte1 : lesComptes) {
			System.out.println(compte1);

		}
		System.out.println("-------------------------- isExiste --------------------------");

		unCOmpte2 = dao.isExiste("Entr@gmail.com","entr");


		System.out.println(unCOmpte2);


	}
}
