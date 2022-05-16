/**
 * list.jsp 스크립트
 */

$(function(){
	//regBtn 클릭 시 /board/register 로 움직이기
	$("#regBtn").click(function(){
		location.href = "/board/register";
	})
	

	//게시물 등록 시 모달 창 띄우기
	checkModal(result);
	
	history.replaceState({},null,null)
	
	function checkModal(result){
		if(result == '' || history.state) {
			return;
		}
		
		if(parseInt(result) > 0) {
			$(".modal-body").html("게시물 "+result+" 번이 등록")
		}
		$("#myModal").modal("show"); // 'hide'
		
	} //checkModal 종료
	
	//페이지 이동 버튼 클릭
 	let actionForm = $("#actionForm");
	$(".paginate_button a").click(function(e){
		e.preventDefault();
		
		//bno가 있는 경우 제거
		actionForm.find("[name='bno']").remove();
		
		//action 수정
		actionForm.attr("action","/board/list")
		
		//사용자가 선택한 페이지 번호 가져오기
		let pageNum = $(this).attr("href");
		
		//가져온 번호를 actionForm 안의 pageNum 값으로 대체
		actionForm.find("[name='pageNum']").val(pageNum);
	
		//actionForm 보내기
		actionForm.submit();
 

   })//paginate_button 종료
	//페이지 목록 개수가 클릭
	$(".form-control").change(function(e){
		//actionForm 안의 amount 값을 변경하기
		actionForm.find("[name='amount']").val($(this).val());

		//actionForm 보내기
		actionForm.submit();
	})
	
	//타이틀 클릭 시
	$(".move").click(function(e){
		e.preventDefault();
		
		//a가 가지고 있는 href 가지고 오기
		let href = $(this).attr("href");
		
		//bno 태그를 추가하기
		//내용 보기에 들어갔을 때 사용자가 리스트 버튼이 아닌 뒤로 가기 버튼을 눌러서
		//목록으로 돌아올 때 bno가 계속 추가되는 것 방지
		if(actionForm.find("[name='bno']").length!=0) {
			actionForm.find("[name='bno']").val(href);
		} else {	
			actionForm.append("<input type='hidden' name='bno' value='"+href+"'>");

		}
		actionForm.append("<input type='hidden' name='bno' value='"+href+"'>");
		//actinoForm.append("bno").val(href);
		
		//actionForm action 변경(/board/read)
		actionForm.attr("action","/board/read");

		//actionForm 보내기
		actionForm.submit();		
		
	})
	// 검색 버튼 클릭 시
	
	// type 아무것도 선택이 되지 않으면 경고 메시지
	// keyword 값이 없으면 경고 메시지 돌려보내기
	// 검색 폼안에 pageNum은 1로 변경
	
	
	// 검색 폼 전송
	
	let searchForm = $("#searchForm");
	$(".btn-default").click(function(e){
		e.preventDefault();
		
		//if($("[name = 'type']").val() == "")  {
		if(searchForm.find("[name='type']").val() == "") {
			alert("검색기준을 선택해주세요");
			return;
			
		//else if($("[name ='keyword']").val() == "") 
		} if(searchForm.find("[name='keyword']").val() == ""){
			alert("키워드를 입력해주세요");
			return;
		}
		//searchForm.attr("action","/board/list");
		//검색 결과의 페이지가 1로 보여줘야 하기때문에 1로 변겨
		searchForm.find("input[name='pageNum']").val("1");
		
		//attr : 태그 옆 속성값 action, method
		//find : 태그를 찾아서 value값을 바꿀때 
		
		searchForm.submit();
	})
	
	
})