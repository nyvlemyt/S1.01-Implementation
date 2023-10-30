package Test;
import Exception.ChapeauxException;
import Exception.PointPlanException;
import Main.*;
import ardoise.*;


public class TestEtoile {

	public static void main(String[] args) 
	{
		//branche 1
		PointPlan p25 = new PointPlan(170,52);
		PointPlan p26 = new PointPlan(173,45);
		PointPlan p27 = new PointPlan(177,52);
		Forme branche1 = null;
		try {
			branche1 = new Chapeaux("branche 1", p25, p26, p27);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//branche 2
		PointPlan p28 = new PointPlan(177,52);
		PointPlan p29 = new PointPlan(184,57);
		PointPlan p30 = new PointPlan(177,60);
		Forme branche2 = null;
		try {
			branche2 = new Chapeaux("branche 2", p28, p29, p30);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//branche 3
		PointPlan p31 = new PointPlan(170,60);
		PointPlan p32 = new PointPlan(174,66);
		PointPlan p33 = new PointPlan(177,60);
		Forme branche3 = null;
		try {
			branche3 = new Chapeaux("branche 3", p31, p32, p33);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//branche 4
		PointPlan p34 = new PointPlan(170,60);
		PointPlan p35 = new PointPlan(164,57);
		PointPlan p36 = new PointPlan(170,52);
		Forme branche4 = null;
		try {
			branche4 = new Chapeaux("branche 4", p34, p35, p36);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PointPlan p3 = new PointPlan(55,45);
		PointPlan p4 = new PointPlan(30,40);
		
		 //Test 
		
		Ardoise ardoise = new Ardoise();
		
		try {
			Etoile vide = new Etoile();
		} catch (PointPlanException | ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Etoile aaa = null;
		try {
			aaa = new Etoile("normal", branche1 ,branche2 ,branche3 ,branche4);
		} catch (ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Forme copie1 = null;
		try {
			copie1 = new Etoile(aaa);
		} catch (ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			Forme copie2 = new Etoile ("copie2", copie1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} 
		
		PointPlan p10 = new PointPlan(118,13);
		PointPlan p20 = new PointPlan(123,20);
		try {
			Forme copie2 = new Etoile ("copie2", p20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Forme copie3 = new Etoile ("copie3", branche1 ,branche2 ,branche3 ,new Chapeaux("oiseau2", p10, p20,1));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		Forme quad = null;
		try {
			quad = new Quadrilateres("quad", p3, p4);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Etoile deQuad = null; 
		try 
		{
			deQuad = new Etoile("a partir de quad", quad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println(deQuad); 
		
		ardoise.ajouterForme(aaa);	
		ardoise.ajouterForme(deQuad);
		
		ardoise.dessinerGraphique();
		attendreSecondes(3000); 
		deQuad.deplacer(10, 10);
		ardoise.dessinerGraphique();
	}
	
	public static void attendreSecondes(int x) {
        try {
            Thread.sleep(x); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
