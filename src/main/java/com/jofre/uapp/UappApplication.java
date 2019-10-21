package com.jofre.uapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.jofre.uapp.domain.Area;
import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.repositories.AreaRepository;
import com.jofre.uapp.repositories.CongregacaoRepository;


@SpringBootApplication
public class UappApplication implements CommandLineRunner{
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CongregacaoRepository congregacaoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
			
		Area area1 = new Area(null, "Area I");
		Area area3 = new Area(null, "Area III");
		Area area5 = new Area(null, "Area V");
		Area area7 = new Area(null, "Area VII");
		
		Congregacao c1 = new Congregacao(null, "BelaVista", "Eliaquim", area7);
		Congregacao c2 = new Congregacao(null, "Cajá", "Sérgio", area5);
		Congregacao c3 = new Congregacao(null, "São João 1", "José Gomes", area7);
		Congregacao c4 = new Congregacao(null, "São João 2", "Enaldo", area7);
		Congregacao c5 = new Congregacao(null, "Compesa", "Ednaldo", area5);
		Congregacao c6 = new Congregacao(null, "Barreiras", "Robson", area5);
		Congregacao c7 = new Congregacao(null, "Matriz", "Paulo", area1);
		Congregacao c8 = new Congregacao(null, "Genezaré", "Robson José", area1);
		Congregacao c9 = new Congregacao(null, "Viaduto", "Dario", area3);
		Congregacao c10 = new Congregacao(null, "Paulo Afonso", "Elias", area7);
		
		area1.getCongregacao().addAll(Arrays.asList(c7,c8));
		area3.getCongregacao().addAll(Arrays.asList(c9));
		area5.getCongregacao().addAll(Arrays.asList(c2,c5,c6));
		area7.getCongregacao().addAll(Arrays.asList(c1,c3,c4,c10));
		
		areaRepository.saveAll(Arrays.asList(area1,area3,area5,area7));
		congregacaoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
		
		
		
  }
	

}
