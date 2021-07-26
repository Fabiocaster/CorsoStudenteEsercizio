package com.s2e.app.model;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTE")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cognome;
	private String mail;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "corso_student", joinColumns = @JoinColumn(name = "studente_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "corso_id", referencedColumnName = "id"))
	private Set<Corso> corsi;

	public Studente() {
		super();
	}

	public Studente(int id, String nome, String cognome, String mail) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
	}

	public Studente(int id, String nome, String cognome, String mail, Set<Corso> corsi) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.corsi = corsi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		return this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String setCognome(String cognome) {
		return this.cognome = cognome;
	}

	public String getMail() {
		return mail;
	}

	public String setMail(String mail) {
		return this.mail = mail;
	}

	public Set<Corso> getCorso() {
		return corsi;
	}

	public void setCorso(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	public void setAttributes(Studente studente) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nCosa vuoi modificare? (Inserisci il valore numerico) \n1)Nome\n2)Cognome\n3)Mail\n4)Tutti i campi\nScegli: ");
		int scelta = Integer.parseInt(sc.nextLine());
	
		if (scelta == 1) {
			System.out.println("Inserisci nome: ");
			this.nome = studente.setNome(sc.nextLine());
			
		}
		if (scelta == 2) {
			System.out.println("Inserisci cognome: ");
			this.cognome = studente.setCognome(sc.nextLine());
			
		}
		if (scelta == 3) {
			System.out.println("Inserisci mail: ");
			this.mail = studente.setMail(sc.nextLine());
			
		}
		if(scelta==4) {
			System.out.println("Inserisci nome: ");
			this.nome = studente.setNome(sc.nextLine());
			System.out.println("Inserisci cognome: ");
			this.cognome = studente.setCognome(sc.nextLine());
			System.out.println("Inserisci mail: ");
			this.mail = studente.setMail(sc.nextLine());
			
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, corsi, id, mail, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(corsi, other.corsi) && id == other.id
				&& Objects.equals(mail, other.mail) && Objects.equals(nome, other.nome);
	}

	public void addCorso(Corso corso) {
		this.corsi.add(corso);
	}

}
