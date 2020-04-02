var ctx = $("meta[name='ctx']").attr("content");
var baseUrl = "/";
if(typeof ctx === "undefined"){
	baseUrl = "/";
}else{
	baseUrl = ctx + "/";
}
