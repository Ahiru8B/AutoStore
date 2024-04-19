$(document).ready(() => {

	$("body").on("click", "#newPerson", function() {
		newPersonClick();
	})

	function newPersonClick() {
		$("#emptyString").replaceWith("<tr id='editForm'><td><input id='surname'></input></td><td><input id='name'></input></td><td><input id='patronymic'></input></td><td><input id='number'></input></td><td><button id='cancel'>Отменить</button></td><td><button id='save'>Применить</button></td>");
	}

	$("body").on("click", "#cancel", function() {
		cancel();
	})

	function cancel() {
		$("#editForm").replaceWith("<tr id='emptyString'><td colspan='6'><button id='newPerson'>Добавить</button></td></tr>")
	}


	$("body").on("click", "#save", function() {
		save();
	})

	function save() {
		let person = {};
		person['surname'] = $("#surname").val();
		person['name'] = $("#name").val();
		person['patronymic'] = $("#patronymic").val();
		person['number'] = $("#number").val();

		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(person),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/person/",
			async: false,
			success: function(savedPerson) {
				console.log(savedPerson);
				let id = savedPerson['id'];
				let surname = savedPerson['surname'];
				let name = savedPerson['name'];
				let patronymic = savedPerson["patronymic"];
				let number = savedPerson["number"];
				cancel();

				$('#emptyString').before("<tr id=" + id + "><td>" + surname + "</td><td>" + name + "</td><td>" + patronymic + "</td><td>" + number + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
			},
			error: function(e) {
				cancel();
			}
		});
	}


	$("body").on("click", ".removeButton", function() {
		remove($(this));
	})

	function remove(button) {
		let id = button.parent().parent().attr("id");
		console.log("id = " + id);
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/person/" + id,
			async: false,
			success: function(rez) {
				console.log('element = ' + $("#" + id));
				$("#" + id).remove();
			},
			error: function(e) {
			}
		});
	}

	$("body").on("click", ".editButton", function() {
		edit($(this));
	})

	function edit(button) {
		let id = button.parent().parent().attr("id");
		console.log("id = " + id);
		$("#" + id).replaceWith("<tr id='" + id + "'><td><input id='editSurname'></input></td><td><input id='editName'></input></td><td><input id='editPatronymic'></input></td><td><input id='editNumber'></input></td><td><button id='close'>Отменить</button></td><td><button id='accept'>Применить</button></td>");
	}

	$("body").on("click", "#close", function() {
		
		console.log("close");
		let elementId = $(this).parent().parent().attr("id");
		console.log("id = " + elementId);
		$.ajax({
			type: "GET",
			contentType: "application/json",
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/person/" + elementId,
			async: false,
			success: function(savedPerson) {
				console.log(savedPerson);
				let id = savedPerson['id'];
				let surname = savedPerson['surname'];
				let name = savedPerson['name'];
				let patronymic = savedPerson["patronymic"];
				let number = savedPerson["number"];
				$('#' + elementId).replaceWith("<tr id=" + id + "><td>" + surname + "</td><td>" + name + "</td><td>" + patronymic + "</td><td>" + number + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
			},
			error: function(e) {
				cancel();
			}
		});
	})

	$("body").on("click", "#accept", function() {
		console.log("accept");
		let elementId = $(this).parent().parent().attr("id");
		console.log("id = " + elementId);
		
		
		let person = {};
		person['id'] = elementId;
		person['surname'] = $("#editSurname").val();
		person['name'] = $("#editName").val();
		person['patronymic'] = $("#editPatronymic").val();
		person['number'] = $("#editNumber").val();

		$.ajax({
			type: "put",
			contentType: "application/json",
			data: JSON.stringify(person),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/person/",
			async: false,
			success: function(savedPerson) {
				console.log(savedPerson);
				let id = savedPerson['id'];
				let surname = savedPerson['surname'];
				let name = savedPerson['name'];
				let patronymic = savedPerson["patronymic"];
				let number = savedPerson["number"];
				

				$('#' + elementId).replaceWith("<tr id=" + id + "><td>" + surname + "</td><td>" + name + "</td><td>" + patronymic + "</td><td>" + number + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
			},
			error: function(e) {

			}
		});
	})


});