package profit.application;

import java.util.List;

import profit.domain.Ordem;
import profit.domain.OrdemRepository;
import profit.domain.EmissorDeOrdens;
import profit.domain.TipoOrdem;

import com.google.inject.Inject;
import com.wideplay.warp.persist.Transactional;

public class EmitirOrdemFacadeImpl implements EmitirOrdemFacade {
	
	@Inject
	OrdemRepository ordemRepository;
	
	@Inject
	EmissorDeOrdens emissor; 
	
	Ordem ordem;
	
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	@Transactional
	public void emitir() {
		emissor.processar(ordem);
	}
	
	public List<Ordem> getBook(String papel, TipoOrdem tipo) {
		return ordemRepository.getBook(papel, tipo);
	}
	
}
