package com.abouna.zekouli_ui.services;

import org.springframework.stereotype.Component;

import com.abouna.zekouli_ui.data.dtos.GroupeMatiereDto;
import com.abouna.zekouli_ui.services.proxy.GroupeMatiereProxy;
/**
 * 
 * @author abouna
 *
 */
@Component
public class GroupeMatiereService extends AbstractServiceImpl<GroupeMatiereDto, Long>{

	public GroupeMatiereService(GroupeMatiereProxy proxy) {
		super(proxy);
	}

}
