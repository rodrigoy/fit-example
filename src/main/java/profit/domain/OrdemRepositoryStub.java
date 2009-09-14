package profit.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implementação Stub
 * @author rodrigoy
 *
 */
public class OrdemRepositoryStub implements OrdemRepository {

	Map<String, Set<Ordem>> repository = new HashMap<String, Set<Ordem>>();
	
	public void add(Ordem ordem) {
		String papel = ordem.getPapel();
		if (repository.containsKey(papel)) {
			Set<Ordem> set = repository.get(papel);
			set.add(ordem);
		} else {
			Set<Ordem> set = new TreeSet<Ordem>();
			set.add(ordem);
			repository.put(papel, set);
		}
	}
	
	public List<Ordem> getBookCompras (String papel) {
		if (repository.containsKey(papel)) {
			return new ArrayList<Ordem>(repository.get(papel));
		} else {
			return new ArrayList<Ordem>();
		}
	}

}
