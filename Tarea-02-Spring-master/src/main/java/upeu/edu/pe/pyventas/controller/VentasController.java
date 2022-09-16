package upeu.edu.pe.pyventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.pyventas.entity.Venta;
import upeu.edu.pe.pyventas.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
	@Autowired
	private VentaService service;
	
	@GetMapping("/all")
	public List<Venta> readAll(){		
		return service.reaAll();
	}
	@GetMapping("/{id}")
	public Venta read(@PathVariable int id){		
		return service.read(id);
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Venta venta){		
		return service.create(venta);
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Venta venta){	
		Venta v = service.read(id);
		v.setFecha("2022-09-15");
		return service.update(v);
	}
	
	@DeleteMapping("/del/{id}")
	public int save(@PathVariable int id){		
		return service.delete(id);
	}
}
