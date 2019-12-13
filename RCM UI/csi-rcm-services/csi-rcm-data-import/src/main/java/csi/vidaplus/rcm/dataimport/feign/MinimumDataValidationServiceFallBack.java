package csi.vidaplus.rcm.dataimport.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import csi.vidaplus.rcm.dataimport.model.Encounter;

@Component
public class MinimumDataValidationServiceFallBack implements MinimumDataValidationService{

	@Override
	public List<Encounter> validateMinimumData() {
		
		return new ArrayList<>();
	}

}
