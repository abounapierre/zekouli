package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.GroupeMatiereBusinessService;
import com.abouna.zekouli_bo.data.models.GroupeMatiereDto;

@RestController
@RequestMapping("/groupe-matieres")
public class GroupeMatiereRestController extends AbstractRestControllerImpl<GroupeMatiereDto, Long>{

	public GroupeMatiereRestController(GroupeMatiereBusinessService service) {
		super(service);
	}

}
