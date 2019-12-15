
function Model(){
//	Lista de pisos.
	this.tbpisos = null;

	this.tbpisosAgente=null;
// 	ID del agente
	this.idAgente=-1;
	
	
//	Carga los datos del servicio sobreescribiendo el dato this.tbpisos.
	this.load = function() {
		this.tbpisos = PisosServicesRs.Pisos();

	}
//	Llamamos al servicio de alta de pisos
	this.add = function(pisos) {
//		Llamamos al servicio de alta de pisos
		PisosServicesRs.savePisos({
			$entity : pisos,
			$contentType : "application/json"
		});
//		Recargamos la lista de pisos.
		this.load();
	}
//	Actualización de un pisos existente: PENDIENTE DE IMPLEMENTAR
	this.edit = function(pisos) {
		PisosServicesRs.updatePisos({
			$entity : pisos,	
			$contentType: "application/json"
		});
		this.load();

	}
//	Eliminación un pisos exist	ente
	this.remove = function(id_pisos) {
		PisosServicesRs.deletePisos({
			id : id_pisos
		});
//		Recargamos la lista de pisos.
		this.load();
	}

	this.find = function(id_pisos) {
		function checkPisos(obj) {
			return obj.ID == id_pisos;
		}
		var pisos = this.tbpisos.find(checkPisos);
		return pisos;
	} 
	
	
	
	
	//Comprobamos si el agente esta en la BD
	this.login = function(usa,contr){
		idAgente=AgentesServicesRs.AgenteCorrec({
			us : usa,
			pass : contr
		});
		if(idAgente==-1){
			alert("Usuario y contraseña incorrectos");
		}
		else{

			window.localStorage.setItem("ID",idAgente);
			location.href="menu.html";
		}
	}
	
	//Cerramos la sesion
	this.logout = function(){
		window.localStorage.removeItem("ID");
		location.href="index.html";
	}
		
};

function View(){
	this.list = function (lista) {} // PENDIENTE DE IMPLEMENTAR
	this.listapublica = function (lista){}
	this.loadPisosFromForm = function () {} // PENDIENTE DE IMPLEMENTAR
	this.loadPisosInForm = function (pisos) {} // PENDIENTE DE IMPLEMENTAR
	this.getIdPisos = function(celda) {} // PENDIENTE DE IMPLEMENTAR
	this.listaprivada = function(lista){}


	this.list = function(lista) {
		$("#tblList").html("");
		$("#tblList").html( "<thead>" + "<tr>" + "<th></th>"
				+ "<th>ID</th>" + "<th>IDAgente</th>" + "<th>direccion</th>"
				+ "<th>precio</th>" + "<th>ciudad</th>"+"<th>anio</th>"+"<th>estado</th>" + "</tr>"
				+ "</thead>" + "<tbody>" + "</tbody>");
		for ( var i in lista) {
			var pisos = lista[i];
			$("#tblList tbody").append("<tr> <td>"
					+ "<img src='icons/edit.png' class='btnEdit'/>"
					+ "<img src='icons/delete.png' class='btnDelete'/> </td>"
					+ "<td>" + pisos.ID + "</td>" + "<td>" + pisos.IDAgente + "</td>"
					+ "<td>" + pisos.direccion + "</td>" + "<td>" + pisos.precio + "</td>"
					+ "<td>" + pisos.ciudad + "<td>" + pisos.anio + "<td>" + pisos.estado + "</td></tr>");
		}
	}
	
	this.listapublica = function(lista) {
		$("#tblListpublica").html("");
		$("#tblListpublica").html( "<thead>" + "<tr>" + "<th></th>"
				+ "<th class=\"ID\">ID</th>" + "<th class=\"IDAgente\">IDAgente</th>" + "<th class=\"direccion\">direccion</th>"
				+ "<th class=\"precio\">precio</th>" + "<th class=\"ciudad\">ciudad</th>"+"<th class=\"anio\">anio</th>"+"<th class=\"estado\">estado</th>"+ "<th class=\"imagen\">imagen</th>" + "</tr>"
				+ "</thead>" + "<tbody id=\"busqueda\" >" + "</tbody>");
		for ( var i in lista) {
			var pisos = lista[i];
			$("#tblListpublica tbody").append("<tr> <td>"
					+ "<td>" + pisos.ID + "</td>" + "<td>" + pisos.IDAgente + "</td>"
					+ "<td>" + pisos.direccion + "</td>" + "<td>" + pisos.precio + "</td>"
					+ "<td class=\"ciudad\">"+ pisos.ciudad +"</td>"
					+ "<td>" + pisos.anio + "</td>"
					+ "<td>" +pisos.estado + "</td>"+"<td> "+pisos.imagen + "</td>"+"</td></tr>");
		}

	this.loadPisosFromForm = function() {
		// Cogemos el pisos nuevo del formulario.
		var pisos = {
				ID : $("#ID").val(),
				IDAgente : $("#IDAgente").val(),
				direccion : $("#direccion").val(),
				precio : $("#precio").val(),
				ciudad : $("#ciudad").val(),
				anio : $("#anio").val(),
				estado : $("#estado").val()
		};
		return pisos;
	}
	
	
	this.loadPisosFromFormAlta = function() {
		// Cogemos el pisos nuevo del formulario.
		var pisos = {
				
				direccion : $("#direccion").val(),
				precio : $("#precio").val(),
				ciudad : $("#ciudad").val(),
				anio : $("#anio").val(),
				estado : $("#estado").val(),
				imagen : $("#imagen").val(),
		};
		return pisos;
	}
	
	 $("table").tablesorter({
		    theme : 'blue',

		    headers: {
		      // disable sorting of the first & second column - before we would have to had made two entries
		      // note that "first-name" is a class on the span INSIDE the first column th cell
		      '.ID, .IDAgente, .direccion, .ciudad, .anio, .estado, .imagen' : {
		        // disable it by setting the property sorter to false
		        sorter: false
		      }
		    }
		  });
	 
	 
}
	
	
	

	this.loadPisosInForm = function(pisos) {
		// Pintamos los datos pisos sobre el formularios de alta/edición
		$("#ID").val(pisos.ID);
		$("#IDAgente").val(pisos.IDAgente);
		$("#direccion").val(pisos.direccion);
		$("#precio").val(pisos.precio);
		$("#ciudad").val(pisos.ciudad);
		$("#anio").val(pisos.anio);
		$("#estado").val(pisos.estado);
		$("#imagen").val(pisos.imagen);
		$("#ID").focus(); // Ponemos el foco en el campo Nombre.
	}

	this.getIdPisos = function(celda) {
		// Accedemos a la fila que está por encima de esta celda
		// (closest('tr'))y despues obtenemos todas las celdas de esa fila
		// (find('tr')) y
		// nos quedamos con la segunda (get(1)) que es la contiene el "id" del
		// pisos.
		var id_pisos = parseInt(celda.closest('tr').find('td').get(1).innerHTML);
		return id_pisos;
	}
	
	
	
	this.listaprivada = function(lista) {
			$("#tblListprivada").html("");
			$("#tblListprivada").html( "<thead>" + "<tr>" + "<th></th>"
					+ "<th>ID</th>" + "<th>IDAgente</th>" + "<th>direccion</th>"
					+ "<th>precio</th>" + "<th>ciudad</th>"+"<th>anio</th>"+"<th>estado</th>" + "</tr>"
					+ "</thead>" + "<tbody>" + "</tbody>");		
			for ( var i in lista) {
				var pisos = lista[i];
				$("#tblListprivada tbody").append("<tr> <td>"
						+ "<img src='icons/edit.png' class='btnEdit'/>"
						+ "<img src='icons/delete.png' class='btnDelete'/> </td>"
						+ "<td>" + pisos.ID + "</td>" + "<td>" + pisos.IDAgente + "</td>"
						+ "<td>" + pisos.direccion + "</td>" + "<td>" + pisos.precio + "</td>"
						+ "<td>" + pisos.ciudad + "<td>" + pisos.anio + "<td>" + pisos.estado + "</td></tr>");
			}
		}
	
	
	this.loadPisosInFormEdit = function(pisos) {
		// Pintamos los datos pisos sobre el formularios de alta/edición

		$("#direccion").val(pisos.direccion);
		$("#precio").val(pisos.precio);
		$("#ciudad").val(pisos.ciudad);
		$("#anio").val(pisos.anio);
		$("#estado").val(pisos.estado);
		$("#imagen").val(pisos.imagen);

	}
	

	
};


function Controller(varmodel, varview) {
	// Definimos una copia de this para evitar el conflicto con el this (del
	// objeto que recibe el evento)
	// en los manejadores de eventos
	var that = this;
	// referencia al modelo
	this.model = varmodel;
	// refefencia a la vista
	this.view = varview;
	// Funcion de inicialización para cargar modelo y vista, definición de manejadores
	this.init = function() {
		// Cargamos la lista de Pisos del servicio
		this.model.load();
		// Repintamos la lista de Pisos.
		this.view.list(this.model.tbpisos);
		localStorage.setItem("tbPisos", this.model.tbpisos)
		this.view.listapublica(this.model.tbpisos)
		
		// MANEJADORES DE EVENTOS
	}


//	Manejador del botón submit del formulario de Alta y Edición
	$("#frmCRUDPisos").bind("submit",
//			Método que gestiona el evento de clickar el botón submit del
//			formulario
			function(event) {
//		Si el alumno cargado en el formulario tiene ID se invoca al
//		método de// edición
		// sino se invoca al método de alta.
		pisos = that.view.loadPisosFromForm();
		if ($("#id").val() == "") {
			that.model.add(pisos);
		} else {
			that.model.edit(pisos);
		}
		// Volvemos a listar los Pisos restantes para que aparezca el
		// nuevo
		// Pisos o el editado
		that.view.list(that.model.tbPisos);
	});

//	Manejador del enlace de edición de un alumno en la tabla
	$("#tblList").on("click", ".btnEdit",
//			Método que gestiona el evento de clickar en el evento
			function(event) {
//		Obtenemos el id del alumno seleccionado mediante el icono de
//		edición
		var id_pisos = that.view.getIdPisos($(this));
//		Obtenemos el alumno con el id_alumno
		var pisosedit = that.model.find(id_pisos);
		console.log(pisosedit);
//		Cargamos el formulario con los datos del alumno seleccionado para
//		editar
		that.view.loadPisosInForm(pisosedit);
	});
	
	$("#tblList").on("click", ".btnDelete",
//			Método que gestiona el evento de clickar en el evento
			function(event) {
//		Obtenemos el id del alumno seleccionado mediante el icono de
//		edición
		var id_pisos = that.view.getIdPisos($(this));
//		Obtenemos el alumno con el id_alumno
		var pisosedit = that.model.remove(id_pisos);
//		Cargamos el formulario con los datos del alumno seleccionado para
//		editar
		that.view.list(that.model.tbPisos);
		alert("Eliminado Usuario");
	});
	
	
	
	//Login.html al puslar el boton de registrarse
	$("#login").bind("submit",
			function(event) {
		var login=$("#usernamelogin").val();
		var pass=$("#passwdlogin").val();
		that.model.login(login,pass);
		
	});
	
	
	$("body").on('mouseover','#tblListpublica tr' , function(){
		//acceder al elemento 8 de cada cell
		 path=this.cells.item(8).innerText;
		 var canvas = document.getElementById("ventana");
         var ctx = canvas.getContext("2d");
 		 var picture = new Image();

		 picture.src="http://localhost:8080/gestioneitorv6_0/images/"+path;	
		 console.log(picture);
		 ctx.drawImage(picture,0,0,picture.width,picture.height,0,0,400,400);
	});
	
	
	 $('#filtro').on("keyup",
			 function(event) { 
	        $("#tblListpublica td.ciudad:contains('" + $(this).val() + "')").parent().show();
	        $("#tblListpublica td.ciudad:not(:contains('" + $(this).val() + "'))").parent().hide();
	    });
	 

	
	
	$("#btnAccederListaPrivada").on("click",
			function (event){
		
		location.href="listaprivada.html";
	});
	
	$("#btnImportarDB, #menuImportarDB").unbind("click").bind("click",
			function (event){
		
		$.ajax({
		url : "http://localhost:8080/gestioneitorv6_0/pisos.json",
		type : "GET",
		dataType : "json",
		// Listado de pisos (función de callback)
		success : function(pisos) {
			//Para acceder a los datos de los pisos se puede recorrer así
			for ( var i in pisos) {//Preparamos el registro de un piso
				var piso = ({
					ID : pisos[i].ID,
					IDAgente : window.localStorage.getItem("ID"),
					precio : pisos[i].Precio,
					direccion: pisos[i].Direccion,
					ciudad: pisos[i].Ciudad,
					anio: pisos[i].Anyo,
					estado: pisos[i].Estado,
					imagen: "foto"+pisos[i].ID+".jpg"
				});
			
				if(that.model.find(piso.ID)!= null){
					that.model.edit(piso);
				}
				else that.model.add(piso);			

			}
			
		alert("!Importación realizada con exito!");
		} //Cierre de la función de callback
		
		
	}); //Cierre del parámetro de .ajax
	});
	
	$("#btnLogout, #menuLogout").on("click",
			function (event){
			that.model.logout();
	});
	
	
	$("#tblListprivada").on("click", ".btnDelete",

			function(event) {

		var id_pisos = that.view.getIdPisos($(this));
		var pisosedit = that.model.remove(id_pisos);
		that.view.listaprivada(that.model.tbPisos);
		location.href="listaprivada.html";
	});
	
	
	$("#frmAltaPisos").bind("submit",
			function(event) {

		var pisos = that.view.loadPisosFromFormAlta();
		pisos.IDAgente = window.localStorage.getItem("ID");
		that.model.add(pisos);
		alert("Piso registrado correctamente");
		location.href="listaprivada.html";

	});
	
	$("#btnAtras").on("click",
			function (event){
		
		location.href="listaprivada.html";
	});
	
	
	$("#tblListprivada").on("click", ".btnEdit",

			function(event) {

		var id_pisos = that.view.getIdPisos($(this));
		window.localStorage.setItem("IdPisoEditar",id_pisos);
		
		location.href="edicionPiso.html";
	});

	$("#frmEdicionPisos").bind("submit",
			function(event) {

		var pisos = that.view.loadPisosFromFormAlta();
		pisos.IDAgente = window.localStorage.getItem("ID");
		pisos.ID = window.localStorage.getItem("IdPisoEditar");
		that.model.edit(pisos);
		alert("Piso actualizado correctamente");
		location.href="listaprivada.html";

	});
	
};

$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	// Creamos la vista que incluye acceso al modelo.
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	// Iniciamos la aplicación
	control.init();
});





