package tetris_partie.tetris_partie;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import authentification.Player;
import coup.coup.Coup;

public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAR_ID")
	private int id;
	
	@Column(name="PAR_DATE")
	private Date datePartie;
	
	@ManyToOne
	@JoinColumn(name="PAR_PLA_ID")
	private Player player;
	
	@OnetoMany(mappedBy="coup")
	private Coup coup;
}
