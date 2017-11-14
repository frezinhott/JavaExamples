package org.hibernate.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.dto.Address;
import org.hibernate.dto.Cat;
import org.hibernate.dto.Child;
import org.hibernate.dto.Dog;
import org.hibernate.dto.FourWheeler;
import org.hibernate.dto.Job;
import org.hibernate.dto.Pet;
import org.hibernate.dto.TwoWheeler;
import org.hibernate.dto.UserDetails;
import org.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Trevor Chase");
		user.setJoinedDate(new Date());
		user.setDescription("Description of Trevor");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Barbara Chase");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of Barbara");
		
		UserDetails user3 = new UserDetails();
		user3.setUserName("Isaac Chase");
		user3.setJoinedDate(new Date());
		user3.setDescription("Description of Isaac");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setHandlebar("Bike Steering");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setSteeringWheel("Car Steering Wheel");
		
		user.setVehicle(vehicle);
		user2.setVehicle(twoWheeler);
		user3.setVehicle(fourWheeler);
		
		Pet pet = new Pet();
		pet.setPetName("Polly");
		
		Cat cat = new Cat();
		cat.setPetName("Aspen");
		cat.setCatFood("Meow");
		
		Dog dog = new Dog();
		dog.setPetName("Jazz");
		dog.setDogFood("Purina");
		
		user.setPet(pet);
		user2.setPet(dog);
		user3.setPet(cat);
		
		Job job1 = new Job();
		Job job2 = new Job();
		Job job3 = new Job();
		Job job4 = new Job();
		
		job1.setJobName("Job1");
		job2.setJobName("Job2");
		job3.setJobName("Job3");
		job4.setJobName("Job4");
		
		user.getJob().add(job1);
		user.getJob().add(job2);
		user2.getJob().add(job3);
		user3.getJob().add(job4);
		
		job1.getUserList().add(user);
		job2.getUserList().add(user);
		job3.getUserList().add(user2);
		job4.getUserList().add(user3);
		
		Child child1 = new Child();
		Child child2 = new Child();
		Child child3 = new Child();
		Child child4 = new Child();
		
		child1.setChildName("Sam");
		child2.setChildName("Eric");
		child3.setChildName("Sue");
		child4.setChildName("Jeff");
		
		user.getChild().add(child1);
		user.getChild().add(child2);
		user2.getChild().add(child3);
		user3.getChild().add(child4);
		
		child1.setUser(user);
		child2.setUser(user);
		child3.setUser(user2);
		child4.setUser(user3);
		
		Address addr = new Address();
		addr.setStreet("185 Gladesville Rd");
		addr.setCity("2 Morgantown");
		addr.setState("2 WV");
		addr.setZip(26509);
		
		Address addr2 = new Address();
		addr2.setStreet("200 Gladesville Rd");
		addr2.setCity("Morgantown");
		addr2.setState("WV");
		addr2.setZip(26508);
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		user2.getListOfAddresses().add(addr);
		user3.getListOfAddresses().add(addr2);
		
		// Create session factory object from the hibernate.cfg.xml config file
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Create a new DB session
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.persist(user);
		session.persist(user2);
		session.persist(user3);
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.save(pet);
		session.save(cat);
		session.save(dog);
		session.save(job1);
		session.save(job2);
		session.save(job3);
		session.save(job4);
		session.getTransaction().commit();
		
		session.close();
	
		// Fetch the user we just inserted
		user=null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Get the UserDails record with the primary key=1
		user = (UserDetails) session.get(UserDetails.class, 1);
		
		System.out.println("User Name retrieved: " +  user.getUserName());
		System.out.println("User's Number of Address retrieved: " + user.getListOfAddresses().size());
		System.out.println("User's Descripiton retrieved: " + user.getDescription());
		
		user.setUserName("Updated UserName");
		session.update(user);
		
		int userIdValue = 5;
		
		// Get records using a HQL Query
		@SuppressWarnings("unchecked")
		List<UserDetails> userList = session.createQuery("from UserDetails where userId > :userId and userName like :userName")
				.setParameter("userId", userIdValue).setParameter("userName", "%Trevor%")
				.setFirstResult(0) // Sets the first query result to 0
				.setMaxResults(5)  // Only pulls up the first 5 records.  Can do record paging with this.
				.list();		   // Put the result set into a list
		
		// Print out the result set
		for(UserDetails u : userList)
			System.out.println(u.getUserName());
		
		// Use the CriteriaBuilder API
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserDetails> query = builder.createQuery(UserDetails.class);
        Root<UserDetails> root = query.from(UserDetails.class);
        query.select(root).where(builder.ge(root.get("userId"), 5)); // Get all users with an userId > 5
        Query<UserDetails> q=session.createQuery(query);
        List<UserDetails> userList2 = q.list();
        
		// Print out the result set
		for(UserDetails u : userList2)
			System.out.println(u.getUserName());
        
        // Using FROM and JOIN
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<UserDetails> userRoot = criteriaQuery.from(UserDetails.class);
        Root<Pet> petRoot = criteriaQuery.from(Pet.class);
        criteriaQuery.multiselect(userRoot, petRoot);
        criteriaQuery.where(builder.equal(userRoot.get("pet"), petRoot.get("petId")));

        Query<Object[]> query2=session.createQuery(criteriaQuery);
        List<Object[]> list=query2.getResultList();
        
        for (Object[] objects : list) {
           UserDetails user4=(UserDetails)objects[0];
           Pet pet2=(Pet)objects[1];
           System.out.println("USER="+user4.getUserName()+"\t PET NAME="+ pet2.getPetName());
           
           Iterator<Child> it = user4.getChild().iterator();
           while(it.hasNext()) {
        	   Child c = it.next();
        	   System.out.println("CHILD=" + c.getChildName());
           }
        }
			
		session.getTransaction().commit();
		
		session.close();
		

	}

}
