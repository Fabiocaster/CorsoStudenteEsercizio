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
@Table(name= "CORSO")
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descrizione;
	private int crediti;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "corso_studente",
		joinColumns = @JoinColumn(name = "corso_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "studente_id", referencedColumnName = "id"))
	private Set<Studente> studenti;
	
	public Corso() {
		super();
	}

	public Corso(int id, String nome, String descrizione, int crediti) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.crediti = crediti;
	}

	public Corso(int id, String nome, String descrizione, int crediti, Set<Studente> studenti) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.crediti = crediti;
		this.studenti = studenti;
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

	public String getDescrizione() {
		return descrizione;
	}

	public String setDescrizione(String descrizione) {
		return this.descrizione = descrizione;
	}

	public int getCrediti() {
		return crediti;
	}

	public int setCrediti(int crediti) {
		return this.crediti = crediti;
	}

	public void setAttributes(Corso corso) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nCosa vuoi modificare? (Inserisci il valore numerico) \n1)Nome\n2)Descrizione\n3)Crediti\n4)Tutti i campi\nScegli: ");
		int scelta = Integer.parseInt(sc.nextLine());
	
		if (scelta == 1) {
			System.out.println("Inserisci nome: ");
			this.nome = corso.setNome(sc.nextLine());
			
		}
		if (scelta == 2) {
			System.out.println("Inserisci descrizione: ");
			this.descrizione = corso.setDescrizione(sc.nextLine());
			
		}
		if (scelta == 3) {
			System.out.println("Inserisci crediti: ");
			int cfu=Integer.parseInt(sc.nextLine());
			this.crediti = corso.setCrediti(cfu);
			
		}
		if(scelta==4) {
			System.out.println("Inserisci nome: ");
			this.nome = corso.setNome(sc.nextLine());
			System.out.println("Inserisci descrizione: ");
			this.descrizione = corso.setDescrizione(sc.nextLine());
			System.out.println("Inserisci crediti: ");
			int cfu=Integer.parseInt(sc.nextLine());
			this.crediti = corso.setCrediti(cfu);
			
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(crediti, descrizione, id, nome, studenti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return crediti == other.crediti && Objects.equals(descrizione, other.descrizione) && id == other.id
				&& Objects.equals(nome, other.nome) && Objects.equals(studenti, other.studenti);
	}

	public void unsubscribeStudente(Studente byId) {
		this.studenti.remove(byId);
		
	}
}
