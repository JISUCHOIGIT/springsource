/**
 * uploadform_ajax
 */

$(function(){
	$("#uploadBtn").click(function(){
		console.log("ajax 파일 업로드 호출");
		
		//폼 객체 생성
		let formData = new FormData();
		//첨부파일 목록 가져오기
		let inputFile = $("[name='uploadFile']");
		//console.log(inputFile);		
		let files = inputFile[0].files;
		
		console.log(files);
		
		//폼 객체에 첨부파일들을 추가
		for(let i=0;i<files.length;i++){
			formData.append("uploadFile",files[i]);
		}
		
		//encytpe : "multpart/form-data"와 같은
		//processData:false => 데이터를 일반적인 쿼리 스트링 형태로 반환할 것인지 결정
		//					   기본값은 true(application/x-www-form-urlencoded)
		//contentType:false => 기본값은 true()
		
		
		//폼 객체 ajax 전송
		$.ajax({
			url : 'uploadAjax',
			type : 'post',
			processData : false, // 
			contentType : false, // 
			data : formData,
			dataType:'json',
			success : function(result){
				console.log(result);
				$(":file").val(""); //값없애기 ""
				showUploadFile(result);
			}
			
		})

	}) //uploadBtn종료
	
	function showUploadFile(result) {
		//업로드 결과 영역 가져오기
		let uploadResult = $(".uploadResult ul");
		
		let str = "";
		
		$(result).each(function(idx,obj){
			if(obj.fileType) {
				//썸네일 이미지 보여주기
				//썸네일 이미지 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath+"\\s_"+obj.uuid+"_"+obj.fileName);
				
				//원본 파일 이미지 경로
				let oriPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
				oriPath = oriPath.replace(new RegExp(/\\/g),"/");
				
				//fileCallPath : 파라미터로 넘기는 방식, 인코딩 된 방식
				str += "<li><a href=\"javascript:showImage(\'"+oriPath+"\')\">";
				str += "<li><img src='/display?fileName="+fileCallPath+"'></a>";
				str += "<div>"+obj.fileName+"<span data-file='"+fileCallPath+"' data-type='image'> x </span>";
				str += "</div></li>";
			}else {
				
				//다운로드 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
				
				str += "<li><a href='download?fileName="+fileCallPath+"'>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "<div>"+obj.fileName+"<span data-file='"+fileCallPath+"' data-type='file'> x </span>";
				str += "</div></li>";
			}
		});
		
		uploadResult.append(str);
	}//showIpladFile 종료
	//첨부파일 삭제(x 동작)
	$(".uploadResult").on("click","span",function(){
		//span 태그의 data-속성 가져오기
		//tragetFile = fileCallpath
		//data - file - data("file");
		//data - type - data("type");
		let targetFile = $(this).data("file");
		let type = $(this).data("type");
		
		
		let targetLi = $(this).closest("li");
		$.ajax({
			url : '/deleteFile',
			data : {
				fileName:targetFile, //파일 네임
				type:type //파일 타입
			},
			type:'post', //post 방식
			success:function(result){
				console.log(result);
				
				//li 태그 제거
				targetLi.remove();
			}
		})
		
	})
	
	
	
	
	//이미지 종료
	$(".bigPictureWrapper").on("click",function(){
		$(".bigPicture").animate({width:'0',height:'0'},1000);
		setTimeout(function(){
			$(".bigPictureWrapper").hide();
			},1000);
			
		})
	})


function showImage(fileCallPath){
	$(".bigPictureWrapper").css("display","flex").show();
	
	$(".bigPicture").html("<img src='/display?fileName="+fileCallPath+"'>").animate({width:'100%',height:'100%'},1000);
}







