package edu.supavenir.ormtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.supavenir.ormtest.models.Organization;

@RestController
@RequestMapping("/rest/orga")
public class RestOrganizationController extends AbstractRestController<Organization> {

}
