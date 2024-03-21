package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentiteClient(nomAcheteur)) {
			System.out.println("Il faut �tre un habitant du village pour vouloir acheter des produits.");
		}else {
			System.out.println("Quelle produit voulez-vous acheter");
			String produit = scan.nextLine();
			Gaulois[] vendeurs= controlAcheterProduit.vendeursProduit(produit);
			if(vendeurs==null) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}else {
				System.out.println("Chez quel commer�ant voulez-vous acheter des "+produit+" ?");
				for(int i=0; i<vendeurs.length;i++) {
					System.out.println((i+1)+" - "+vendeurs[i].getNom());
				}
				int indexVendeur= scan.nextInt();
				System.out.println(nomAcheteur+" se d�place jusqu'� l'�tal du vendeur "+vendeurs[indexVendeur-1].getNom()+
						"\nBonjour "+nomAcheteur+"\nCombien de "+produit+" voulez-vous acheter?");
				int achete = scan.nextInt();
				int quantiteAchete=controlAcheterProduit.acheterProduit(vendeurs[indexVendeur-1].getNom(), achete);
				if(quantiteAchete==0) {
					System.out.println(nomAcheteur+" veut acheter "+achete+" "+produit+", malheureusement il n'y en a plus !");
				}else if(quantiteAchete==achete) {
					System.out.println(nomAcheteur+" ach�te "+quantiteAchete+" "+produit+" � "+ vendeurs[indexVendeur-1].getNom());
				}else {
					System.out.println(nomAcheteur+" veut acheter"+achete+" "+produit+" malheureusement "+vendeurs[indexVendeur].getNom()
							+" n'en a plus que "+quantiteAchete+". "+nomAcheteur+" ach�te tout le stock de "+vendeurs[indexVendeur].getNom());
				}
			}
		}
	}
}
