package com.pawar.demo.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	
	@GetMapping(path = "/filtering")
	public MappingJacksonValue retriveSomeBean() {
		
		Somebean somebean = new Somebean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		MappingJacksonValue mapping = new MappingJacksonValue(somebean);		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping(path="/filtering-list")
	public MappingJacksonValue retriveListSomeBeans() {
	
		List<Somebean> list = Arrays.asList( new Somebean("value1", "value2", "value3"),
				new Somebean("value11", "value22", "value33"));
		
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mapping.setFilters(filters );
		
		return mapping;
	}
}
