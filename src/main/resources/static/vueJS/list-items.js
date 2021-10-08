//Script generated with VueComponent at Fri Oct 08 10:25:25 CEST 2021
Vue.component('list-items',{
	"props":{
		name:{
			"default":"name"
			}
		,list:{
			"default":[]
			}
		}
	,"template":"<div><h1>Organization</h1>        <ul>            <li v-for=\"item in list\">                <slot v-bind:item=\"item\"></slot>                <!-- <v-btn fab x-small @click=\"remove(orga)\"><v-icon x-small dark>mdi-minus</v-icon></v-btn> -->            </li>        </ul>        </div>"
	}
);