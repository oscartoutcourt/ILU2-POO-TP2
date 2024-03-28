package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void init() {
		village = new Village("testvillage", 20, 5);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("pasvendeur"));
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlPrendreEtal controlPrendreEtal= new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		ControlEmmenager controlEmmenager= new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		controlLibererEtal.libererEtal("Bonemine");
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
	}

}
