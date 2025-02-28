/**
 * 
 */
document.getElementById('btnSave').addEventListener('click',sendPost)

function sendPost() {
	if(!isCheck){
		alert('사용할 수 없는 아이디 입니다.')
		return;
	}
	
	// 6개의 입력값 가져오기
	const userid = document.getElementById('userid').value
	const username = document.getElementById('username').value
	const birth = document.getElementById('birth').value
	const gender = document.getElementById('gender').value
	const email = document.getElementById('email').value
	const password = document.getElementById('password').value
	const url = '/account'
	// 저장할 데이터를 객체로 만들기 : 프로퍼티이름과 값저장 변수명이 같으면 줄여서 한번만 작성
//	const obj = {userid:userid, username:username, birth:birth, 
//				gender: gender, email : email , password: password}
	const obj = {userid, username, birth, gender, email , password}
	/*
	const obj = {
		userid : 'gilsoon2',
		username : '이길순',
		birth : '2010-01-01',
		gender : '여성',
		email : 'soonii@naver.com',
		password : '9999'
	}*/
	
	const options = {
		method: 'POST',
		headers : {
			'Content-Type': 'application/json;charset=UTF-8'
		},
		body : JSON.stringify(obj) //jsonStr
	}
	
	fetch(url,options)
		.then(response => {
			console.log("response : ", response)
			if(response.status === 400){
				alert('userid 와 email 은 유일한 값으로 합니다.(무결성 위반)')
			}
			return response.json()
		})
		.then(data => {
			console.log("data: ",data)
			if(data===1) {
				alert('계정 등록 완료했습니다.')
				clear()
			}	
			
		})
		.catch(error => console.error("오류 : ", error))
}

function clear() {
	document.getElementById('userid').value=''
	document.getElementById('username').value=''
	document.getElementById('password').value=''
	document.getElementById('gender').value=''
	document.getElementById('birth').value=''
	document.getElementById('email').value=''
	document.getElementById('message').innerHTML=''
}