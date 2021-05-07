package com.labforward.dev;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@RestController
public class Controller {

	@PostMapping(value = "/analyze", consumes = "application/json", produces = "application/json")
	public Analyzer analyze(@RequestBody Map<String, String> body) {
		String list = body.get("list");
		String[] items = list.split(" ");
		int tolerance = 1;
		if(body.get("tolerance") != null && body.get("tolerance").length() > 0) {
			tolerance = Integer.parseInt(body.get("tolerance"));
		}
		
		Analyzer obj = new Analyzer();
		obj.analyze(body.get("word"), items, tolerance);
		
		return obj;
	}

	@GetMapping("/")
	public @ResponseBody String index()  {
		return "<h1>Welcome to Word difference analyzer</h1>";
	}
		

}
