package profit;

import profit.application.EmitirOrdemFacade;
import profit.application.EmitirOrdemFacadeImpl;
import profit.domain.OrdemRepository;
import profit.domain.OrdemRepositoryImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.wideplay.warp.jpa.JpaUnit;
import com.wideplay.warp.persist.PersistenceService;
import com.wideplay.warp.persist.UnitOfWork;

public class Registry {
	
	private static Injector inj;
	
	private static Double taxaBovespa = 0D;
	private static Double taxaCLBC = 0D;
	
	private static Injector getInjector() {
		
		if (inj == null) {
			inj = Guice.createInjector(
					new Module[] {
							new TestModule(), 
							PersistenceService.usingJpa().across(UnitOfWork.TRANSACTION).buildModule()}
					);
			inj.getInstance(JpaInitializer.class);
		}
		
		return inj;
	}
		
	public static <T> T getInstance(Class<T> arg0) {
		return getInjector().getInstance(arg0);
	}

	static class TestModule extends AbstractModule {

		protected void configure() {
//			EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();
//			bind(EntityManager.class).toInstance(em);
			bindConstant().annotatedWith(JpaUnit.class).to("default");
			bind(EmitirOrdemFacade.class).to(EmitirOrdemFacadeImpl.class);
			bind(OrdemRepository.class).to(OrdemRepositoryImpl.class);			
		}
		
	}
	
	public static Double getTaxaBovespa() {
		return taxaBovespa;
	}

	public static void setTaxaBovespa(Double valor) {
		taxaBovespa = valor;
	}

	public static Double getTaxaCLBC() {
		return taxaCLBC;
	}

	public static void setTaxaCLBC(Double valor) {
		taxaCLBC = valor;
	}
}
