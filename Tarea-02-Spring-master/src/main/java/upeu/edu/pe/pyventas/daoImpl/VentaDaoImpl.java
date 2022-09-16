package upeu.edu.pe.pyventas.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pyventas.dao.Operaciones;
import upeu.edu.pe.pyventas.entity.Venta;

@Component
public class VentaDaoImpl implements Operaciones<Venta> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Venta t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO venta(fecha) VALUES(now())";
		return jdbcTemplate.update(SQL);
	}

	@Override
	public int update(Venta t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE venta SET fecha = ? WHERE idventas=?";
		return jdbcTemplate.update(SQL, t.getFecha(), t.getIdventas());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM venta WHERE idventas=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Venta read(int id) {
		// TODO Auto-generated method stub
		try {
			Venta v = jdbcTemplate.queryForObject("SELECT * FROM venta WHERE idventas=?",
					BeanPropertyRowMapper.newInstance(Venta.class), id);
			return v;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Venta> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from venta", BeanPropertyRowMapper.newInstance(Venta.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
