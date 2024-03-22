package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		}else {
			String[] donnees=controlLibererEtal.libererEtal(nomVendeur);
			if(donnees[0].equals("true")) {
				System.out.println("Vous avez vendu "+donnees[4]+" sur "+donnees[3]+" "+donnees[2]+".");
				System.out.println("En revoir "+donnees[1]+", passez une bonne journ�e.\n");
			}
		}
		
	}

}
