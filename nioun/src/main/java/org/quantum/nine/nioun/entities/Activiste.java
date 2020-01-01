package org.quantum.nine.nioun.entities;

import javax.persistence.Entity;

@Entity
public class Activiste extends AbstractEntity {
	
	private String nom ; 
	private String prenom ;
	private String addresse ;
	private String numtel ;
	private String mail ;
	private String organisation ;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	@Override
	public String toString() {
		return "Activiste [nom=" + nom + ", prenom=" + prenom + ", addresse=" + addresse + ", numtel=" + numtel
				+ ", mail=" + mail + ", organisation=" + organisation + "]";
	}
	
	

}
