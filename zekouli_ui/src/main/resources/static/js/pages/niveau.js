
	function ajaxGet() {
	var id = $("#etablissement option:selected").val();
	if (id != 0) {
		$.ajax({
			type : "GET",
			url : baseUrl + "ajax/cycles/etablissement/" + id,
			success : function(result) {
				$.each(result, function() {
					$("#cycle").append(
							$("<option/>").val(this.id).text(this.libelle));
				});
				$.notify("Access granted", "success");
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	} else {
		$('#cycle').empty().append('<option></option>');
	}
}		
