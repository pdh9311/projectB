const applyBtn = document.querySelector('.apply');

applyBtn.addEventListener('click', function (event) {
    event.preventDefault();
    if (codeSido != undefined && codeSigungu != undefined && codeEupmyeondong.length > 0) {
        console.log(codeSido);
        console.log(codeSigungu);
        console.log(codeEupmyeondong);
        jobApply();
    }
});

async function jobApply() {
    const response = await axios({
        method: 'POST',
        url: 'http://localhost:8080/worker/main/apply',
        data: {
            sidoCode: codeSido,
            sigunguCode: codeSigungu,
            eupmyeondongCodes: codeEupmyeondong,
        },
    });
    console.log(response);
    if (response.data === 'ok') {
        alert('신청되었습니다.');
    } else {
        alert('신청에 실패했습니다.')
    }
}