package upeu.edu.pe.pyventas.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pyventas.dao.Operaciones;
import upeu.edu.pe.pyventas.entity.Detalle;

@Component
public class DetalleDaoImpl implements Operaciones<Detalle> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO delalle (idventas, idproductos, precio, cantidad) VALUES (?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getIdventas(), t.getIdproducto(),t.getPrecio(), t.getCantidad());
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE detalle SET cantidad = ? WHERE (iddetalle = ?)";
		return jdbcTemplate.update(SQL, t.getCantidad(), t.getIddetalle());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL="DELETE FROM  WHERE iddetalle = ?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		try {
			Detalle det = jdbcTemplate.queryForObject("SELECT * FROM detalle WHERE iddetalle=?",
					BeanPropertyRowMapper.newInstance(Detalle.class), id);
			return det;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Detalle> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from detalle", BeanPropertyRowMapper.newInstance(Detalle.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		String SQL = "select v.idventas, v.fecha, p.idproducto, p.nombre, d.precio, d.cantidad from detalle as d "
				+ "inner join venta as v on d.idventas= v.idventas "
				+ "inner join producto as p on d.idproducto= p.idproducto ";
		return jdbcTemplate.queryForList(SQL);
	}

}
