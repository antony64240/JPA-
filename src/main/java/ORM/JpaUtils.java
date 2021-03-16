package ORM;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;





public class JpaUtils {
	private static Logger logger = LogManager.getLogger(JpaUtils.class);
	private static final EntityManagerFactory entityManagerFactory;
	static
	{
		
		try
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
			logger.debug("Entity Manager Test ..." + entityManagerFactory);
		}
		catch (Throwable ex)
		{
		
			String message="Initial EntityManagerFactory creation failed." + ex;
			logger.error(message);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory()
	{
		return entityManagerFactory;
	}
}

