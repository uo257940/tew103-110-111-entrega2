function Model(){
//	Lista de pisos.
	this.tbpisos = null;

// 	ID del agente
	this.idAgente=0;
	
	
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
		// Buscamos los datos del alumno cuyo id_alumno sea el mismo que el
		// seleccionado
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
			
			location.href="menu.html";
		}
	}
};

function View(){
	this.list = function (lista) {} // PENDIENTE DE IMPLEMENTAR
	this.listapublica = function (lista){}
	this.loadPisosFromForm = function () {} // PENDIENTE DE IMPLEMENTAR
	this.loadPisosInForm = function (pisos) {} // PENDIENTE DE IMPLEMENTAR
	this.getIdPisos = function(celda) {} // PENDIENTE DE IMPLEMENTAR

	this.list = function(lista) {
		$("#tblList").html("");
		$("#tblList").html( "<thead>" + "<tr>" + "<th></th>"
				+ "<th>ID</th>" + "<th>IDAgente</th>" + "<th>direccion</th>"
				+ "<th>precio</th>" + "<th>ciudad</th>"+"<th>anio</th>"+"<th>estado</th>"+"<th>imagen</th>" + "</tr>"
				+ "</thead>" + "<tbody>" + "</tbody>");
		for ( var i in lista) {
			var pisos = lista[i];
			$("#tblList tbody").append("<tr> <td>"
					+ "<img src='icons/edit.png' class='btnEdit'/>"
					+ "<img src='icons/delete.png' class='btnDelete'/> </td>"
					+ "<td>" + pisos.ID + "</td>" + "<td>" + pisos.IDAgente + "</td>"
					+ "<td>" + pisos.direccion + "</td>" + "<td>" + pisos.precio + "</td>"
					+ "<td>" + pisos.ciudad + "<td>" + pisos.anio + "<td>" + pisos.estado+"</td>"+"<td>"+pisos.imagen+ "</td></tr>");
		
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

	this.loadPisosFromForm = function() {
		// Cogemos el pisos nuevo del formulario.
		var pisos = {
				ID : $("#ID").val(),
				IDAgente : $("#IDAgente").val(),
				direccion : $("#direccion").val(),
				precio : $("#precio").val(),
				ciudad : $("#ciudad").val(),
				anio : $("#anio").val(),
				estado : $("#estado").val(),
				imagen : $("#imagen").val()

		};
		return pisos;
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
	
	
	
	this.listaprivada = function(listaPrivada) {
		$("#tblListprivada").html("");
		$("#tblListprivada").html( "<thead>" + "<tr>" + "<th></th>"
				+ "<th>ID</th>" + "<th>IDAgente</th>" + "<th>direccion</th>"
				+ "<th>precio</th>" + "<th>ciudad</th>"+"<th>anio</th>"+"<th>estado</th>" +"<th>imagen</th>"+"</tr>"
				+ "</thead>" + "<tbody>" + "</tbody>");
		for ( var i in listaPrivada) {
			var pisos = listaPrivada[i];
			$("#tblListprivada tbody").append("<tr> <td>"
					+ "<td>" + pisos.ID + "</td>" + "<td>" + pisos.IDAgente + "</td>"
					+ "<td>" + pisos.direccion + "</td>" + "<td>" + pisos.precio + "</td>"
					+ "<td class=\"ciudad\">" + pisos.ciudad + "<td>" + pisos.anio + "<td>" + pisos.estado+"</td>" +"</td></tr>");
		}
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
	
	
	//Login.html al puslar el boton de registrarse
	$("#login").bind("submit",
			function(event) {
		var login=$("#usernamelogin").val();
		var pass=$("#passwdlogin").val();
		var usuariocorrecto = that.model.login(login,pass);	
	});
	
	 $('#filtro').on("keyup",
			 function(event) { 
	        $("#tblListpublica td.ciudad:contains('" + $(this).val() + "')").parent().show();
	        $("#tblListpublica td.ciudad:not(:contains('" + $(this).val() + "'))").parent().hide();
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