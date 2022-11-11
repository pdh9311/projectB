document.addEventListener("DOMContentLoaded", function () {

    agreeAllElement = document.getElementById(ElementId.AGREEEALL);
    agreeServiceElement = document.getElementById(ElementId.AGREESERVICE);
    agreePersonalElement = document.getElementById(ElementId.AGREEPERSONAL);
    agreeSmsElement = document.getElementById(ElementId.AGREESMS)
    agreeEmailElement = document.getElementById(ElementId.AGREEEMAIL);
    agreeMemberElements = document.querySelectorAll(ElementClass.AGREEMEMBER);

    idElement = document.getElementById(ElementId.ID);
    pwElement = document.getElementById(ElementId.PW);
    repwElement = document.getElementById(ElementId.REPW);
    emailElement = document.getElementById(ElementId.EMAIL);
    nameElement = document.getElementById(ElementId.NAME);
    phoneElement = document.getElementById(ElementId.PHONE);
    adressElement = document.getElementById(ElementId.ADRESS);
    adressDetailElement = document.getElementById(ElementId.ADRESSDETAIL);
    historyStartElement = document.querySelectorAll(ElementSelectorAll.HISTORYSTART);
    historyEndElement = document.querySelectorAll(ElementSelectorAll.HISTORYEND);
    historyContentElement = document.querySelectorAll(ElementSelectorAll.HISTORYCONTENT);
    photoContentElement = document.querySelectorAll(ElementSelectorAll.PHOTOCONTENT);
    radioButtonElement = document.querySelectorAll(ElementSelectorAll.RADIOBUTTON);

    errorMsgElement = document.getElementById(ElementId.ERRORMSG);
    btnElement = document.getElementById(ElementId.BUTTON);

    agreeAllElement.addEventListener('click', checkAll);
    btnElement.addEventListener("click", submit);
    // agreeServiceElement.addEventListener('change', validEventListener);
    // agreePersonalElement.addEventListener('change', validEventListener);
    // idElement.addEventListener("focusout", validEventListener);
    // pwElement.addEventListener("focusout", validEventListener);
    // repwElement.addEventListener("focusout", validEventListener);
    // emailElement.addEventListener("focusout", validEventListener);
    // nameElement.addEventListener("focusout", validEventListener);
    // phoneElement.addEventListener("focusout", validEventListener);
    // adressElement.addEventListener("focusout", validEventListener);

});

function checkAll() {
    agreeMemberElements.forEach((agreeMember) => {
        agreeMember.checked = agreeAllElement.checked;
    });
}

function submit() {

    validElement(adressElement);
    validElement(phoneElement);
    validElement(nameElement);
    validElement(emailElement);
    validElement(repwElement);
    validElement(pwElement);
    validElement(idElement);
    validElement(agreePersonalElement);
    validElement(agreeServiceElement);

    if (hasInvalid()) {
        errorMsgOpen()
        return;
    }
    errorMsgClose();

    let sendData = {}
    sendData.personal = getPersonal();
    sendData.photoList = getPhoto();
    sendData.historyList = getHistory();
    
    sendServer(sendData);
}


function getPersonal() {

    const agreeService = agreeServiceElement.checked;
    const agreePersonalInfo = agreePersonalElement.checked;
    const agreeSms = agreeSmsElement.checked;
    const agreeEmail = agreeEmailElement.checked;
    const id = idElement.value;
    const password = pwElement.value;
    const rePassword = repwElement.value;
    const email = emailElement.value;
    const name = nameElement.value;
    const phone = phoneElement.value;
    const adr = adressElement.value;
    const adrDetail = adressDetailElement.value;
    let radioChked = null;

    radioButtonElement.forEach((radio) => {
        if (radio.checked) {
            radioChked = radio.value;
        }
    });

    let personal = {};
    personal.agreeService = agreeService;
    personal.agreePersonalInfo = agreePersonalInfo;
    personal.agreeSms = agreeSms;
    personal.agreeEmail = agreeEmail;
    personal.id = id;
    personal.password = password;
    personal.rePassword = rePassword;
    personal.email = email;
    personal.name = name;
    personal.phone = phone;
    personal.adr = adr;
    personal.adrDetail = adrDetail;
    personal.period = radioChked;
    return personal;
}

function getPhoto() {

    const photoContent = photoContentElement.value;

    let photos = {};
    let photoList = [];
    photos.photoContent = photoContent;
    photoList.push(photos);

    return photoList;
}

function getHistory() {

    const historyStartDate = historyStartElement[0].value;
    const historyEndDate = historyEndElement[0].value;
    const historyContent = historyContentElement[0].value;

    let historys = {};
    let historyList = [];
    historys.historyStartDate = historyStartDate;
    historys.historyEndDate = historyEndDate;
    historys.historyContent = historyContent;
    historyList.push(historys)
    return historyList;
}

function sendServer(data) {
    let httpRequest = new XMLHttpRequest();

    httpRequest.open('POST', '/join/worker', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(data));

    httpRequest.onload = () => {
        //통신 성공
        if (httpRequest.status === 200) {
            console.log(httpRequest.response);
            console.log("통신 성공");
        } else {
            //통신 실패
            console.log("통신 실패");
        }
    }
}

// function init() {
//     idElement = document.getElementById(ElementId.ID);
//     pwElement = document.getElementById(ElementId.PW);
//     repwElement = document.getElementById(ElementId.REPW);
//     emailElement = document.getElementById(ElementId.EMAIL);
//     nameElement = document.getElementById(ElementId.NAME);
//     phoneElement = document.getElementById(ElementId.PHONE);
//     adressElement = document.getElementById(ElementId.ADRESS);
//     agreeServiceElement = document.getElementById(ElementId.AGREESERVICE);
//     agreePersonalElement = document.getElementById(ElementId.AGREEPERSONAL);
//     errorMsgElement = document.getElementById(ElementId.ERRORMSG);
//     btnElement = document.getElementById(ElementId.BUTTON);
//     agreeAllElement = document.getElementById(ElementId.agreeAllElement);
//     agreeMemberElements = document.querySelectorAll(ElementClass.AGREEMEMBER);
// }
