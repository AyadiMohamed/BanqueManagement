package org.bm.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerCode;
	private String customerName;
	
	// mappedBy : the declared object in the account class, to define the relationship
	// Lazy : c-a-d seulement les données relatives à l'entité seront automatiquement 
	// chargés par le framework de mapping objet relationnel, donc les comptes ne seront chargés qu'en cas de besoin
	// Lazy est le type par defaut en cas de ne pas le définir
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY )
	private Collection<Account> accounts;
	
	public Customer() {
		super();
	}
	
	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public Long getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Long customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
}
