package edu.supavenir.ormtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.supavenir.ormtest.models.Groupe;
import edu.supavenir.ormtest.models.Organization;
import edu.supavenir.ormtest.models.User;
import edu.supavenir.ormtest.repositories.OrgaRepository;
import edu.supavenir.ormtest.tricks.CssMessage;

@Controller
@RequestMapping("/orga/")
public class OrgaController {

    @Autowired
    private OrgaRepository repository;

    @GetMapping("/")
    public String index(Model model) {
	List<Organization> organizations = repository.findAll();
	model.addAttribute("organizations", organizations);
	return "index";
    }

    @GetMapping("add")
    public String formAction() {
	return "formOrga";
    }

    @PostMapping("add")
    public @ResponseBody String addAction(Organization orga) {
	Groupe group = new Groupe();
	group.setName("etudiant");
	group.setOrganization(orga);
	orga.getGroups().add(group);
	User thomas = new User();
	thomas.setFirstName("thomas");
	thomas.setOrganization(orga);
	orga.getUsers().add(thomas);
	repository.saveAndFlush(orga);
	return "orga ajouté : " + orga;

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model) {
	Organization bdOrga = repository.getById(id);
	model.addAttribute("organizations", bdOrga);
	return "editOrg";
    }

    @PostMapping("edit/{id}")
    public RedirectView edit(@PathVariable int id, Organization orga) {
	Organization bdOrga = repository.getById(id);
	bdOrga.setName(orga.getName());
	bdOrga.setDomain(orga.getDomain());
	bdOrga.setAliases(orga.getAliases());
	repository.saveAndFlush(bdOrga);
	return new RedirectView("/orga/");
    }

    @GetMapping("delete/{id}")
    public RedirectView delete(@PathVariable int id, Model model, RedirectAttributes attrs) {
	Organization bdorg = repository.getById(id);
	model.addAttribute("organizations", bdorg);
	CssMessage Suppresion = new CssMessage("SuccesFull", "error", "exclamation circle");
	attrs.addFlashAttribute("msg", Suppresion);
	repository.deleteById(id);
	return new RedirectView("/orga/");
    }

    @GetMapping("display/{id}")
    public String display(@PathVariable int id, Model model) {
	Organization bdOrga = repository.getById(id);
	model.addAttribute("organizations", bdOrga);
	return "displayOrg";
    }

    // @GetMapping("delete")
    // public RedirectView deleteAction() {

    // return index;
    // }
}