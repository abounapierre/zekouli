package com.abouna.zekouli_ui.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abouna.zekouli_ui.services.proxy.AnneeScolaireProxy;
import com.abouna.zekouli_ui.services.proxy.ClasseProxy;
import com.abouna.zekouli_ui.services.proxy.CycleProxy;
import com.abouna.zekouli_ui.services.proxy.EleveProxy;
import com.abouna.zekouli_ui.services.proxy.EtablissementProxy;
import com.abouna.zekouli_ui.services.proxy.GroupeMatiereProxy;
import com.abouna.zekouli_ui.services.proxy.InscriptionProxy;
import com.abouna.zekouli_ui.services.proxy.MatiereProxy;
import com.abouna.zekouli_ui.services.proxy.NiveauProxy;
import com.abouna.zekouli_ui.services.proxy.SequenceProxy;
import com.abouna.zekouli_ui.services.proxy.SerieProxy;
import com.abouna.zekouli_ui.services.proxy.TrimestreProxy;
import com.abouna.zekouli_ui.services.proxy.TypeEtablissementProxy;

/**
 * 
 * @author abouna
 *
 */
@Configuration
public class ProxyConfig {
	@Autowired
	private BOConfig boConfig;

	@Bean
	public ClasseProxy getClasseProxy() {
		return FeignConfig.getFeignClient(ClasseProxy.class, boConfig.getUrlComplete().concat("classes"));
	}

	@Bean
	public TypeEtablissementProxy getTypeEtablissementProxy() {
		return FeignConfig.getFeignClient(TypeEtablissementProxy.class,
				boConfig.getUrlComplete().concat("type-etablissements"));
	}

	@Bean
	public EtablissementProxy getEtablissementProxy() {
		return FeignConfig.getFeignClient(EtablissementProxy.class, boConfig.getUrlComplete().concat("etablissements"));
	}

	@Bean
	public CycleProxy getCycleProxy() {
		return FeignConfig.getFeignClient(CycleProxy.class, boConfig.getUrlComplete().concat("cycles"));
	}

	@Bean
	public NiveauProxy getNiveauProxy() {
		return FeignConfig.getFeignClient(NiveauProxy.class, boConfig.getUrlComplete().concat("niveaux"));
	}

	@Bean
	public SerieProxy getSerieProxy() {
		return FeignConfig.getFeignClient(SerieProxy.class, boConfig.getUrlComplete().concat("series"));
	}

	@Bean
	public GroupeMatiereProxy getGroupeMatiereProxy() {
		return FeignConfig.getFeignClient(GroupeMatiereProxy.class,
				boConfig.getUrlComplete().concat("groupe-matieres"));
	}

	@Bean
	public MatiereProxy getMatiereProxy() {
		return FeignConfig.getFeignClient(MatiereProxy.class, boConfig.getUrlComplete().concat("matieres"));
	}

	@Bean
	public SequenceProxy getSequenceProxy() {
		return FeignConfig.getFeignClient(SequenceProxy.class, boConfig.getUrlComplete().concat("sequences"));
	}

	@Bean
	public TrimestreProxy getTrimestreProxy() {
		return FeignConfig.getFeignClient(TrimestreProxy.class, boConfig.getUrlComplete().concat("trimestres"));
	}
	
	@Bean
	public AnneeScolaireProxy getAnneeScolaireProxy() {
		return FeignConfig.getFeignClient(AnneeScolaireProxy.class,boConfig.getUrlComplete().concat("annee-scolaires"));
	}
	
	@Bean
	public EleveProxy getEleveProxy() {
		return FeignConfig.getFeignClient(EleveProxy.class,boConfig.getUrlComplete().concat("eleves"));
	}
	
	@Bean
	public InscriptionProxy getInscriptionProxy() {
		return FeignConfig.getFeignClient(InscriptionProxy.class,boConfig.getUrlComplete().concat("inscriptions"));
	}

}
