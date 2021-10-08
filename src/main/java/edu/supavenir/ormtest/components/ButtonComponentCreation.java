package edu.supavenir.ormtest.components;

import java.io.IOException;

import io.github.jeemv.springboot.vuejs.components.VueComponent;

public class ButtonComponentCreation {

    public static void main(String[] args) throws IOException {
	VueComponent button = new VueComponent("button-msg");
	button.addData("message", "Cliquez sur le bouton ...");
	button.addProp("type", "success");
	button.setDefaultTemplateFile();
	button.createFile(false);
    }

}
