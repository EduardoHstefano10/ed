package upeu.edu.pe.pyventas.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pyventas.dao.Operaciones;
import upeu.edu.pe.pyventas.entity.Producto;

@Component
public class ProductoDaqoImpl implements Operaciones<Producto> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO (nombre, precio, stock) VALUES(?,?,?)";
		return jdbcTemplate.update(SQL, t.getNombre(), t.getPrecio(), t.getStock());
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO (nombre, precio, stock) VALUES(?,?,?)";
		return jdbcTemplate.update(SQL, t.getNombre(), t.getPrecio(), t.getStock());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM producto WHERE idproducto=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		try {
			Producto prod = jdbcTemplate.queryForObject("SELECT * FROM producto WHERE idproducto=?",
					BeanPropertyRowMapper.newInstance(Producto.class), id);
			return prod;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<Producto> reaAll() {
		// TODO Auto-generated method stub	
		return jdbcTemplate.query("SELECT * FROM producto", BeanPropertyRowMapper.newInstance(Producto.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
