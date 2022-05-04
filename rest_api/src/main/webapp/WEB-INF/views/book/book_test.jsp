<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>도서정보</h3>
		
		<button type="button" id="all" class="btn btn-secondary">도서목록</button>
		<button type="button" id="get" class="btn btn-primary">특정도서정보</button>
		<button type="button" id="delete" class="btn btn-danger">도서정보삭제</button>
		<button type="button" id="update" class="btn btn-success">도서정보수정</button>
	
		<div id="result">
			<table class="table">
				<form action="" method="post">
					<div>
						<label>코드</label>
						<input type="text" name="code" id="code" />
					</div>
					<div>
						<label>제목</label>
						<input type="text" name="title" id="title" />
					</div>
					<div>
						<label>저자</label>
						<input type="text" name="writer" id="writer" />
					</div>
					<div>
						<label>가격</label>
						<input type="text" name="price" id="price" />
					</div>
					<div>
						<button type="button" id="insert">입력</button>
					</div>
				</form>
			</table>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(function(){
	$("#all").click(function(){
		/*//ajax방식으로 데이터 요청
		$.ajax({
			url:'',
			method:'',
			data:{ // 객체 방식으로 보내는 형식
				
			},
			success:function(){
				//서버의 응답코드가(HTTP 상태코드) 200일때
			}
			
		})*/
		
		// 가져올 데이터가 json이라면
		$.getJSON({ //간단히 사용하는 코드법
			url:'list',
			//callback 콜백함수 : 이벤트가 일어나면 불려지는 형태의 함수
			success:function(data){ //호출하는 함수가 아님 / 언젠가는 불러지는 함수 : callback함수
				console.log(data);	 //브라우저 console
				
				//본문 table 영역 변경하기
				let result = $("#result table");
				let str ="";
				
				$.each(data,function(idx,item){
					str += "<tr>";
					str += "<td>"+item.code+"</td>";
					str += "<td>"+item.title+"</td>";
					str += "<td>"+item.writer+"</td>";
					str += "<td>"+item.price+"</td>";
					str += "</tr>";
				})
				result.html(str);
			}
		})
	})//all 종료
	
	// /book/1000  + GET => 1000번 도서에 대한 정보 가져오기
	$("#get").click(function(){
		$.getJSON({ //데이터를 가져올 때 $.getJSON$ 사용
			url :'2000',
			success : function(item) {
				//본문 table 영역 변경하기
				let result = $("#result table");
				let str ="";
				
				str += "<tr>";
				str += "<td>"+item.code+"</td>";
				str += "<td>"+item.title+"</td>";
				str += "<td>"+item.writer+"</td>";
				str += "<td>"+item.price+"</td>";
				str += "</tr>";
				
				result.html(str);

				}
			})
		})//get 종료
		$("#delete").click(function(){
			$.ajax({
				url:'2001',
				type:'delete', // @DeleteMapping 연결
				success : function(data) {
					alert(data);
				},
				error : function(xhr,status,error) {
					alert(xhr.responseText);
				}
		})
	})//delete 종료
	
	//
	$("#update").click(function(){
		
		let param = {
				price : 100000
		};
		
		
		$.ajax({
			url:'2000',
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(param),
			success : function(data) {
				alert(data);
			},
			error : function(xhr,status,error) {
				alert(xhr.responseText);
			}
		})
	})//update 종료
	$("#insert").click(function(){
		let param = {
			code:$("#code").val(),	
			title:$("#title").val(),	
			writer:$("#writer").val(),	
			price:$("#price").val()
				
		};
		
		/*$.ajax({
			url : "new",
			type : "post",
			contentType:"application/json", //json 처리 : 요즘 가장 많이 씀, txt파일처럼
			data : JSON.stringify(param),
			success : function(data) {
				alert(data);
			},
			error : function(xhr,status,error) {
				alert(xhr.responseText);
			}
			
		})*/
		
		//데이터를 폼으로 보낼때
		//data : $("form").serialize(),
		$.ajax({
			url : "new2",
			type : "post",
			data : $("form").serialize(),
			success : function(data) {
				alert(data);
			},
			error : function(xhr,status,error) {
				alert(xhr.responseText);
			}
			
		})
		
		
	})

})
</script>
</body>
</html>