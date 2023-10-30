package Test;

import Exception.PointPlanException;
import Exception.QuadrilateresException;
import Main.*;
import ardoise.*;

public class TestQuadrilateres {

	public static void main(String[] args) {
		
		PointPlan p1 = new PointPlan(80,140);
		PointPlan p2 = new PointPlan(180,198);
		
		//Test 
		
		Ardoise ardoise = new Ardoise();
				
		try {
			Forme vide = new Quadrilateres();
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Forme quadra = null;
		try {
			quadra = new Quadrilateres("quadra1", p1, p2);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Forme copie1 = null;
		try {
			copie1 = new Quadrilateres(quadra);
		} catch (QuadrilateresException | PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		try {
			copie1 = new Quadrilateres(p2);
		} catch (QuadrilateresException | PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Forme copie2 = null;
		try {
			copie2 = new Quadrilateres("copie2", copie1);
		} catch (QuadrilateresException | PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		try {
			copie2 = new Quadrilateres("copie2", p2);
		} catch (QuadrilateresException | PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(quadra); 
				
		ardoise.ajouterForme(quadra);
		ardoise.ajouterForme(copie1);
		ardoise.ajouterForme(copie2);
		
		ardoise.dessinerGraphique();
		attendreSecondes(3000);
		quadra.deplacer(-10, -10);
		ardoise.dessinerGraphique();

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
