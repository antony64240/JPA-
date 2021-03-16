package ORM;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID>
{
	// on utilise l'API reflection pour déterminer le type
	// de l'entité
	private Class<T> persistentClass;
	// private EntityManager entityManager = null;
	@SuppressWarnings("unchecked")

	public GenericDAOImpl()
	{
		// On récupère ici le type du premier paramètre
		// de la classe générique (cad T)
		// persistentClass contient le type de l'entité passé en paramètre.
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass()
	{
		return persistentClass;
	}

	public T findById(ID id, boolean lock)
	{
		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
		T entite = null;
		try
		{
			if (lock)
				entite = entityManager.find(getPersistentClass(), id, LockModeType.WRITE);
			else
				entite = entityManager.find(getPersistentClass(), id);
			return entite;
		}
		finally
		{
			entityManager.close();
		}
	}

	public T findById(ID id)
	{
		return findById(id, false);
	}

	public List<T> findAll()
	{
		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
		try
		{
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<T> query = criteriaBuilder.createQuery(persistentClass);
			Root<T> root = query.from(getPersistentClass());
			query.select(root);
			List<T> liste = entityManager.createQuery(query).getResultList();
			return liste;
		}
		finally
		{
			entityManager.close();
		}
	}


	public List<T> findByExample(T exampleInstance)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public T save(T entity)
	{
		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
		try
		{
			// marque le début de la transaction
			entityManager.getTransaction().begin();
			// enregistrement des données dans la base MySQL
			entityManager.persist(entity);
			// fin de la transaction
			entityManager.getTransaction().commit();
			return entity;
		}
		finally
		{
			entityManager.close();
		}
	}


	public T update(T entity)
	{
		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
		try
		{
			// marque le début de la transaction
			entityManager.getTransaction().begin();
			// enregistrement des données dans la base MySQL
			entityManager.merge(entity);
			// fin de la transaction
			entityManager.getTransaction().commit();
			return entity;
		}
		finally
		{
			entityManager.close();
		}
	}


	public void delete(ID id)
	{
		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();
		try
		{
			// marque le début de la transaction
			entityManager.getTransaction().begin();
			// récupère l'entité à partir de son ID
			T entity = entityManager.find(getPersistentClass(), id);
			// enregistrement des données dans la base MySQL
			entityManager.remove(entity);
			// fin de la transaction
			entityManager.getTransaction().commit();
		}
		finally
		{
			entityManager.close();
		}
	}
}