package com.jofre.uapp;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.repositories.AreaRepository;

@SpringBootApplication
public class UappApplication implements CommandLineRunner{

	@Autowired
	private AreaRepository areaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UappApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Area area1 = new Area(null, "Area 1");
		Area area2 = new Area(null, "Area 2");
		Area area3 = new Area(null, "Area 3");
		
		areaRepository.saveAll(Arrays.asList(area1, area2, area3));
	}

}
