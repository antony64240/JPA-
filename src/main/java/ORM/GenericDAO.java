package ORM;

import java.io.Serializable;
import java.util.List;

import model.Utilisateur;
 

public interface GenericDAO<T, ID extends Serializable> 
{

T findById(ID id, boolean lock);
T findById(ID id);
List<T> findAll();
List<T> findByExample(T exampleInstance);
T save(T entity);
T update(T entity);
void delete(ID id);

}