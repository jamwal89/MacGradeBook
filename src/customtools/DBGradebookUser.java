package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DbUtil;

import model.Gradebookuser;

public class DBGradebookUser {
	
	
	public static boolean isValidUser(String name, String password)
	 {
	 EntityManager em = DbUtil.getEmFactory().createEntityManager();
	 String qString = "Select count(u.userid) from Gradebookuser u "
	 + "where u.username = :username and u.userpassword = :userpass";
	 TypedQuery<Long> q = em.createQuery(qString,Long.class);
	 boolean result = false;
	 q.setParameter("username", name);
	 q.setParameter("userpass", password);

	 try{
	 long userId = q.getSingleResult();
	 if (userId > 0)
	 {
	 result = true;
	 }
	 }catch (Exception e){

	 result = false;
	 }
	 finally{
	 em.close(); 
	 } 
	 return result;

	 }
	
	 public static Gradebookuser getUserByname(String name)
	 {
	 EntityManager em = DbUtil.getEmFactory().createEntityManager();
	 String qString="";
	 TypedQuery<Gradebookuser> q;
	 
	
	 if(name.equals("%")){
		 qString= "Select u from Gradebookuser u ";
		 q = em.createQuery(qString, Gradebookuser.class);
	 }else {
		  qString = "Select u from Gradebookuser u "
				 + "where u.username = :username";
				  q = em.createQuery(qString, Gradebookuser.class);
				 q.setParameter("username", name);	 
	 }
	
	 Gradebookuser user = null;
	 try {
	 user = q.getSingleResult();
	 }catch (NoResultException e){
	 System.out.println(e);
	 }finally{
	 em.close();
	 }
	 return user;

	 }
		public static void insert(Gradebookuser user) {
		    
	 		 EntityManager em = DbUtil.getEmFactory().createEntityManager();
	 		 EntityTransaction trans = em.getTransaction();
	 		 //System.out.println("DbBullhorn: begin transaction");
	 		 try {
	 		 trans.begin();
	 		 em.persist(user);
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
	 		 public static List<Gradebookuser> getalluser(Gradebookuser user) {

	 			
	 			     EntityManager em = DbUtil.getEmFactory().createEntityManager();
	 			     String qString = "select b from Gradebookuser b";
	 			     
	 			     List<Gradebookuser> users = null;
	 			     try{
	 			         TypedQuery<Gradebookuser> query = em.createQuery(qString,Gradebookuser.class);
	 			         users = query.getResultList();

	 			     }catch (Exception e){
	 			         e.printStackTrace();
	 			     }
	 			     finally{
	 			             em.close();
	 			         }
	 			     return users;
	 			 }
	 		 
}

