package edu.supavenir.ormtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.supavenir.ormtest.repositories.OrgaRepository;
import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;

@Controller
@RequestMapping("/td3")
public class td3Controller {
    @Autowired
    private VueJS vue;

    @Autowired
    private OrgaRepository orgaRepository;

    @ModelAttribute(name = "vue")
    private VueJS getVue() {
	return this.vue;
    }

    @GetMapping()
    public String indexAction() {
	vue.addData("message", "hello world!");
	vue.addData("orgas", orgaRepository.findAll());
	vue.addDataRaw("header", "[test]");
	vue.addMethod("remove",
		"let self=this;" + Http.delete("'/rest/orga/'+orga.id", JsArray.remove("self.orgas", "orga")), "orga");
	return "td3";
    }
}
