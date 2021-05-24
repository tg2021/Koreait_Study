var frmElem = document.querySelector('#frm');
var uidElem = frmElem.uid;
var upwElem = frmElem.upw;
var chkupwElem = frmElem.chkupw;
var unmElem = frmElem.unm;
var chkUidResultElem = document.querySelector('#chkUidResult');

// 중복체크 버튼
var btnChkIdElem = frmElem.btnChkId;
btnChkIdElem.addEventListener('click', function(){
	idChkAjax(uidElem.value);
});

function idChkAjax(uid) {
	console.log(uid);
	//chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';
	// AJAX
	fetch('/user/idChk?uid=' + uid)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		switch(myJson.result) {
			
			case 0:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 있습니다.';
			break;
			
			case 1:
			chkUidResultElem.innerText = '이 아이디는 사용할 수 없습니다.';
			break;
		}
		
	});
}

function frmChk() {
	// 이상이 생기면 return false;
	/*
	아이디 하나도 안 적으련 alert "아이디를 작성해주세요"
	2자 이하면 "아이디는 3자 이상 작성해 주세요." false리턴
	*/
	var uidVal = uidElem.value;  
	if(uidVal.length < 3) {
		if(uidVal.length == 0) {
		alert('아이디를 작성해 주세요');	
		} else {
			alert('아이디는 3자 이상 작성해 주세요.')
		}
		return false;
	} 
	
	/*
		비밀번호가 하나도 작성 안 되어있으면 '비밀번호를 작성해 주세요' false 리턴
		3자 이하면 alert '비밀번호는 4자 이상 작성해 주세요 false 리턴'
		비밀번호와 확인비밀번호가 다르면 '비밀번호를 확인해 주세요'
	 */
	var upwVal = upwElem.value;
	console.log(upwVal);
	var chkupwVal = chkupwElem.value;
	
	if(upwVal.length < 3) {
		
		if(upwVal.length == 0) {
			alert('비밀번호를 작성해 주세요');
		} else {
			alert('비밀번호는 4자 이상 작성해 주세요');
		}
		return false;
		
		
	} else if(upwVal !== chkupwVal) {
		alert('비밀번호를 확인해 주세요');
		return false;
	}
	
	if(unmElem.value.length < 2) {
		alert('이름은 2자 이상 작성해 주세요.');
		return false;
	}
}
// return false; 주면 이벤트가 발생을 했을때 변화가 없다.