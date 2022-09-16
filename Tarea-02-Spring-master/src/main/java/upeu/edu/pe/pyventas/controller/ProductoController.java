package upeu.edu.pe.pyventas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.pyventas.entity.Producto;
import upeu.edu.pe.pyventas.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/all")
	public List<Producto> readAll2(){		
		return productoService.reaAll();
	}
	
	@PostMapping("/save")
	public int save(@RequestBody Producto producto){		
		return productoService.create(producto);
	}
}
