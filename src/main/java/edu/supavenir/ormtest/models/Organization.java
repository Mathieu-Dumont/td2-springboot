package edu.supavenir.ormtest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String domain;
    private String aliases;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Groupe> groups;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<User> users;

    public Organization() {
	groups = new ArrayList<Groupe>();
	users = new ArrayList<User>();
    }

    public List<Groupe> getGroups() {
	return groups;
    }

    public void setGroups(List<Groupe> groups) {
	this.groups = groups;
    }

    public List<User> getUsers() {
	return users;
    }

    public void setUsers(List<User> users) {
	this.users = users;
    }

    // GETTERS && SETTERS
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDomain() {
	return domain;
    }

    public void setDomain(String domain) {
	this.domain = domain;
    }

    public String getAliases() {
	return aliases;
    }

    public void setAliases(String aliases) {
	this.aliases = aliases;
    }

}
