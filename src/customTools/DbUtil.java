package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Gradebook;
import model.Gradebookuser;





@SuppressWarnings("unused")
public class DbUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GradeBook");
	public static EntityManagerFactory getEmFactory(){
		return emf;
	}
	
	
}
