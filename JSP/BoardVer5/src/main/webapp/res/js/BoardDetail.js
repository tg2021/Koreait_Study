var insFrmElem = document.querySelector(`#insFrm`);
var updFrmElem = document.querySelector(`#updFrm`);


// 댓글 삭제
function delCmt(iboard, icmt) {
	
	/* 
	${iboard}는 el식이 아니라 자바스크립트문법이다
	*/
	console.log(`iboard: %d, icmt: %d`, iboard, icmt);
	if(confirm('삭제하시겠습니까?')) {
		/* 리턴을 할 수 도있고 안할 수 도 있다
		confirm('삭제하시겠습니까?') 는 비void형
		if(boolean형)
		*/
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;	
		// location.href get방식
	}
}

// 댓글 수정
function updCmt(icmt, cmt) {
	console.log('icmt : %d', icmt);
	console.log('cmt : %s', cmt);
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}

function showInsFrm() {
	
	insFrm.className = '';
	updFrm.className = 'hidden';
	
}


