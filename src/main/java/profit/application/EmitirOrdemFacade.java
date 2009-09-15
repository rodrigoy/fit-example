package profit.application;

import java.util.List;

import profit.domain.Ordem;
import profit.domain.TipoOrdem;

import com.google.inject.ImplementedBy;

@ImplementedBy(EmitirOrdemFacadeImpl.class)
public interface EmitirOrdemFacade {

	public abstract void setOrdem(Ordem ordem);

	public abstract void emitir();
	
	public List<Ordem> getBook(String papel, TipoOrdem tipo);

}