package com.hibernate.crreteria;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class TestData 
{
    public static void main(String[] args) 
    {
    	Customer c1=new Customer(1, "A", 50, 20);
    	Customer c2=new Customer(2, "B", 60, 23);
    	Customer c3=new Customer(3, "C", 70, 26);
    	Customer c4=new Customer(4, "abD", 80, 27);
    	Customer c5=new Customer(5, "D", 90, 28);
    	Customer c6=new Customer(6, "E", 80, 27);



	   Configuration con=new Configuration();
	   SessionFactory sf=con.configure("hibernate.conf.xml").buildSessionFactory();
	   
	   Session s=sf.openSession();
	    Transaction tx=s.beginTransaction(); 
	    s.save(c1);
	    s.save(c2);
	    s.save(c3);
	    s.save(c4);
	    s.save(c5);
	    s.save(c6);
	    
	    s.flush();
	    tx.commit();
	    
	  /* Criteria c=s.createCriteria(Customer.class);
	      List<Customer> clist=c.list();
	      System.out.println(clist);
	      System.out.println("Useing eq");
	      c.add(Restrictions.eq("mark", 50));
	      List cq=c.list();
	     System.out.println(cq);
	     System.out.println("-----------------");
	     
	      System.out.println("Useing gt");
	      Criteria ctr2=s.createCriteria(Customer.class);
	       ctr2.add(Restrictions.gt("mark", 60));
	        List greter=ctr2.list();
	        System.out.println(greter);
		     System.out.println("-----------------");
		     
		      Criteria ctr3=s.createCriteria(Customer.class);

	         
		      System.out.println("Useing lt");

	         ctr3.add(Restrictions.lt("mark", 70));
	              List<Customer> less=ctr3.list(); 
	              System.out.println(less);
	     	     System.out.println("-----------------");

	   	      Criteria ctr4=s.createCriteria(Customer.class);

	    	      System.out.println("Useing like");

	              
	              ctr4.add(Restrictions.like("name","A%"));
         
                         List<Customer> nm= ctr4.list();
                         System.out.println(nm);
                	     System.out.println("-----------------");
                	     
                	     Criteria ctr5=s.createCriteria(Customer.class);

       	    	      System.out.println("Useing like");

       	              
       	              ctr5.add(Restrictions.like("name","%A"));
                
                                List<Customer> nm1= ctr5.list();
                                System.out.println(nm1);
                       	     System.out.println("-----------------");
                       	     
                       	  Criteria ctr6=s.createCriteria(Customer.class);

        	    	      System.out.println("Useing between");

        	              
        	              ctr6.add(Restrictions.between("age", 22, 27));
                 
                                 List<Customer> age= ctr6.list();
                                 System.out.println(age);
                        	     System.out.println("-----------------");
                        	     
                        	     Criteria ctr7=s.createCriteria(Customer.class);

               	    	      System.out.println("Useing ISNULL");

               	              
               	              ctr7.add(Restrictions.isNull("name"));
                        
                                        List<Customer> isnull= ctr7.list();
                                        System.out.println(isnull);
                               	     System.out.println("-----------------");
                               	     
                               	  Criteria ctr8=s.createCriteria(Customer.class);

                	    	      System.out.println("Useing ISNOTNULL");

                	              
                	              ctr8.add(Restrictions.isNotNull("age"));
                         
                                         List<Customer> isnotnull= ctr8.list();
                                         System.out.println(isnotnull);
                                	     System.out.println("-----------------");
                                	     
                                	     Criteria ctr9=s.createCriteria(Customer.class);

                       	    	      System.out.println("Useing ISEmpty");

                       	              
                       	              ctr9.add(Restrictions.isEmpty("name"));
                                
                                                List<Customer> isempty= ctr9.list();
                                                System.out.println(isempty);
                                       	     System.out.println("-----------------");
                                	     
                                       	  Criteria ctr10=s.createCriteria(Customer.class);

                        	    	      System.out.println("Useing ISNOTEMPTY");

                        	              
                        	              ctr10.add(Restrictions.isNotEmpty("age"));
                                 
                                                 List<Customer> isnotempty= ctr10.list();
                                                 System.out.println(isnotempty);
                                        	     System.out.println("-----------------");*/
	    
	    /*
	                                System.out.println("USeing  Or");
	                                Criteria c=s.createCriteria(Customer.class);
	                                   Criterion ctr1=Restrictions.eq("mark", 80);
	                                    Criterion ctr2=Restrictions.eq("name","D" );
	                                     LogicalExpression l= Restrictions.or(ctr2, ctr1);
	                                
	                                      c.add(l);
	                                      List<Customer>clist=c.list();
	                                      System.out.println(clist);
	                                      
	                                      System.out.println("USeing  AND");
	  	                                Criteria cc=s.createCriteria(Customer.class);
	  	                                   Criterion ctr3=Restrictions.eq("mark", 80);
	  	                                    Criterion ctr4=Restrictions.eq("name", "D");
	  	                                     LogicalExpression ll= Restrictions.and(ctr4, ctr3);
	  	                                
	  	                                      cc.add(ll);
	  	                                      List<Customer> clist1=cc.list();
	  	                                      System.out.println(clist1);
	  	                                      
	  	                                      System.out.println("------------------");
	  	                                      System.out.println("And another");
	  	                                   Criteria cc1=  s.createCriteria(Customer.class);
	  	                                      cc1.add(Restrictions.eq("mark", 80));
	  	                                      cc1.add(Restrictions.eq("name", "E"));
	  	                                      
	  	                                     List<Customer> cclist= cc1.list();
	  	                                     System.out.println(cclist);
	  	                                      */
	                                          	   
	                              /*System.out.println("Usein addorder method");
	                              System.out.println("useing desc");
	                              Criteria c=s.createCriteria(Customer.class);
	                                   c.addOrder(Order.desc("mark"));
	                                List<Customer> clist=  c.list();
	                                System.out.println(clist);
	                                
	                                System.out.println("useing asc");
		                              Criteria cc=s.createCriteria(Customer.class);
		                                   cc.addOrder(Order.asc("mark"));
		                                List<Customer> clist1=  cc.list();
		                                System.out.println(clist1);*/
	    
	   /* System.out.println("Useing disjunction");//when i want to check more than one condition then i will ue dijunction
	    
	     * In "or()" method we can check maximum two condition but i want check more than two
	     * 
	     * 
	    Criteria c=s.createCriteria(Customer.class);
	     Criterion ctr1=Restrictions.eq("name", "E");
	        Criterion ctr2 = Restrictions.eq("mark", 70);
	          Criterion ctr3 =Restrictions.eq("age", 23);
	            Disjunction d=   Restrictions.disjunction();
	            d.add(ctr1);
	            d.add(ctr2);
	            d.add(ctr3);
	            c.add(d);
	          List<Customer> clist=  c.list();
	          System.out.println(clist);

	          System.out.println("useing sql Restriction");
	          Criteria crit = s.createCriteria(Customer.class);
	          crit.add(Restrictions.sqlRestriction("{alias}.name like 'D%'"));
	         // crit.add(Restrictions.sqlRestriction("{alias}.mark eq '80'"));false because sqlRestrictions method accept only String parameter

	          List<Customer> results = crit.list();
	          System.out.println(results);
	    */
       /*             
	    System.out.println("Paging");
	     Criteria c=s.createCriteria(Customer.class);
	     c.setFirstResult(2);//kutun chalu pn include nahi titun pudche 
	     c.setMaxResults(3);//kiti pahijet
	    List<Customer> clist= c.list();
        System.out.println(clist);   
        
         * output-[
Customer [id=3, name=C, mark=70, age=26], 
Customer [id=4, name=abD, mark=80, age=27], 
Customer [id=5, name=D, mark=90, age=28]]
         * 
         * *
         */
              
	    /*System.out.println("Useing Projection class");
	     Criteria c= s.createCriteria(Customer.class);
	     c.setProjection(Projections.rowCount());
	     List<Customer> l=c.list();
	     System.out.println(l);*/
	     
	     /*Criteria crit = s.createCriteria(Customer.class);
	     ProjectionList projList = Projections.projectionList();
	     projList.add(Projections.max("age"));
	     projList.add(Projections.min("mark"));
	     projList.add(Projections.avg("mark"));
	     projList.add(Projections.countDistinct("name"));
	     crit.setProjection(projList);
	     List<Object[]> results = crit.list();
	          Iterator<Object[]> i=  results.iterator();
	          while(i.hasNext())
	          {
	        	  
	        	   Object o[]=(Object[]) i.next();
	        	   System.out.println(Arrays.toString(o));//output -[28, 50, 71.6667, 6]
	          }*/
	/*    
	    Criteria crit = s.createCriteria(Customer.class);
	    ProjectionList projList = Projections.projectionList();
	    projList.add(Projections.property("name"));
	    projList.add(Projections.property("mark"));
	    crit.setProjection(projList);
	    //crit.addOrder(Order.asc("price"));
	    List<Object[]> results = crit.list();
	        Iterator<Object[]> i=results.iterator();
	        while(i.hasNext())
	        {
	        	   Object[] o=i.next();
	        	   System.out.println(Arrays.toString(o));
	        }
	        
	         * output-
	         * 
	         * [A, 50]
[B, 60]
[C, 70]
[abD, 80]
[D, 90]
[E, 80]
	         * */
          
	    
	    Criteria c=s.createCriteria(Customer.class);
	     c.setProjection(Projections.property("name"));
	             List<Object[]> o=c.list();
	             System.out.println(o);//output-[A, B, C, abD, D, E]
	             
	            
	}
}
