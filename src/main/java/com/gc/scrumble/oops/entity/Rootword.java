package com.gc.scrumble.oops.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rootwords")
public class Rootword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wordid;
	private String wordname;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "scores", joinColumns = @JoinColumn(name = "wordid"), inverseJoinColumns = @JoinColumn(name = "userid"))
	private Score score;

	public Rootword() {
	}

	public Rootword(Long wordid, String wordname) {
		this.wordid = wordid;
		this.wordname = wordname;
	}

	public Rootword(String wordname) {
		this.wordname = wordname;
	}

	public Long getWordid() {
		return wordid;
	}

	public void setWordid(Long wordid) {
		this.wordid = wordid;
	}

	public String getWordname() {
		return wordname;
	}

	public void setWordname(String wordname) {
		this.wordname = wordname;
	}

	@Override
	public String toString() {
		return "Rootword [wordid=" + wordid + ", wordname=" + wordname + "]";
	}
}
