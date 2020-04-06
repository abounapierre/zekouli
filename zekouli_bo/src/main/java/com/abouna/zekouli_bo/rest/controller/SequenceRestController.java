package com.abouna.zekouli_bo.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abouna.zekouli_bo.business.SequenceBusinessService;
import com.abouna.zekouli_bo.data.dtos.SequenceDto;

@RestController
@RequestMapping("/sequences")
public class SequenceRestController extends AbstractRestControllerImpl<SequenceDto, Long>{

	public SequenceRestController(SequenceBusinessService service) {
		super(service);
	}

}
