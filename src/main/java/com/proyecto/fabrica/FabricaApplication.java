package com.proyecto.fabrica;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class FabricaApplication {

	@RequestMapping("/restpedidos/")
	public String index1() {
		return "[    {        \"url\": \"http://localhost:8080/restpedidos/21/\",        \"Codigo_Pedido\": 68,        \"Fecha_Pedido\": \"2020-05-28\",        \"Fecha_Recepcion\": null,        \"Total\": null,        \"Estado\": \"\",        \"Codigo_Fabrica\": null    },    {        \"url\": \"http://localhost:8080/restpedidos/22/\",        \"Codigo_Pedido\": 67,        \"Fecha_Pedido\": \"2020-05-28\",        \"Fecha_Recepcion\": null,        \"Total\": null,        \"Estado\": \"enviado\",        \"Codigo_Fabrica\": null    }]";
	}
        @RequestMapping("/restpedidos/21/")
	public String index2() {
		return "[    {        \"url\": \"http://localhost:8080/restdetalle/21/\",        \"Productos\": \"Baterias\",        \"Cantidad\": 2,        \"Sub_Total\": \"15.00\",        \"Fabricante\": \"http://192.168.1.28:8000/restfabricas/81/\",        \"Pedidofk\": \"http://192.168.1.28:8000/restpedidos/21/\"    },    {        \"url\": \"http://192.168.1.28:8000/restdetalle/22/\",        \"Productos\": \"Llantas\",        \"Cantidad\": 4,        \"Sub_Total\": \"15.00\",        \"Fabricante\": \"http://192.168.1.28:8000/restfabricas/81/\",        \"Pedidofk\": \"http://192.168.1.28:8000/restpedidos/21/\"    }]";
	}
        @RequestMapping("/restpedidos/22")
	public String index3() {
		return "[    {        \"url\": \"http://localhost:8080/restdetalle/22/\",        \"Productos\": \"Baterias\",        \"Cantidad\": 1,        \"Sub_Total\": \"15.00\",        \"Fabricante\": \"http://192.168.1.28:8000/restfabricas/81/\",        \"Pedidofk\": \"http://192.168.1.28:8000/restpedidos/21/\"    }]";
	}
        @RequestMapping("/restdetalle/")
	public String index4() {
		return "[    {        \"url\": \"http://192.168.1.20:8000/restdetalle/83/\",        \"Productos\": \"5e9d03d51e5c1f3b6fe51489\",        \"Cantidad\": 1,        \"Sub_Total\": \"0.00\",        \"Fabricante\": \"http://192.168.1.20:8000/restfabricas/101/\",        \"Pedidofk\": \"http://192.168.1.20:8000/restpedidos/67/\"    },    {        \"url\": \"http://192.168.1.20:8000/restdetalle/81/\",        \"Productos\": \"5e9d03d51e5c1f3b6fe51489\",        \"Cantidad\": 1,        \"Sub_Total\": \"0.00\",        \"Fabricante\": \"http://192.168.1.20:8000/restfabricas/101/\",        \"Pedidofk\": \"http://192.168.1.20:8000/restpedidos/68/\"    },    {        \"url\": \"http://192.168.1.20:8000/restdetalle/82/\",        \"Productos\": \"Baterias\",        \"Cantidad\": 1,        \"Sub_Total\": \"0.00\",        \"Fabricante\": \"http://192.168.1.20:8000/restfabricas/101/\",        \"Pedidofk\": \"http://192.168.1.20:8000/restpedidos/67/\"    }]";
	}
        

}