package edu.supavenir.ormtest.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;

    public String getFirstName() {
	return firstName;
    }

    @Override
    public String toString() {
	return "firstName=" + firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public List<Groupe> getGroups() {
	return groups;
    }

    public void setGroups(List<Groupe> groups) {
	this.groups = groups;
    }

    @ManyToOne
    private Organization organization;
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Groupe> groups;

    public User() {
	groups = new ArrayList<Groupe>();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Organization getOrganization() {
	return organization;
    }

    public void setOrganization(Organization organization) {
	this.organization = organization;
    }

    public List<Groupe> getGroupes() {
	return groups;
    }

    public void setGroupes(List<Groupe> groupes) {
	this.groups = groupes;
    }
}
