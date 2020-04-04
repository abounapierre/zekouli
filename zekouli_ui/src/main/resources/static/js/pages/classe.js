function getNiveaux() {
	var id = $("#cycle option:selected").val();
	if (id != 0) {
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/niveaux/cycle/" + id,
			success : function(result) {
				$('#niveau').empty().append('<option></option>');
				$.each(result, function() {
					$("#niveau").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	} else {
		$('#niveau').empty().append('<option></option>');
	}
}

function getCycles() {
	var id = $("#etablissement option:selected").val();
	if (id != 0) {
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/cycles/etablissement/" + id,
			success : function(result) {
				$('#cycle').empty().append('<option></option>');
				$.each(result, function() {
					$("#cycle").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/series/etablissement/" + id,
			success : function(result) {
				$('#serie').empty().append('<option></option>');
				$.each(result, function() {
					$("#serie").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/niveaux/etablissement/" + id,
			success : function(result) {
				$('#niveau').empty().append('<option></option>');
				$.each(result, function() {
					$("#niveau").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	} else {
		$('#niveau').empty().append('<option></option>');
		$('#serie').empty().append('<option></option>');
		$('#cycle').empty().append('<option></option>');
	}
}