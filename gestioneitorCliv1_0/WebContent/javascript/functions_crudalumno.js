function Model(){
//	Lista de pisos.
	this.tbpisos = null;

//	Carga los datos del servicio sobreescribiendo el dato this.tbpisos.
	this.load = function() {
		this.tbpisos = PisosServicesRs.Pisos();
	}
//	Llamamos al servicio de alta de pisos
	this.add = function(pisos) {
//		Llamamos al servicio de alta de pisos
		PisosServicesRs.savepisos({
			$entity : pisos,
			$contentType : "application/json"
		});
//		Recargamos la lista de pisos.
		this.load();
	}
//	Actualización de un pisos existente: PENDIENTE DE IMPLEMENTAR
	this.edit = function(pisos) {
		PisosServicesRs.updatepisos({
			$entity : pisos,	
			$contentType: "application/json"
		});
		this.load();

	}
//	Eliminación un pisos exist	ente
	this.remove = function(id_pisos) {
//		Llamamos al servicio de borrado de pisos
		PisosServicesRs.deletepisos({
			id : id_pisos
		});
//		Recargamos la lista de pisos.
		this.load();
	}
	this.find = function(id_pisos) {
		function checkpisos(obj) {
			return obj.id == id_pisos;
		}
//		Buscamos los datos del pisos cuyo id_pisos sea el mismo que el
//		seleccionado
		var pisos = this.tbpisos.find(checkpisos);
		return pisos;
	}
};

function View(){
	this.list = function (lista) {} // PENDIENTE DE IMPLEMENTAR
	this.loadpisosFromForm = function () {} // PENDIENTE DE IMPLEMENTAR
	this.loadpisosInForm = function (pisos) {} // PENDIENTE DE IMPLEMENTAR
	this.getIdpisos = function(celda) {} // PENDIENTE DE IMPLEMENTAR


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

	this.loadpisosFromForm = function() {
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

	this.loadpisosInForm = function(pisos) {
		// Pintamos los datos pisos sobre el formularios de alta/edición
		$("#ID").val(pisos.ID);
		$("#IDAgente").val(pisos.IDAgente);
		$("#direccion").val(pisos.direccion);
		$("#precio").val(pisos.precio);
		$("#ciudad").val(pisos.ciudad);
		$("#anio").val(pisos.anio);
		$("#estado").val(pisos.estado);

		$("#ID").focus(); // Ponemos el foco en el campo Nombre.
	}

	this.getIdpisos = function(celda) {
		// Accedemos a la fila que está por encima de esta celda
		// (closest('tr'))y despues obtenemos todas las celdas de esa fila
		// (find('tr')) y
		// nos quedamos con la segunda (get(1)) que es la contiene el "id" del
		// pisos.
		var id_pisos = parseInt(celda.closest('tr').find('td').get(1).innerHTML);
		return id_pisos;
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
		this.view.list(this.model.tbPisos);
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
		alumno = that.view.loadPisosFromForm();
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
		var id_alumno = that.view.getIdAlumno($(this));
//		Obtenemos el alumno con el id_alumno
		var alumno = that.model.find(id_alumno);
//		Cargamos el formulario con los datos del alumno seleccionado para
//		editar
		that.view.loadAlumnoInForm(alumno);
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




