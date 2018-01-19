package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import model_tetrimino.Tetrimino;

public interface ITetriminoDAO extends JpaRepository <Tetrimino, Integer> {

}
