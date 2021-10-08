//Script generated with VueComponent at Fri Oct 08 09:16:53 CEST 2021
Vue.component('button-msg',{
	"props":{
		type:{
			"default":"success"
			}
		}
	,"data":function() {
		 return {
			"message":"Cliquez sur le bouton ..."
			}
		;
		}
	,"template":"<div>    <v-btn @click='message=\"Hello\"'>Afficher Message</v-btn>    <v-alert :type=\"type\">        {{message}}    </v-alert></div>"
	}
);