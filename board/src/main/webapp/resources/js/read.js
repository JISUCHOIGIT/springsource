/**
 * read.jsp 스크립트
 */
$(function(){
   
   //openForm 가져오기
   let openForm = $("#openForm");   
   
   //list 버튼 클릭 시 /board/list 보여주기
   $(".btn-info").click(function(){
	
     // openForm bno 태그 제거하기
	 //openForm.remove('bno');
 	 openForm.find("input[name='bno']").remove();

	 // openForm action 수정
     openForm.attr("action","/board/list")
	 
	 // openForm 보내기
	 openForm.submit();
   })
   
   //modify /list 버튼 클릭 시
   $(".btn-default").click(function(){
      openForm.submit();
   })

	$(".btn-info").click(function(){
      openForm.submit();
   })
   
})