//validate.js
function isValidate(obj) {
    if (obj.id.value == '') {
        alert('아이디를 입력하세요?');
        obj.id.focus();
        return false;
    }
    else if (frmObj.pwd.value.length == 0) {
        alert('비밀번호를 입력하세요?');
        frmObj.pwd.focus();
        return false;
    }
    else if (frmObj.pwd.value != frmObj.pwd2.value) {
        alert('비밀번호가 일치하지 않아요');
        frmObj.pwd2.focus();
        return false;
    }
    //라디오버튼 선택여부 판단하기
    var isGender = false;
    for (var i = 0; i < obj.gender.length; i++) {
        if (obj.gender[i].checked) {
            isGender = true;
            break;
        }
    }//for
    if (!isGender) {
        alert('성별을 선택하세요');
        obj.gender[0].focus();
        return false;
    }
    //체크박스 2개 이상 선택하도록 유효성 검사
    var count = 0;
    var notchecked = [];//new Array();
    for (i = 0; i < obj.inter.length; i++) {
        if (obj.inter[i].checked) {
            count++
        }
        else {//체크 안된경우
            notchecked.push(i);
        }
    }
    if (count < 2) {
        alert('관심사항은 2개 이상 선택하세요');
        //체크안된 가장 빠른 인덱스에 포커스 주기
        obj.inter[notchecked[0]].focus();
        return false;
    }
    if (obj.grade.selectedIndex == 0) {
        alert('학력을 선택하세요');
        obj.grade.focus();
        return false;
    }
    if (obj.file.value == '') {
        alert('파일을 첨부하세요');
        obj.file.focus();
        return false;
    }
    if (obj.self.value == '') {
        alert('자기소개를 입력하세요');
        obj.self.focus();
        return false;
    }
    return true;
}

function fnNoSubmitButton(obj) {
    //console.log('obj: ', obj)
    if (obj == undefined)
        obj = document.forms[0];

    if (isValidate(obj)) obj.submit();
}