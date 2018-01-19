package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris_metier.Coup;



public interface ICoupDAO extends JpaRepository <Coup, Integer> {

}
