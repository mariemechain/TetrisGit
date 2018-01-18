package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configSpring.AppConfig;
import dao.DaoTetrimino;
import model_tetrimino.Tetrimino;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);	
		Tetrimino tetrimino1 = new Tetrimino();
		DaoTetrimino dao = myContext.getBean(DaoTetrimino.class);
		
		try {
			tetrimino1.setNom("N");
			tetrimino1.setCouleur("gris");
			dao.ajoutPiece(tetrimino1);
			//dao.insertTetrimino(123, "N", "rouge");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
