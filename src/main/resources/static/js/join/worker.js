document.addEventListener("DOMContentLoaded", function () {

    const agreeAll = document.getElementById("agree-chk-all");
    const agreeMembers = document.querySelectorAll(".agree-member");
    const joinForm = document.getElementById("submit");

    agreeAll.addEventListener('click', function () {
        agreeMembers.forEach((agreeMember) => {
            agreeMember.checked = agreeAll.checked;
        });
    });

    joinForm.addEventListener('click', function () {

        let submitDate = {};

        const agreeService = document.getElementById("agree-service").checked;
        const agreePersonalInfo = document.getElementById("agree-personal-info").checked;
        const agreeSms = document.getElementById("agree-sms").checked;
        const agreeEmail = document.getElementById("agree-email").checked;
        const id = document.getElementById("id").value;
        const password = document.getElementById("pw").value;
        const rePassword = document.getElementById("re-pw").value;
        const email = document.getElementById("email").value;
        const name = document.getElementById("name").value;
        const phone = document.getElementById("phone").value;
        const adr = document.getElementById("adr").value;
        const adrDetail = document.getElementById("adr-detail").value;
        const historyStartDate = document.querySelectorAll(".history-start-date")[0].value;
        const historyEndDate = document.querySelectorAll(".history-end-date")[0].value;
        const historyContent = document.querySelectorAll(".history-content")[0].value;
        const photoContent = document.querySelectorAll(".photo-content")[0].value;
        const radioButton = document.querySelectorAll(".radio-button");

        let radioChked = "";
        radioButton.forEach((radio) => {
            if(radio.checked){
                radioChked = radio.value;
            }
        });

        let personal = {};
        personal.agreeService= agreeService;
        personal.agreePersonalInfo= agreePersonalInfo;
        personal.agreeSms= agreeSms;
        personal.agreeEmail= agreeEmail;
        personal.id= id;
        personal.password= password;
        personal.rePassword= rePassword;
        personal.email= email;
        personal.name= name;
        personal.phone= phone;
        personal.adr= adr;
        personal.adrDetail= adrDetail;
        personal.period= radioChked;

        submitDate.personal=personal;

        let photos = {};
        let photoList = [];
        photos.photoContent= photoContent;
        photoList.push(photos);
        submitDate.photoList=photoList;

        let historys = {};
        let historyList = [];
        historys.historyStartDate= historyStartDate;
        historys.historyEndDate= historyEndDate;
        historys.historyContent= historyContent;
        historyList.push(historys)
        submitDate.historyList=historyList;

        console.log("=submitDate=")
        console.log("submitDate" , submitDate)
        var httpRequest  = new XMLHttpRequest();

        httpRequest.open('POST', '/join/worker',true);
        httpRequest.responseType = "json";
        httpRequest.setRequestHeader('Content-Type', 'application/json');
        httpRequest.send(JSON.stringify(submitDate));

        httpRequest.onload = () => {
            //통신 성공
            if (httpRequest.status == 200) {
                console.log(httpRequest.response);
                console.log("통신 성공");
            } else {
                //통신 실패
                console.log("통신 실패");
            }
        }
    });



});
