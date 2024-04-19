$(document).ready(() => {

	$("body").on("click", "#newDetail", function() {
		newDetailClick();
	})

	function newDetailClick() {
		$("#emptyString").replaceWith("<tr id='editForm'><td><input id='name'></input></td><td><input id='price'></input></td><td><button id='cancel'>Отменить</button></td><td><button id='save'>Применить</button></td>");
	}

	$("body").on("click", "#cancel", function() {
		cancel();
	})

	function cancel() {
		$("#editForm").replaceWith("<tr id='emptyString'><td colspan='6'><button id='newDetail'>Добавить</button></td></tr>")
	}


	$("body").on("click", "#save", function() {
		save();
	})

	function save() {
		let detail = {};
		detail['name'] = $("#name").val();
		detail['price'] = $("#price").val();

		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(detail),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/detail/",
			async: false,
			success: function(savedDetail) {
				console.log(savedDetail);
				let id = savedDetail['id'];
				let name = savedDetail['name'];
				let price = savedDetail["price"];
				cancel();

				$('#emptyString').before("<tr id=" + id + "><td>" + name + "</td><td>" + price + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
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
			url: "./api/detail/" + id,
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
		$("#" + id).replaceWith("<tr id='" + id + "'><td><input id='editName'></input></td><td><input id='editPrice'></input></td><td><button id='close'>Отменить</button></td><td><button id='accept'>Применить</button></td>");
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
			url: "./api/detail/" + elementId,
			async: false,
			success: function(savedDetail) {
				console.log(savedDetail);
				let id = savedDetail['id'];
				let name = savedDetail['name'];
				let price = savedDetail["price"];
				$('#' + elementId).replaceWith("<tr id=" + id + "><td>" + name + "</td><td>" + price + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
			},
			error: function(e) {
			}
		});
	})

	$("body").on("click", "#accept", function() {
		console.log("accept");
		let elementId = $(this).parent().parent().attr("id");
		console.log("id = " + elementId);
		
		
		let detail = {};
		detail['id'] = elementId;
		detail['name'] = $("#editName").val();
		detail['price'] = $("#editPrice").val();

		$.ajax({
			type: "put",
			contentType: "application/json",
			data: JSON.stringify(detail),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/detail/",
			async: false,
			success: function(savedDetail) {
				console.log(savedDetail);
				let id = savedDetail['id'];
				let name = savedDetail['name'];
				let price = savedDetail["price"];
				

				$('#' + elementId).replaceWith("<tr id=" + id + "><td>" + name + "</td><td>" + price + "</td><td><button class='removeButton'>Удалить</button></td><td><button class='editButton'>Редактировать</button></td></tr>");
			},
			error: function(e) {

			}
		});
	})


});