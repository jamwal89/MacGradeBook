package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTools.DbUtil;
import model.Gradebook;

public class DBGradebook {
	  
	public static void insert(Gradebook Gradebook) {
		    
 		 EntityManager em = DbUtil.getEmFactory().createEntityManager();
 		 EntityTransaction trans = em.getTransaction();
 		 //System.out.println("DbBullhorn: begin transaction");
 		 try {
 		 trans.begin();
 		 em.persist(Gradebook);
 		 //System.out.println("DbBullhorn: commit transaction");
 		 trans.commit();
 		 } catch (Exception e) {
 		 e.printStackTrace();
 		 //System.out.println("DbBullhorn: rollback transaction");
 		 trans.rollback();
 		 } finally {
 		 //System.out.println("DbBullhorn: close em");
 		 em.close();
 		 }
 		 
    
 }

 public static void update(Gradebook Gradebook) {
 	 EntityManager em = DbUtil.getEmFactory().createEntityManager();
 	 EntityTransaction trans = em.getTransaction();
 	 try {
 	 trans.begin();
 	 em.merge(Gradebook);
 	 trans.commit();
 	 } catch (Exception e) {
 	 System.out.println(e);
 	 trans.rollback();
 	 } finally {
 	 em.close();
 	 }
   
 }

 public static void delete(Gradebook Gradebook) {
 	 EntityManager em = DbUtil.getEmFactory().createEntityManager();
 	 EntityTransaction trans = em.getTransaction();
 	 try {
 	 trans.begin();
 	 em.remove(em.merge(Gradebook));
 	 trans.commit();
 	 } catch (Exception e) {
 	 System.out.println(e);
 	 trans.rollback();
 	 } finally {
 	 em.close();
 	 }
     
 }

 public static List<Gradebook> Gradebook (){
     EntityManager em = DbUtil.getEmFactory().createEntityManager();
     String qString = "select b from Gradebook b";
     
     List<Gradebook> posts = null;
     try{
         TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
         posts = query.getResultList();

     }catch (Exception e){
         e.printStackTrace();
     }
     finally{
             em.close();
         }
     return posts;
 }
 
 public static List<Gradebook> gradesofuser(long userid)
 {
     EntityManager em = DbUtil.getEmFactory().createEntityManager();
     List<Gradebook> grades = null;
     String qString = "select b from Gradebook b where b.userid = :userid";
     
     try{
         TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
         query.setParameter("userid", userid);
         grades = query.getResultList();
     }catch (Exception e){
         e.printStackTrace();
     }
     finally{
             em.close();
         }
     return grades;    
 }
 public static List<Gradebook> postsofUser(String name)
 {
     EntityManager em = DbUtil.getEmFactory().createEntityManager();
     List<Gradebook> userposts = null;
     String qString = "select b from Gradebook b "
             + "where b.Gradebookuser.username = :name";
     
     try{
         TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
         query.setParameter("username", name);
         userposts = query.getResultList();
     }catch (Exception e){
         e.printStackTrace();
     }
     finally{
             em.close();
         }
     return userposts;    
 }
 
 public static List<Gradebook> searchGrades (String search)
 {
     EntityManager em = DbUtil.getEmFactory().createEntityManager();
     List<Gradebook> searchposts = null;
     String qString = "select b from Gradebook b "
             + "where b.grade like :search";
     
     try{
         TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
         query.setParameter("search", "%" + search + "%");
         searchposts = query.getResultList();
     }catch (Exception e){
         e.printStackTrace();
     }finally{
         em.close();
     }return searchposts;
 }
 
	

}
