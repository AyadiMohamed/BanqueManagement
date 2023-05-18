package org.bm.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Colonne qui fait la différence entre les différents types de comptes
// Le nom par defaut est type si on ne le specifie pas, type par defaut String, length par defaut 255
@DiscriminatorColumn(name = "ACCOUNT_TYPE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Account implements Serializable{
	@Id
	private String accountCode;
	private Date creationDate;
	private double balance;
	// "Cus_Code" c'est la clé etrangére
	@ManyToOne
	@JoinColumn(name = "Cus_Code")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "Emp_Code")
	private Employee employee;
	@OneToMany(mappedBy = "account")
	private Collection<Operation> operations;
	
	public Account() {
		super();
	}

	public Account(String accountCode, Date creationDate, double balance) {
		super();
		this.accountCode = accountCode;
		this.creationDate = creationDate;
		this.balance = balance;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
}
