package profit.domain;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Implementação
 * @author rodrigoy
 */
public class OrdemRepositoryImpl implements OrdemRepository {

	@Inject Provider<EntityManager> provider;
	
	public void add(Ordem ordem) {
		provider.get().persist(ordem);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ordem> getBook (String papel, TipoOrdem tipo) {
		
		return provider.get().createQuery("from Ordem where tipo = :tipo" +
				" and status = :status" +
				" and papel = :papel order by valor " +  tipo.order())
			.setParameter("papel", papel)
			.setParameter("status", StatusOrdem.Processada)
			.setParameter("tipo", tipo)
			.getResultList();

	}

}
