package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configSpring.AppConfig;
import dao.ITetriminoDAO;
import dao.Tetrimino;

public class Test {

	public static void main(String[] args) {

		testSpringHibernate();
		
	}

	
	static void old() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);	
		Tetrimino tetrimino1 = new Tetrimino();
		//DaoTetrimino dao = myContext.getBean(DaoTetrimino.class);
		
		try {
			tetrimino1.setNom("N");
			tetrimino1.setCouleur("gris");
			//dao.add(tetrimino1);
			//dao.insertTetrimino(123, "N", "rouge");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

		static void testSpringHibernate() {
			AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
			
			ITetriminoDAO daoTetrimino = myContext.getBean(ITetriminoDAO.class);
			Tetrimino myTetrimino = new Tetrimino();
			myTetrimino.setCouleur("rouge");
			myTetrimino.setNom("N");
			daoTetrimino.save(myTetrimino);
			System.out.println(myTetrimino);
			myContext.close();
		
		}
	
}
