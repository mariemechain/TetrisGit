package tetrimino.dao;
import java.util.List;

public interface IDaoGeneric <T> {
	public T findById(int id);
	public List<T> findAll();
	public boolean save(T t);
	public boolean delete(T t);

}
