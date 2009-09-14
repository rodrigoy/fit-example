package profit.application;

import java.util.List;

import profit.domain.Ordem;
import profit.domain.OrdemRepository;

import com.google.inject.Inject;
import com.wideplay.warp.persist.Transactional;

public class EmitirOrdemFacadeImpl implements EmitirOrdemFacade {
	
	@Inject
	OrdemRepository ordemRepository;
	
	Ordem ordem;
	
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	@Transactional
	public void emitir() {
		ordemRepository.add(ordem);
	}
	
	public List<Ordem> getBook(String papel) {
		return ordemRepository.getBookCompras(papel);
	}
	
}
