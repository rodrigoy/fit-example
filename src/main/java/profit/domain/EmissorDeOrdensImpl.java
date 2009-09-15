package profit.domain;

import com.google.inject.Inject;
import com.wideplay.warp.persist.Transactional;

public class EmissorDeOrdensImpl implements EmissorDeOrdens {

	@Inject
	OrdemRepository ordemRepository;

	@Transactional
	public void processar(Ordem ordem) {
		ordem.processar();
		ordemRepository.add(ordem);
	}		
}
