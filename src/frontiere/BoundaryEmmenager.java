package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+nomVisiteur+"\n");
		int forceDruide=Clavier.entrerEntier("Quelle est votre force ?\n");
		int effetPotionMin=0;
		int effetPotionMax=0;
		int i=0;
		do {
			if(i==1) {
				System.out.println("Attention druide, vous vous �tes tromp� entre le maximum et le minimum.\n");
			}
			effetPotionMin=Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez");
			effetPotionMax=Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez");
			i=1;
		}while(effetPotionMax<effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois "+nomVisiteur+"\n");
		int force=Clavier.entrerEntier("Quelle est votre force ?\n");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
