package edu.supavenir.ormtest.components;

import java.io.IOException;

import io.github.jeemv.springboot.vuejs.components.VueComponent;

public class listCompnentCreation {

    public static void main(String[] args) throws IOException {
	VueComponent list = new VueComponent("list-items");
	list.setDefaultTemplateFile();
	list.addProp("name", "name");
	list.addPropRaw("list", "[]");
	// list.createFile(false);
	VueComponent.globalJs("button-msg.js", "list-item.js");

    }

}
