const frmElem = document.querySelector('#frm');
const selectElem = frmElem.recordCnt;

selectElem.addEventListener('change', function () {


});

function moveToDetail(iboard) {
	location.href = 'detail?iboard=' + iboard;
}