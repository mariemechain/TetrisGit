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
public class DaoTetrimino implements IDaoGeneric<Tetrimino> {
	@Autowired
	private Connection conn;

	public String listePieces() {
		String reponse = "";
		System.out.println("Recherche ...");
		try {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * from tetrimino");
			while (rs.next()) {
				reponse += rs.getString(1);
				reponse += "" + rs.getString(2);
				reponse += "" + rs.getString(3) + "\n";
			}
			return reponse;

		} catch (SQLException e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void ajoutPiece(Tetrimino t) {

		System.out.println("Test ajoutPiece");
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement("insert into tetrimino(idtetrimino,nom,couleur) values (?,?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getNom());
			ps.setString(3, t.getCouleur());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
//	public void insertTetrimino(int id, String nom, String couleur) throws SQLException {
//		String str = "INSERT into tetrimino (id, name, color) values(?,?,?)";
//		PreparedStatement ps = conn.prepareStatement(str);
//		Tetrimino t = new Tetrimino();
//		ps.setInt(1, id);
//		ps.setString(2, nom);
//		ps.setString(3, couleur);
//		ps.executeUpdate();
//	}

	public Tetrimino findById(int id) {
		System.out.println("Recherche ...");
		try {
			conn.createStatement().executeQuery("SELECT * from tetrimino WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tetrimino> findAll() {
		try {
			List<Tetrimino> retour = new ArrayList<Tetrimino>();
			ResultSet rs = conn.createStatement().executeQuery("SELECT * from tetrimino");
			while (rs.next()) {
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
		// (if id!null)
		// //modif
		// else
		// //ajout

		PreparedStatement ps;
		try {
			// ps = conn.prepareStatement("insert into tetrimino (nom, couleur) values
			// (?,?)");
			ps = conn.prepareStatement(
					"replace (nom,'%',?), replace (couleur,'%',?) where idtetrimino = ? from tetrimino");
			ps.setString(1, t.getNom());
			ps.setString(2, t.getCouleur());
			ps.setInt(3, t.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Tetrimino t) {
//		try {
//	//		conn.createStatement().executeUpdate("DELETE from tetrimino where id= " + id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return false;
	}
}
