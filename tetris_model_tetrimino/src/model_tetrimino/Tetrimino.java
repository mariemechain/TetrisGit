package model_tetrimino;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY	)
@Table(name="tetrimino")
public class Tetrimino {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TET_ID")
	private int id;
	
	@Column(name="TET_NOM")
	private String nom;
		
	@Column(name="TET_COULEUR")
	private String couleur;

	public int[][] rotation45deg(int[][] matriceEntree){
		int size = matriceEntree.length;
		int[][] matriceRetour = new int[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++)
				matriceRetour[i][j]=matriceEntree[size-1-j][i];
		}
		return matriceRetour;	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Tetrimino n°"+id+" nom=" + nom + ", couleur=" + couleur;
	}

}
