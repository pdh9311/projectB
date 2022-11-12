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


    let data = {
        personal: getPersonal(),
        historyList: getHistory()
    };
    let formData = new FormData();
    formData.append('file', photoContentElement[0].files[0]);
    //formData.append('file', photoContentElement[0].files[1]);
    formData.append("personal", new Blob([JSON.stringify(data)], {type: "application/json"}));
    sendServer(formData);
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

    //const photoContent = photoContentElement.value;
    const photoContent = photoContentElement[0].files[0];
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
    let xhr = new XMLHttpRequest();
    xhr.open('post', '/join/worker', true);
    xhr.onload = () => {
        //통신 성공
        if (xhr.status === 200) {
            console.log(xhr.response);
            console.log("통신 성공");
        } else {
            //통신 실패
            console.log("통신 실패");
        }
    }
    xhr.send(data);
    console.log(data);
}
