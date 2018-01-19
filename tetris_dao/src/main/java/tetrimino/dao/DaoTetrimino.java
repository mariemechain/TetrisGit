package tetrimino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model_tetrimino.Tetrimino;

@Repository
public class DaoTetrimino implements IDaoGeneric <Tetrimino>{
	
	@Autowired
	private Connection conn;
	
	public Tetrimino findById(int id) {
		try {
			Tetrimino t = new Tetrimino();
			ResultSet rs = conn.createStatement().executeQuery("SELECT * from tetrimino WHERE idtetrimino = " + id);
			rs.next();
			t.setId(rs.getInt(1));
			t.setNom(rs.getString(2));
			t.setCouleur(rs.getString(3));
			return t;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Tetrimino> findAll() {
		try {
			List<Tetrimino> retour = new ArrayList<Tetrimino>();
			ResultSet rs = conn.createStatement().executeQuery("SELECT * from tetrimino");
			while(rs.next()) {
				Tetrimino t = new Tetrimino();
				t.setId(rs.getInt(1));
				t.setNom(rs.getString(2));
				t.setCouleur(rs.getString(3));
				retour.add(t);
			}
			return retour;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public boolean save(Tetrimino t) {		
		
		try {
			PreparedStatement ps;
			int id = t.getId();
			
			if(id == 0) {
				ps = conn.prepareStatement("insert into tetrimino(nom,couleur) values (?,?)");
				ps.setString(1, t.getNom());
				ps.setString(2, t.getCouleur());
				ps.executeUpdate();
				return true;
			}
			else {
				ps = conn.prepareStatement("replace(nom,'%',?), replace(couleur,'%',?) where idtetrimino = ? from tetrimino");
				ps.setString(1, t.getNom());
				ps.setString(2, t.getCouleur());
				ps.setInt(3, t.getId());
				
				ps.executeUpdate();			
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Tetrimino t) {
		// TODO Auto-generated method stub
		return false;
	}
}
