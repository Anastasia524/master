package domain;

import javax.xml.crypto.Data;

public class Author {
	// Идентификатор 
	private Long id;
	
	private String firstname;
	private String lastname;
	private String email;
	private Integer phone;
	private Data dataregistration;
	public Author() {
	}
	public Author(String firstname) {
	this.firstname = firstname;
	}
	
	public Author(Long id, String firstname, String lastname, String email,
			Integer phone, Data dataregistration) {
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.dataregistration = dataregistration;
	}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {

	this.id = id;
	}
	public String getFirstName() {
	return firstname;
	}
	public void setFirstName(String firstname) {
	this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
		}
		public void setLastNameName(String lastname) {
		this.lastname = lastname;
		}
		
		public String getEmail() {
			return email;
			}
			public void setEmail(String email) {
			this.email = email;
			}
			
			public Integer getPhone() {
				return phone;
				}
				public void setPhone(Integer phone) {
				this.phone = phone;
				}
				
				public Data getDataRegistration() {
					return dataregistration;
					}
					public void setDataRegistration(Data dataregistration) {
					this.dataregistration = dataregistration;
					}
	@Override
	public String toString() {
	return "Author {" + "Id = " + id + ", FirstName = " + firstname+", " + "LastName = " + lastname + ", " + "Email = " + email + ", " + "Phone = " + phone + ", " + "DataRegistration = " + dataregistration +  "}";
	}
	}