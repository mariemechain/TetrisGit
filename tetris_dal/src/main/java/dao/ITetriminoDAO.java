package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris_metier.Tetrimino;

public interface ITetriminoDAO extends JpaRepository <Tetrimino, Integer> {

}
