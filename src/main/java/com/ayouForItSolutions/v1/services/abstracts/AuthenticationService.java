package com.ayouForItSolutions.v1.services.abstracts;

import com.ayouForItSolutions.v1.servicesPublics.resultats.Result;
import com.ayouForItSolutions.v1.dtos.AuthDto;

public interface AuthenticationService {
	Result authUser(AuthDto authDto);
}
