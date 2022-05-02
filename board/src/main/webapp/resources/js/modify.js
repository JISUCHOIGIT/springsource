/**
 * modify.jsp
 */

$(function(){
	//operForm 가져오기
	let operForm = $("#operForm");
	
	$("button").click(function(e){
		e.preventDefault(); //submit 막기
		
		//현재 눌러진 버튼의 data-값을 가져오기
		//modify를 눌렀다면 this = modify
		let oper = $(this).data("oper");
		
		if(oper == "modify") {
			operForm = $("[role='form']");
		}else if(oper == "remove") {
			operForm.attr('action','/board/remove');
		}else if(oper == "list") {
			operForm.find("[name='bno']").remove();
			operForm.attr('action','/board/list');
		}
		
		operForm.submit();
		
	})
	
})