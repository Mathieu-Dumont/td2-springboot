package edu.supavenir.ormtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.supavenir.ormtest.models.User;

@RestController
@RequestMapping("/rest/users")
public class RestUserController extends AbstractRestController<User> {

}
