var cmtFrmElem = document.querySelector('#cmtFrm');	
var cmtListElem = document.querySelector('#cmtList');
var cmtModalElem = document.querySelector('#modal');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;
	console.log('cmtVal : ' + cmtVal);
	console.log(cmtFrmElem.dataset.iboard)
	
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};
	regAjax(param);
}

// 서버 등록
function regAjax(param) {
	const init = {
		method: 'POST',
		// 주소값을 받아오는 간단한 방법
		body: new URLSearchParams(param)
		};
		// ''안에 데이터를 서버에 응답요청
		fetch('cmtInsSel', init)
		// 다음 할일 예약(?)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) { // then안에 function : 익명함수
			console.log(myJson);
			
			switch(myJson.result) {
				case 0:
					alert('등록 실패');
				break;
				case 1:
					// 댓글 등록후 댓들창에 내용삭제
					cmtFrmElem.cmt.value = '';
					getListAjax();
				break;
			}
		});
}

//서버에 댓글 리스트 자료 달라고 요청하는 함수
// data- 에서 값을 가져오는 방법
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		// 값을 보냄
		makeCmtElemList(myJson);
	});
}

function makeCmtElemList(data) {
	// html의 태그를 만들 수 있다.
	cmtListElem.innerHTML = '';
	
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
	
	// th태그안에 내용입력
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';
	
	// th태그를 tr태그 안에 소속시킴
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
	
	// tr태그를 table태그 안에 소속시킴
	tableElem.append(trElemTitle);
	
	// table태그를 담아서 jsp에 id="cmtList"로 가져갈것
	cmtListElem.append(tableElem);
	
	// iuser가 같으면 버튼 생성하기위해 iuser받아오기
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
	// 자바스크립트에서 forEach문으로 댓글뿌리기
	data.forEach(function(item){
		// 태그 생성
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
		
		// td태그에 소속시킨다
		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		
		/*
			iuser값을 비교하여 iuser가 같으면 삭제수정버튼 생성
			다르면 삭제수정버튼 생성하지 않음
		*/
		if(parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');	
			var modBtn = document.createElement('button');
			
			// 삭제버튼 클릭시 
			delBtn.addEventListener('click',function(){
				// closeUp 기법 
				
				// 결과문이 true면 실행 
				// concfirm boolean type
				if(confirm('삭제하시겠습니까?')) {
				delAjax(item.icmt);					
				}
			});
				
			// 수정			
			modBtn.addEventListener('click', function() {
				//댓글 수정 모달창 띄우기
				 openModModal(item);
			});
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		// tr태그에 소속시킨다
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		// 테이블에 소속시킨다
		tableElem.append(trElemCtnt);
		
		
	});
}

// 수정 삭제
function delAjax(icmt) {
	// fetch - > 메소드호출
	fetch('cmtDelUpd?icmt=' + icmt)
	// then -> 프라미스객체이기 때문에 사용
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson){ 
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('댓글 삭제를 실패하였습니다.');
			break
			case 1:
				getListAjax(); 
			break
		}
		
	});
}

function modAjax() {
	var cmtModFrmElem = cmtModalElem.querySelector('#cmtModFrm');
	// 자바스크립트 객체 생성방법
	var param = {
		icmt: cmtModFrmElem.icmt.value,
		cmt: cmtModFrmElem.cmt.value
	}
	
const init = {
	method: 'POST',
		// 주소값을 받아오는 간단한 방법
		body: new URLSearchParams(param)
		};
		
		fetch('cmtDelUpd', init)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson)
			switch(myJson) {
				case 0:
				console.log('댓글 수정에 실패했습니다');
				break;
				case 1:
				console.log('댓글 수정에 성공했습니다');
				getListAjax();
				closeModModal();
				break;
			}
		});		
}

function openModModal({icmt, cmt}) {
	cmtModalElem.className = '';
	console.log('icmt : ' + icmt);
	console.log('cmt : ' + cmt);

	var cmtModFrmElem = cmtModalElem.querySelector('#cmtModFrm');
	cmtModFrmElem.icmt.value = icmt;
	cmtModFrmElem.cmt.value = cmt;
}

function closeModModal() {
	cmtModalElem.className = 'displayNone';
}
/*
이 파일이 임포드되면 함수 1회 호출!
없으면 값만 받고 값을 서블릿으로 주지않는다.
*/
getListAjax(); 



