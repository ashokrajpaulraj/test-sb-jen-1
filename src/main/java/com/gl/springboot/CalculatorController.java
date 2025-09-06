package com.gl.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//This is a controller creating Rest API
@RestController
public class CalculatorController {

	//http://localhost:8081/add?a=10&b=20
	@GetMapping("/add")
	public String add( @RequestParam int a, @RequestParam int b ) {
		int c = a + b;
		return "Addition : " + c;
	}
	
	@GetMapping("/addnew")
	public ResponseEntity<String> addnew( @RequestParam int a, @RequestParam int b ) {
		return ResponseEntity.status(HttpStatus.OK).body( "Add : " + (a+b) );
	}
	
	//http://localhost:8081/sub?a=10&b=20
	@GetMapping("/sub")
	public String sub(@RequestParam int a, @RequestParam int b) {
		return "Sub : " + (a-b);
	}
	
	//http://localhost:8081/subnew?a=10&b=20
	@GetMapping("/subnew")
	public ResponseEntity<String> subnew(@RequestParam int a, @RequestParam int b) {
		if( a < b ) {
			return ResponseEntity.status( HttpStatus.BAD_REQUEST).body("B must be bigger than A");
		}
		
		return ResponseEntity.status( HttpStatus.OK).body("Sub : " + (a-b) );
	}
	
	//http://localhost:8081/mul/10/20
	@GetMapping("/mul/{a}/{b}")
	public String mul(@PathVariable int a, @PathVariable int b) {
		return "Mul : " + (a * b);
	}	
	
}
