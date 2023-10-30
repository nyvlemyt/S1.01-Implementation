package Test;
import Main.*;
import ardoise.*;

public class TestChapeux {


	public static void main(String[] args) 
	{
		PointPlan p1 = new PointPlan(118,13);
		PointPlan p2 = new PointPlan(123,20);
		PointPlan p3 = new PointPlan(128,13);
		PointPlan p4 = new PointPlan(123,10);
		
		try 
		{
			Forme excep = new Chapeaux("oiseau2", p1, p2,1);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		Ardoise ardoise = new Ardoise(); 
		
		 
		try {
		Forme vide = new Chapeaux(); 
		Forme normal = new Chapeaux("oiseau", p1,p2,p3);
		
		Forme sens = new Chapeaux("oiseau2", p1,p3,1);
		Forme sens2 = new Chapeaux("oiseau3", p1,p3,0);
		
		Forme invSens = new Chapeaux("tect", p2,p4,1);
		Forme invSens2 = new Chapeaux("tect2", p2,p4,0);
		
		Forme copie1 = new Chapeaux(normal); 
		Forme copie2 = new Chapeaux("copie3",copie1); 

		
		System.out.println(copie1); 
		
		ardoise.ajouterForme(normal);
		ardoise.ajouterForme(sens);
		ardoise.ajouterForme(sens2);
		ardoise.ajouterForme(invSens);
		ardoise.ajouterForme(invSens2); 

		ardoise.dessinerGraphique();
		attendreSecondes(3000);
		sens.deplacer(-10, -10);
		ardoise.dessinerGraphique();

		}
		catch (Exception e)
		{
			System.out.println(e); 
		}
	}
	public static void attendreSecondes(int x) 
	{
        try 
        {
            Thread.sleep(x); 
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
	}
}
