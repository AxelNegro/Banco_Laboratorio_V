package datosImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Conexion {
	private SessionFactory sessionFactory;
	private Session session;
	
	public Conexion()
	{
		Configuration configuration = new Configuration();
		try {
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Session abrirConexion()
	{
		session=sessionFactory.openSession();
		return session;
	}
	
	public void cerrarSession()
	{
		session.close();
		cerrarSessionFactory();
	}
	
	public void cerrarSessionFactory()
	{
		sessionFactory.close();
	}
}
