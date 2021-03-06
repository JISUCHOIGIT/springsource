/**
 * register.jsp 스크립트
 */


$(function(){
   $(":submit").click(function(e){
      e.preventDefault();
      
      
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

	  //폼 보내기
	  $("form").append(str).submit();
   })

	// x버튼 클릭시 첨부 파일 삭제
	$(".uploadResult").on("click","button",function(){
		//button 태그의 data-속성 가져오기
		let targetFile = $(this).data("file");
		let type = $(this).data("type");
		
		
		let targetLi = $(this).closest("li");
		$.ajax({
			url : '/deleteFile',
			data : {
				fileName:targetFile, //파일 네임
				type:type //파일 타입
			},
			beforeSend:function(xhr){
				xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);
			},
			type:'post', //post 방식
			success:function(result){
				console.log(result);
				$(":file").val("");
				
				//li 태그 제거
				targetLi.remove();
			}
		})
		
	})
	
})
	

