document.addEventListener('DOMContentLoaded', onloaded());

function onloaded() {
    getSidoList();
}

async function getSidoList() {
    const response = await axios.post('http://localhost:8080/sido');
    const sidoInfo = response.data;
    const sido = document.querySelector('.sido');
    const sigungu = document.querySelector('.sigungu');
    const eupmyeondong = document.querySelector('.eupmyeondong');

    for (let i in sidoInfo) {
        const code = i;
        const name = sidoInfo[i];
        const sidoOption = document.createElement('option');

        sidoOption.value = '' + code;
        sidoOption.innerText = name;
        if (i === '11') {
            sidoOption.selected = true;
            getSigunguList(i);
        }
        sido.appendChild(sidoOption);
        eupmyeondong.style.visibility = 'hidden';

    }
    sido.addEventListener('change', function () {
        const sidoCode = this.value;
        for (let i of sigungu.childNodes) {
            i.remove();
            sigungu.textContent = '';
        }
        sigungu.style.visibility = 'visible';
        getSigunguList(sidoCode);
    });
}

async function getSigunguList(sidoCode) {
    const response = await axios.post('http://localhost:8080/sigungu?sidoCode=' + sidoCode);
    const sigunguInfo = response.data;
    const sigungu = document.querySelector('.sigungu');

    for (let i in sigunguInfo) {
        const code = i;
        const name = sigunguInfo[i];
        const sigunguInput = document.createElement('input');
        const sigunguLabel = document.createElement('label');

        sigunguInput.type = 'radio';
        sigunguInput.name = 'sigungu';
        sigunguInput.id = '' + code;
        sigunguLabel.for = '' + code;
        sigunguLabel.innerText = name;

        sigunguInput.appendChild(sigunguLabel);
        sigungu.appendChild(sigunguInput);
        sigungu.appendChild(sigunguLabel);

        const eupmyeondong = document.querySelector('.eupmyeondong');

        sigunguInput.addEventListener('click', function () {
            if (this.checked === true) {
                eupmyeondong.style.visibility = 'visible';
                const sigunguCode = this.id;
                for (let i of eupmyeondong.childNodes) {
                    i.remove();
                    eupmyeondong.textContent = '';
                }
                getEupmyeondongList(sidoCode, sigunguCode);
            } else {
                eupmyeondong.style.visibility = 'hidden';
            }
        });
    }
}

async function getEupmyeondongList(sidoCode, sigunguCode) {
    const response = await axios.post('http://localhost:8080/eupmyeondong?sidoCode=' + sidoCode + '&sigunguCode=' + sigunguCode);
    const eupmyeondongInfo = response.data;
    const eupmyeondong = document.querySelector('.eupmyeondong');

    const allEupmyeondongInput = document.createElement('input');
    const allEupmyeondongLabel = document.createElement('label');

    allEupmyeondongInput.type = 'checkbox';
    allEupmyeondongInput.name = 'allEupmyeondong';
    allEupmyeondongInput.id = 'allEupmyeondong';
    allEupmyeondongLabel.for = 'allEupmyeondong';
    allEupmyeondongLabel.innerText = '전체';

    allEupmyeondongInput.appendChild(allEupmyeondongLabel);
    eupmyeondong.appendChild(allEupmyeondongInput);
    eupmyeondong.appendChild(allEupmyeondongLabel);

    for (let e in response.entries) {
        console.log(e);
    }

    for (let i in eupmyeondongInfo) {
        const code = i;
        const name = eupmyeondongInfo[i];
        const eupmyeondongInput = document.createElement('input');
        const eupmyeondongLabel = document.createElement('label');

        eupmyeondongInput.type = 'checkbox';
        // eupmyeondongInput.name = 'eupmyeondong' + code;
        eupmyeondongInput.name = 'eupmyeondong';
        eupmyeondongInput.id = '' + code;
        eupmyeondongLabel.for = '' + code;
        eupmyeondongLabel.innerText = name;

        eupmyeondongInput.appendChild(eupmyeondongLabel);
        eupmyeondong.appendChild(eupmyeondongInput);
        eupmyeondong.appendChild(eupmyeondongLabel);

        eupmyeondongInput.addEventListener('click', function () {
            // 현재 지역의 지원자들의 목록
            // 지역정보 : sido, sigungu, eypmyeondong

        });

    }

    allEupmyeondongInput.addEventListener('click', function () {
        if (this.checked === true) {
            for (let i of eupmyeondong.childNodes) {
                i.checked = true;
            }
        } else {
            for (let i of eupmyeondong.childNodes) {
                i.checked = false;
            }
        }
    });

}