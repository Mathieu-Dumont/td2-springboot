package edu.supavenir.ormtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.supavenir.ormtest.models.Organization;
import edu.supavenir.ormtest.repositories.OrgaRepository;
import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import io.github.jeemv.springboot.vuejs.utilities.JsArray;

@Controller
@RequestMapping("/org")
public class OrganizationController {
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
	vue.addDataRaw("headers",
		"[{text:'ID', value:'id'},{text:'Name', value:'name'},{text:'Aliases', value:'aliases'},{text:'Domain', value:'domain'}]");
	vue.addData("dialog", false);
	vue.addData("dialogDelete", false);
	vue.addData("editedIndex", -1);
	vue.addData("editedItem", new Organization());
	vue.addMethod("close", "this.dialog=false;this.editedIndex === -1;");

	vue.addMethod("save", "if (this.editedIndex > -1) {\r\n"
		+ "          Object.assign(this.orgas[this.editedIndex], this.editedItem)\r\n" + "        } else {\r\n"
		+ "          this.orgas.push(this.editedItem)\r\n" + "        }\r\n" + "        this.close()");

	vue.addMethod("closeDelete",
		"this.dialogDelete = false\r\n" + "        this.$nextTick(() => {\r\n"
			+ "          this.editedItem = Object.assign({}, this.defaultItem)\r\n"
			+ "          this.editedIndex = -1\r\n" + "        })");

	vue.addMethod("deleteItemConfirm", "this.orgas.splice(this.editedIndex, 1)\r\n" + "        this.closeDelete()");
	vue.addComputed("formTitle", "return this.editedIndex === -1 ? 'Nouvelle organization' : 'Modification'");
	vue.addMethod("remove",
		"let self=this;" + Http.delete("'/rest/orga/'+orga.id", JsArray.remove("self.orgas", "orga")), "orga");
	return "td3";
    }
}
