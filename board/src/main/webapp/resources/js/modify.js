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
			
			//첨부파일 목록 가져가기
			let str = "";
      
	      // li 태그 정보 수집하기
	      $(".uploadResult ul li").each(function(idx, obj){
	         var job = $(obj);
	         
	         str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + job.data("uuid") + "'>";   
	         str += "<input type='hidden' name='attachList[" + idx + "].uploadPath' value='" + job.data("path") + "'>";   
	         str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + job.data("filename") + "'>";   
	         str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + job.data("type") + "'>";   
	      });
      
	      console.log("form 태그 삽입 전 : " + str);

		  operForm.append(str);
			

		}else if(oper == "remove") {
			operForm.attr('action','/board/remove');
		}else if(oper == "list") {
			operForm.find("[name='bno']").remove();
			operForm.attr('action','/board/list');
		}
		
		operForm.submit();
		
	})
	
	//첨부파일 --------------------------------------------------------

	//첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url: 'getAttachList',
		data: {
			bno:bno
		},
		success: function(data) {
			console.log(data);
			showUploadFile(data);
		}

	})
	// 첨부파일 스크립트 종료------------------------------------------------
	// x버튼 클릭시 첨부 파일 삭제
	// 파일 최종 삭제는 modify 버튼을 누른 후에 해야 함
	$(".uploadResult").on("click","button",function(){
		
		//button 태그가 속해있는 li 태그 가져오기
		let targetLi = $(this).closest("li");
		
		if(confirm('정말로 파일을 삭제하시겠습니까?')){
			//li 태그 제거
			targetLi.remove();
			
		}

	})
})