package UnitTestCase;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.junit.Test;
import customTools.DbUtil;
import customtools.DBGradebookUser;
import model.Gradebook;
import model.Gradebookuser;


public class UnitTest {

	@Test
	public void test() {
		
		EntityManager em =DbUtil.getEmFactory().createEntityManager();


		Gradebook gb = new Gradebook();
		gb.setAssignment("Java");
		gb.setUserid(4);
		
		
		//System.out.println("GradeBook Insert");
		//DBGradebookUser.insert(gb);
		
	}

}
