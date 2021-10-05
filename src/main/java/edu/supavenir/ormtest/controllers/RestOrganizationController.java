package edu.supavenir.ormtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.supavenir.ormtest.models.Organization;
import edu.supavenir.ormtest.repositories.OrgaRepository;

@RestController
@RequestMapping("/rest/orga")
public class RestOrganizationController {
    @Autowired
    private OrgaRepository orgaRepo;

    @GetMapping()
    public List<Organization> indexAction() {
	return orgaRepo.findAll();
    }
}
