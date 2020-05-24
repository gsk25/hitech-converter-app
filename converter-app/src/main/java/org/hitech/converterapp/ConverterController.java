package org.hitech.converterapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertions")
public class ConverterController {

	@GetMapping("/ktoc")
	public @ResponseBody String convertKtoC(@RequestParam(name = "k") String kelvin) {
		System.out.println("Calling request is /ktoc to convert Kelvin to Celsius.");
		Float k = Float.parseFloat(kelvin);
		System.out.println("Input value is "+kelvin+"K");
		Float celsius = k-273.15f;
		System.out.println("Converted Value : "+celsius+"C");
		String result = kelvin + " K = "+celsius +" C";
		return result;
	}
	
	@GetMapping("/ctok")
	public @ResponseBody String convertCtoK(@RequestParam(name = "c") String celsius) {
		System.out.println("Calling request is /ctok to convert Celsius to Kelvin");
		Float c = Float.parseFloat(celsius);
		System.out.println("Input value is "+celsius+"C");
		Float kelvin = c+273.15f;
		System.out.println("Converted Value : "+kelvin+"K");
		String result = celsius + " C = "+kelvin +" K";
		return result;
	}
	
	@GetMapping("/mtok")
	public @ResponseBody String convertMtoK(@RequestParam(name = "m") String miles) {
		System.out.println("Calling request is /mtok to convert miles to kilometers");
		Double milesValue = Double.parseDouble(miles);
		System.out.println("Input value is "+milesValue+" M");
		Double kms = milesValue*1.60934;
		System.out.println("Converted Value : "+kms+"KM");
		String result = miles +" M = "+kms+" KMS";
		return result;
	}
	
	@GetMapping("/ktom")
	public @ResponseBody String convertKtoM(@RequestParam(name = "km") String km) {
		System.out.println("Calling request is /ktom to convert kilometers to miles.");
		Double kmValue = Double.parseDouble(km);
		System.out.println("Input value is "+km+"m");
		Double miles = kmValue*0.621371;
		System.out.println("Converted Value : "+miles+"M");
		String result = km +" KMS = "+miles+" M";
		return result;
	}
	
}
