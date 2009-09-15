package profit.domain;

import java.util.List;

import com.google.inject.ImplementedBy;

@ImplementedBy(OrdemRepositoryImpl.class)
public interface OrdemRepository {

	public void add(Ordem ordem);
	
	public List<Ordem> getBook (String papel, TipoOrdem tipo);
	
}
