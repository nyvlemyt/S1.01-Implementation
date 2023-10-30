package Test;

import Exception.ChapeauxException;
import Exception.PointPlanException;
import Exception.QuadrilateresException;
import Main.*;
import ardoise.*;

public class TestMaison {

	public static void main(String[] args) {
		
		//Corps Maison
		PointPlan p4 = new PointPlan(180,198);
		PointPlan p3 = new PointPlan(80,140);
		Forme corps = null;
		try {
			corps = new Quadrilateres("Corps Maison", p3, p4);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Porte Maison 	
		PointPlan p5 = new PointPlan(120,170);
		PointPlan p6 = new PointPlan(140,198);
		Forme porte = null;
		try {
			porte = new Quadrilateres("Porte Maison", p5, p6);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Toit maison
		PointPlan p13 = new PointPlan(80,140);
		PointPlan p14 = new PointPlan(130,100);
		PointPlan p15 = new PointPlan(180,140);
		Forme toit = null;
		try {
			toit = new Chapeaux("Toit maison", p13, p14, p15);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PointPlan p30 = new PointPlan(80,108);
		PointPlan p40 = new PointPlan(105,140);
		Forme corps2 = null;
		try {
			corps2 = new Quadrilateres("Corps Maison", p30, p40);
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Ardoise ardoise = new Ardoise();
		
		try {
			Maison vide = new Maison();
		} catch (QuadrilateresException | ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Forme normal = null;
		try {
			normal = new Maison("normal", porte, corps, toit);
		} catch (QuadrilateresException | ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Forme copie1 = null;
		try {
			copie1 = new Maison(normal);
		} catch (QuadrilateresException | ChapeauxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PointPlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			Forme copie2 = new Maison("copie3",copie1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Forme copie4 = new Maison("copie4",corps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Forme mais = new Maison("h", corps2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(normal);
		
		ardoise.dessinerGraphique();
		ardoise.ajouterForme(normal);
		attendreSecondes(3000); 
		normal.deplacer(-15, -15);
		ardoise.test();

	}
	
	public static void attendreSecondes(int x) {
        try {
            Thread.sleep(x); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
