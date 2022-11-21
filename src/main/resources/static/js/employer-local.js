let codeSido;
let codeSigungu;
let codeEupmyeondong = [];

const sidoBox = document.querySelector('.sido');
const sigunguBox = document.querySelector('.sigungu');
const eupmyeondongBox = document.querySelector('.eupmyeondong');

document.addEventListener('DOMContentLoaded', getSidoList);

async function getSidoList() {
    const response = await axios.post('http://localhost:8080/sido');
    const sidoInfo = response.data;
    for (let i in sidoInfo) {
        const code = i;
        const name = sidoInfo[i];
        const sidoOption = document.createElement('option');

        sidoOption.value = code;
        sidoOption.innerText = name;
        if (i === '11') {
            codeSido = '11';
            sidoOption.selected = true;
            getSigunguList(i);
        }
        sidoBox.appendChild(sidoOption);
        eupmyeondongBox.style.visibility = 'hidden';
    }
    sidoBox.addEventListener('change', function () {
        codeEupmyeondong.splice(0);
        codeSido = this.value;
        for (let i of sigunguBox.childNodes) {
            i.remove();
            sigunguBox.textContent = '';
        }
        sigunguBox.style.visibility = 'visible';
        eupmyeondongBox.style.visibility = 'hidden';
        getSigunguList(codeSido);
    });
}

async function getSigunguList(codeSido) {
    const response = await axios.post('http://localhost:8080/sigungu?sidoCode=' + codeSido);
    const sigunguInfo = response.data;
    for (let i in sigunguInfo) {
        const code = i;
        const name = sigunguInfo[i];
        const sigunguInput = document.createElement('input');
        const sigunguLabel = document.createElement('label');

        sigunguInput.type = 'radio';
        sigunguInput.name = 'sigungu';
        sigunguInput.id = code;
        sigunguLabel.for = code;
        sigunguLabel.innerText = name;

        sigunguInput.appendChild(sigunguLabel);
        sigunguBox.appendChild(sigunguInput);
        sigunguBox.appendChild(sigunguLabel);

        sigunguInput.addEventListener('change', function () {
            console.log('[sigunguInput-addEventListener-change]');
            console.log(codeEupmyeondong);
            codeEupmyeondong.splice(0);
            console.log(codeEupmyeondong);
        });

        sigunguInput.addEventListener('click', function () {
            if (this.checked === true) {
                eupmyeondongBox.style.visibility = 'visible';
                codeSigungu = this.id;
                for (let i of eupmyeondongBox.childNodes) {
                    i.remove();
                    eupmyeondongBox.textContent = '';
                }
                getEupmyeondongList(codeSido, codeSigungu);
            } else {
                codeEupmyeondong.splice(0);
                eupmyeondongBox.style.visibility = 'hidden';
            }
            console.log('[sigunguInput-addEventListener-click]');
            console.log(codeEupmyeondong);
        });
    }
}

async function getEupmyeondongList(codeSido, codeSigungu) {
    const response = await axios.post('http://localhost:8080/eupmyeondong?sidoCode=' + codeSido + '&sigunguCode=' + codeSigungu);
    const eupmyeondongInfo = response.data;

    for (let i in eupmyeondongInfo) {
        const code = i;
        const name = eupmyeondongInfo[i];
        const eupmyeondongInput = document.createElement('input');
        const eupmyeondongLabel = document.createElement('label');

        eupmyeondongInput.type = 'radio';
        eupmyeondongInput.name = 'eupmyeondong';
        eupmyeondongInput.id = code;
        eupmyeondongLabel.for = code;
        eupmyeondongLabel.innerText = name;

        eupmyeondongInput.appendChild(eupmyeondongLabel);
        eupmyeondongBox.appendChild(eupmyeondongInput);
        eupmyeondongBox.appendChild(eupmyeondongLabel);

        eupmyeondongInput.addEventListener('change', function () {
            const code = this.id;
            codeEupmyeondong.splice(0);
            codeEupmyeondong.push(code);

            console.log('[eupmyeondongInput-addEventListener-click]');
            console.log(codeEupmyeondong);
        });

    }


}

