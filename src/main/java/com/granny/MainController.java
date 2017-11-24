package com.granny;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.granny.Granny;
import com.granny.GrannyRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/grannys")
public class MainController {
	@Autowired
	private GrannyRepository grannys;
	
	@PostMapping()
	public @ResponseBody Granny addNewGranny (@RequestBody Map<String, Object>[] g) {
		Granny n = new Granny();
		String name = g[0].get("name").toString();
		String description = g[0].get("description").toString();
		String img = g[0].get("img").toString();
		n.setName(name);
		n.setDescription(description);
		n.setImg(img);
		grannys.save(n);
		return n;
	}

	@GetMapping()
	public @ResponseBody Iterable<Granny> getAllGranny() {
		return grannys.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Granny getGranny(@PathVariable("id") Long id) {
		return this.grannys.findOne(id);
	}
}
