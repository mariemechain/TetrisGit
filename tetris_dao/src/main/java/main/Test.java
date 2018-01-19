package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import configSpring.AppConfig;
import model_tetrimino.Tetrimino;
import tetrimino.dao.DaoTetrimino;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Tetrimino tetrimino1 = new Tetrimino();
		DaoTetrimino dao = myContext.getBean(DaoTetrimino.class);
		
		try {
			tetrimino1.setNom("N");
			tetrimino1.setCouleur("gris");
			System.out.println(dao.save(tetrimino1));
			
			List<Tetrimino> list = dao.findAll();
			for(Tetrimino e : list) {
				System.out.println(e+"\n");
			}
			
			Tetrimino tetrimino2 =dao.findById(1);
			tetrimino2.setCouleur("jaube");
			dao.save(tetrimino2);
			
			list = dao.findAll();
			for(Tetrimino e : list) {
				System.out.println(e+"\n");
			}
			
						
			
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

}
