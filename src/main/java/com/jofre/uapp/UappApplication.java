package com.jofre.uapp;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jofre.uapp.domain.Area;
import com.jofre.uapp.domain.Congregacao;
import com.jofre.uapp.domain.Evento;
import com.jofre.uapp.domain.FrequenciaEvento;
import com.jofre.uapp.domain.FrequenciaServico;
import com.jofre.uapp.domain.Pessoa;
import com.jofre.uapp.domain.Profissao;
import com.jofre.uapp.domain.Servico;
import com.jofre.uapp.domain.StatusPessoa;
import com.jofre.uapp.domain.TipoEvento;
import com.jofre.uapp.domain.TipoPessoa;
import com.jofre.uapp.domain.TipoServico;
import com.jofre.uapp.enums.EnumFrequencia;
import com.jofre.uapp.enums.EnumStatusCadastro;
import com.jofre.uapp.enums.EnumStatusMovimento;
import com.jofre.uapp.repositories.AreaRepository;
import com.jofre.uapp.repositories.CongregacaoRepository;
import com.jofre.uapp.repositories.EventoRepository;
import com.jofre.uapp.repositories.FrequenciaEventoRepository;
import com.jofre.uapp.repositories.FrequenciaServicoRepository;
import com.jofre.uapp.repositories.PessoaRepository;
import com.jofre.uapp.repositories.ProfissaoRepository;
import com.jofre.uapp.repositories.ServicoRepository;
import com.jofre.uapp.repositories.StatusPessoaRepository;
import com.jofre.uapp.repositories.TipoEventoRepository;
import com.jofre.uapp.repositories.TipoPessoaRepository;
import com.jofre.uapp.repositories.TipoServicoRepository;


@SpringBootApplication
public class UappApplication implements CommandLineRunner{
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CongregacaoRepository congregacaoRepository;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private StatusPessoaRepository statusPessoaRepository;
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private FrequenciaServicoRepository frequenciaServicoRepository;
	
	@Autowired
	private FrequenciaEventoRepository frequenciaEventoRepository;
	
	@Autowired
	private TipoEventoRepository tipoEventoRepository;
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	
	
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
		
//		area1.getCongregacao().addAll(Arrays.asList(c7,c8));
//		area3.getCongregacao().addAll(Arrays.asList(c9));
//		area5.getCongregacao().addAll(Arrays.asList(c2,c5,c6));
//		area7.getCongregacao().addAll(Arrays.asList(c1,c3,c4,c10));
		
		areaRepository.saveAll(Arrays.asList(area1,area3,area5,area7));
		congregacaoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
		
		TipoPessoa tp1 = new TipoPessoa(null, "Pessoa");
		TipoPessoa tp2 = new TipoPessoa(null, "Dirigente");
		TipoPessoa tp3 = new TipoPessoa(null, "Pesp Congreg");
		TipoPessoa tp4 = new TipoPessoa(null, "Jovem");
		
		StatusPessoa sp1 = new StatusPessoa(null, "Comunihão");
		StatusPessoa sp2 = new StatusPessoa(null, "Afastado");
		StatusPessoa sp3 = new StatusPessoa(null, "Falecido");
		
		Profissao pf1 = new Profissao(null, "Maestro");
		Profissao pf2 = new Profissao(null,"Pregador");
		Profissao pf3 = new Profissao(null, "Componente");
		
		//Integer id, boolean ativo, String nome, boolean eMembro, Congregacao congregacao,TipoPessoa tipoPessoa
		Pessoa p1 = new Pessoa(null,EnumStatusCadastro.SIM,"Letícia Dias",true,c2,tp1,sp1,pf1);
		Pessoa p2 = new Pessoa(null,EnumStatusCadastro.SIM,"Letícia Adelino",false,c2,tp2,sp1,pf2);
		Pessoa p3 = new Pessoa(null,EnumStatusCadastro.SIM,"Letícia Vitória",false,c2,tp3,sp2,pf3);
		Pessoa p4 = new Pessoa(null,EnumStatusCadastro.SIM,"Eldio Lima",false,c2,tp2,sp1,pf3);
		Pessoa p5 = new Pessoa(null,EnumStatusCadastro.SIM,"Alex Souza",false,c2,tp3,sp1,pf3);
		Pessoa p6 = new Pessoa(null,EnumStatusCadastro.SIM,"Márcio Almeida",false,c2,tp1,sp3,pf3);
		Pessoa p7 = new Pessoa(null,EnumStatusCadastro.SIM,"Angela Maria",false,c1,tp2,sp1,pf3);
		Pessoa p8 = new Pessoa(null,EnumStatusCadastro.SIM,"Fábio Jorge",false,c2,tp2,sp1,pf3);
		Pessoa p9 = new Pessoa(null,EnumStatusCadastro.SIM,"Eliaquim Lima",false,c2,tp1,sp1,pf3);
		Pessoa p10 = new Pessoa(null,EnumStatusCadastro.SIM,"Leonardo Júnior",false,c2,tp4,sp1,pf3);
		
		tipoPessoaRepository.saveAll(Arrays.asList(tp1,tp2,tp3,tp4));
		statusPessoaRepository.saveAll(Arrays.asList(sp1,sp2,sp3));
		profissaoRepository.saveAll(Arrays.asList(pf1,pf2,pf3));
		pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
		TipoEvento te1 = new TipoEvento(null,"Ensaio do Congresso","2020");
		TipoEvento te2 = new TipoEvento(null,"Congresso","2020");
		TipoEvento te3 = new TipoEvento(null,"Manhã Missionária","2020");
		TipoEvento te4 = new TipoEvento(null,"Jejum para o Congresso","2020");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		Evento e1 = new Evento(null,"Primeiro dia",EnumStatusMovimento.PENDENTE,sdf.parse("26/06/2020"),te1);
		Evento e2= new Evento(null,"Segundo dia",EnumStatusMovimento.PENDENTE,sdf.parse("27/06/2020"),te1);
		Evento e3 = new Evento(null,"Terceiro dia",EnumStatusMovimento.PENDENTE,sdf.parse("28/06/2020"),te1);
		Evento e4 = new Evento(null,"Primeiro dia",EnumStatusMovimento.LIBERADO,sdf.parse("28/06/2020"),te2);
		Evento e5 = new Evento(null,"Primeiro dia",EnumStatusMovimento.PENDENTE,sdf.parse("29/06/2020"),te3);
		Evento e6 = new Evento(null,"Primeiro dia",EnumStatusMovimento.PENDENTE,sdf.parse("10/07/2020"),te4);
		
		FrequenciaEvento fe1 = new FrequenciaEvento(e1,p3,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe2 = new FrequenciaEvento(e1,p1,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe3 = new FrequenciaEvento(e1,p5,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe4 = new FrequenciaEvento(e1,p10,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe5 = new FrequenciaEvento(e1,p6,EnumFrequencia.JUSTIFICADO);
		FrequenciaEvento fe6 = new FrequenciaEvento(e1,p8,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe7 = new FrequenciaEvento(e2,p3,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe8 = new FrequenciaEvento(e3,p3,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe9 = new FrequenciaEvento(e4,p3,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe10 = new FrequenciaEvento(e5,p3,EnumFrequencia.PRESENTE);
		FrequenciaEvento fe11 = new FrequenciaEvento(e6,p3,EnumFrequencia.PRESENTE);
		
		tipoEventoRepository.saveAll(Arrays.asList(te1,te2,te3,te4));
		eventoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		frequenciaEventoRepository.saveAll(Arrays.asList(fe1,fe2,fe3,fe4,fe5,fe6,fe7,fe8,fe9,fe10,fe11));
		
		TipoServico ts = new TipoServico(null,"Escalas","2020");
		Servico s1 = new Servico(null,"Raminho",EnumStatusMovimento.PENDENTE,sdf.parse("22/07/2020"),ts,c2);
		FrequenciaServico fs = new FrequenciaServico(s1,p8,EnumFrequencia.JUSTIFICADO);
		
		tipoServicoRepository.save(ts);
		servicoRepository.save(s1);
		frequenciaServicoRepository.save(fs);
	}
	

}
