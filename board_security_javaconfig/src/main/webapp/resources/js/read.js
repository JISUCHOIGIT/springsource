/**
 * read.jsp 스크립트
 */
$(function() {

	//openForm 가져오기
	let openForm = $("#openForm");

	//list 버튼 클릭 시 /board/list 보여주기
	$(".btn-info").click(function() {

		// openForm bno 태그 제거하기
		//openForm.remove('bno');
		openForm.find("input[name='bno']").remove();

		// openForm action 수정
		openForm.attr("action", "/board/list")

		// openForm 보내기
		openForm.submit();
	})

	//modify /list 버튼 클릭 시
	$(".btn-default").click(function() {
		openForm.submit();
	})

	//modify 버튼 클릭시 openForm 이동
	$(".btn-info").click(function() {
		openForm.submit();
	})

	//첨부파일 ------------------------

	//첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url: 'getAttachList',
		data: {
			bno: bno
		},
		success: function(data) {
			console.log(data);
			showUploadFile(data);
		}

	})

	function showUploadFile(result) {
		//업로드 결과 영역 가져오기
		let uploadResult = $(".uploadResult ul");

		let str = "";

		$(result).each(function(idx, obj) {
			if (obj.fileType) {
				//썸네일 이미지 보여주기
				//썸네일 이미지 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath + "\\s_" + obj.uuid + "_" + obj.fileName);

				//원본 파일 이미지 경로
				let oriPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				oriPath = oriPath.replace(new RegExp(/\\/g), "/");

				//fileCallPath : 파라미터로 넘기는 방식, 인코딩 된 방식
				str += "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<a href=\"javascript:showImage(\'" + oriPath + "\')\">";
				str += "<img src='/display?fileName=" + fileCallPath + "'></a>";
				str += "<div>" + obj.fileName;
				str += "</div></li>";
			} else { //txt 파일

				//다운로드 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName);

				str += "<li data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.fileType + "'>";
				str += "<a href='/download?fileName=" + fileCallPath + "'>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "<div>" + obj.fileName;
				str += "</div></li>";

			}

		});

		console.log("업로드 파일 경로");
		console.log(str);

		uploadResult.append(str);
	}//showIpladFile 종료
})