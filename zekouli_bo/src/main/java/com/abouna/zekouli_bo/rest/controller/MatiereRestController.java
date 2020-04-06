package com.abouna.zekouli_bo.rest.controller;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.MatiereBusinessService;
import com.abouna.zekouli_bo.data.dtos.MatiereDto;

@RestController
@RequestMapping("/matieres")
public class MatiereRestController extends AbstractRestControllerImpl<MatiereDto, Long>{

	public MatiereRestController(MatiereBusinessService service) {
		super(service);
	}

}
