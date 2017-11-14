package org.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;

@Entity
@NamedQuery(name="UserDetais.byId", query="from UserDetails where userId=?")
@Table(name="USER_DETAILS") // Defines the table name for insertion/update
@DynamicUpdate // Only perform update if there were any changes to the object
public class UserDetails {
	@Id @GeneratedValue // Primary key that is auto generated
	private int userId;
	
	@Column(name="user_name") // Allows for column manipulation
	private String userName;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST) // PERSIST-When a new user is saved, automatically save the Child
	@NotFound(action=NotFoundAction.IGNORE) // If a Job record is not found, do not throw and exception
	//@JoinTable(name="child", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="child_id"))
	//@JoinColumn(name="user_id")
	private Collection<Child> child = new ArrayList<Child>();
	
	@ManyToMany
	@NotFound(action=NotFoundAction.IGNORE) // If a Job record is not found, do not throw and exception
	private Collection<Job> job = new ArrayList<Job>();
	
	@OneToOne // Allows for a 1-1 mapping to the vehicle table
	@NotFound(action=NotFoundAction.IGNORE) // If a Job record is not found, do not throw and exception
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@OneToOne // Allows for a 1-1 mapping to the vehicle table
	@NotFound(action=NotFoundAction.IGNORE) // If a Job record is not found, do not throw and exception
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	@Temporal(TemporalType.DATE) // Allows for the date type to be refined
	private Date joinedDate;
	
	@ElementCollection(fetch=FetchType.EAGER) // Allows for collection insertion.  Get all associated joined records (EGAR)
	@JoinTable(name="user_address",  // Changes the joined table name
			joinColumns=@JoinColumn(name="user_id")) // Changes the foreign key column name to the user_details table
	
	// Create index for the joined table user_address named address_id of type long
	// @GenericGenerator(name="sequence_name", strategy="sequence")
	// @CollectionId(columns = { @Column(name="address_id") }, generator = "sequence_name", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	//@Lob // Changes type to CLOB
	private String description;
	
	@Transient // Allows this attribute not to be stored in the DB
	private boolean optional;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Collection<Child> getChild() {
		return child;
	}
	public void setChild(Collection<Child> child) {
		this.child = child;
	}
	public Collection<Job> getJob() {
		return job;
	}
	public void setJob(Collection<Job> job) {
		this.job = job;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
		
}
