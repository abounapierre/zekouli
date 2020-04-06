package com.abouna.zekouli_ui.services;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.AnneeScolaireDto;
import com.abouna.zekouli_ui.services.proxy.AnneeScolaireProxy;

@Component
public class AnneeScolaireService extends AbstractServiceImpl<AnneeScolaireDto, Long> {
	private final AnneeScolaireProxy proxy;
	
	public AnneeScolaireService(AnneeScolaireProxy proxy) {
		super(proxy);
		this.proxy = proxy;
	}

	public AnneeScolaireDto enregistrerAnnee(AnneeScolaireDto anneeScolaireDto) {
		LocalDate debut = anneeScolaireDto.getJourDebut();
		LocalDate fin = anneeScolaireDto.getJourFin();
		if (debut.isBefore(fin)) {
			anneeScolaireDto.setCode(debut.getYear() + "-" + fin.getYear());
			anneeScolaireDto.setFin(Long.valueOf(fin.getYear()));
			anneeScolaireDto.setDebut(Long.valueOf(debut.getYear()));
				if(anneeScolaireDto.isEnCours()) {
					for(AnneeScolaireDto dto :getListe()) {
						if(dto.isEnCours()) {
							dto.setEnCours(false);
							enregistrerOuModifier(dto, dto.getId());
						}					
					}
				}
				return enregistrerOuModifier(anneeScolaireDto, anneeScolaireDto.getId());			
		}
		return null;
	}
	
	public AnneeScolaireDto getAnneeScolaireEncours() {
		return proxy.getAnneeScolaireEncours();
	}
	
	public AnneeScolaireDto getAnneeScolaireParCode(String code) {
		return proxy.getAnneeScolaireParCode(code);
	}
}
