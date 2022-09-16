package upeu.edu.pe.pyventas.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.pyventas.dao.Operaciones;
import upeu.edu.pe.pyventas.daoImpl.ProductoDaqoImpl;
import upeu.edu.pe.pyventas.entity.Producto;
@Service
public class ProductoService implements Operaciones<Producto> {
	
	@Autowired
	private ProductoDaqoImpl daoImpl;

	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		return daoImpl.create(t);
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return daoImpl.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daoImpl.delete(id);
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return daoImpl.read(id);
	}

	@Override
	public List<Producto> reaAll() {
		// TODO Auto-generated method stub
		return daoImpl.reaAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
