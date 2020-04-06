function chargerClasses() {
	var id = $("#etablissement option:selected").val();
	if (id != 0) {
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/classes/etablissement/" + id,
			success : function(result) {
				$.each(result, function() {
					$("#classe").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	} else {
		$('#classe').empty().append('<option></option>');
	}
}

function chargerNiveaux() {
	var id = $("#etablissement option:selected").val();
	if (id != 0) {
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
	}
}