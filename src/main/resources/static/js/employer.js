/* 이용약관 동의 체크 */
const agreeAllBox = document.querySelector('.agree-all .checkbox-box');
const agreeAll = document.querySelector('.agree-all .checkbox-box input[type="checkbox"]');
const agreeServiceBox = document.querySelector('.agree-service .checkbox-box');
const agreeService = document.querySelector('.agree-service .checkbox-box input[type="checkbox"]');
const agreePersonalInfoBox = document.querySelector('.agree-personal-info .checkbox-box');
const agreePersonalInfo = document.querySelector('.agree-personal-info .checkbox-box input[type="checkbox"]');
const agreeSmsBox = document.querySelector('.agree-sms .checkbox-box');
const agreeSms = document.querySelector('.agree-sms .checkbox-box input[type="checkbox"]');
const agreeEmailBox = document.querySelector('.agree-email .checkbox-box');
const agreeEmail = document.querySelector('.agree-email .checkbox-box input[type="checkbox"]');
agreeAllBox.addEventListener('click', function () {
    if (agreeService.checked == false ||
        agreePersonalInfo.checked == false ||
        agreeSms.checked == false ||
        agreeEmail.checked == false) {
        agreeAll.checked = true;
        agreeService.checked = true;
        agreePersonalInfo.checked = true;
        agreeSms.checked = true;
        agreeEmail.checked = true;
    } else {
        agreeAll.checked = false;
        agreeService.checked = false;
        agreePersonalInfo.checked = false;
        agreeSms.checked = false;
        agreeEmail.checked = false;
    }
});

function agreeAllCondition() {
    if (agreeService.checked == true &&
        agreePersonalInfo.checked == true &&
        agreeSms.checked == true &&
        agreeEmail.checked == true) {
        return true;
    }
    return false;
}

agreeServiceBox.addEventListener('click', function () {
    if (agreeAllCondition()) {
        agreeAll.checked = true;
    } else {
        agreeAll.checked = false;
    }
});
agreePersonalInfoBox.addEventListener('click', function () {
    if (agreeAllCondition()) {
        agreeAll.checked = true;
    } else {
        agreeAll.checked = false;
    }
});
agreeSmsBox.addEventListener('click', function () {
    if (agreeAllCondition()) {
        agreeAll.checked = true;
    } else {
        agreeAll.checked = false;
    }
});
agreeEmailBox.addEventListener('click', function () {
    if (agreeAllCondition()) {
        agreeAll.checked = true;
    } else {
        agreeAll.checked = false;
    }
});

/* 아이디 */
const idBox = document.querySelector('.id');
const idTitle = document.querySelector('.id span');
const id = document.querySelector('.id input[type="text"]');
idBox.addEventListener('click', function () {
    id.focus();
});
id.addEventListener('focusout', function () {
    // 아이디 유효성 검사 : 영문, 숫자 4 ~ 15자
    const idRegExp = /^[a-zA-Z0-9]{4,15}$/;
    if (!idRegExp.test(id.value)) {
        idBox.style.border = "1px solid red";
        idTitle.style.color = "#dc3545";
        id.value = '';
    } else {
        idBox.style.border = "1px solid #23dc3d";
        idTitle.style.color = "#198754";
    }
});

id.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        password.focus();
    }
});

/* 비밀번호 */
const passwordBox = document.querySelector('.password');
const passwordTitle = document.querySelector('.password span');
const password = document.querySelector('.password input[type="password"]');
passwordBox.addEventListener('click', function () {
    password.focus();
});

password.addEventListener('focusout', function () {
    // 비밀번호 유효성 검사 : 영문, 숫자, 특수문자 8~16자
    const passwordRegExp = /^[a-zA-Z0-9{}\\|;:'",<.>/?`₩!@#$%^&*()-]{8,16}$/;
    if (!passwordRegExp.test(password.value)) {
        passwordBox.style.border = "1px solid red";
        passwordTitle.style.color = "#dc3545";
    } else {
        passwordBox.style.border = "1px solid #23dc3d";
        passwordTitle.style.color = "#198754";
    }
});
password.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        rePassword.focus();
    }
});

/* 비밀번호 재확인 */
const rePasswordBox = document.querySelector('.re-password');
const rePasswordTitle = document.querySelector('.re-password span');
const rePassword = document.querySelector('.re-password input[type="password"]');
rePasswordBox.addEventListener('click', function () {
    rePassword.focus();
});
rePassword.addEventListener('focusout', function () {
    // 비밀번호 유효성 검사 : 영문, 숫자, 특수문자 8~16자
    const passwordRegExp = /^(?=.*[a-zA-Z])(?=.*[\[\]{}\\|;:'",<.>/?`~₩!@#$%^&*()-])(?=.*[0-9]).{8,16}$/;
    if (!passwordRegExp.test(rePassword.value) || password.value != rePassword.value) {
        rePasswordBox.style.border = "1px solid red";
        rePasswordTitle.style.color = "#dc3545";
    } else {
        rePasswordBox.style.border = "1px solid #23dc3d";
        rePasswordTitle.style.color = "#198754";
    }
});
rePassword.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        email.focus();
    }
});

/* 이메일 */
const emailBox = document.querySelector('.email-box');
const emailTitle = document.querySelector('.email span ');
const email = document.querySelector('.email input[type="email"]');
emailBox.addEventListener('click', function () {
    email.focus();
});
email.addEventListener('focusout', function () {
    // email 유효성 검사
    const emailRegExp = /^[a-zA-Z0-9._+-]+@[a-zA-Z0-9._+-]+\.[a-zA-Z0-9_+-]+$/;
    if (!emailRegExp.test(email.value)) {
        emailBox.style.border = "1px solid red";
        emailTitle.style.color = "#dc3545";
    } else {
        emailBox.style.border = "1px solid #23dc3d";
        emailTitle.style.color = "#198754";
    }
});
email.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        businessNumber1.focus();
    }
});


/* 사업자 번호 */
const businessNumberBox = document.querySelector('.business-number-box');
const businessNumberTitle = document.querySelector('.business-number-box span');
const businessNumber1 = document.querySelector('.business-number input[type="text"]:nth-child(1)');
const businessNumber2 = document.querySelector('.business-number input[type="text"]:nth-child(2)');
const businessNumber3 = document.querySelector('.business-number input[type="text"]:nth-child(3)');
// businessNumberBox.addEventListener('click', function () {
//     businessNumber1.focus();
// });


const businessNumber1RegExp = /^[0-9]{3}$/;
const businessNumber2RegExp = /^[0-9]{2}$/;
const businessNumber3RegExp = /^[0-9]{5}$/;

businessNumber1.addEventListener('focusout', function() {
    if (!businessNumber1RegExp.test(businessNumber1.value)) {
        businessNumberBox.style.border = "1px solid red";
        businessNumberTitle.style.color = "#dc3545"
        businessNumber1.style.border = "1px solid red";
    } else {
        businessNumber1.style.border = "1px solid #23dc3d";
        if (businessNumber2RegExp.test(businessNumber2.value) &&
            businessNumber3RegExp.test(businessNumber3.value)) {
            businessNumberBox.style.border = "1px solid #23dc3d";
            businessNumberTitle.style.color = "#198754"
            businessNumber2.style.border = "1px solid #23dc3d";
            businessNumber3.style.border = "1px solid #23dc3d";
        }
    }
});

businessNumber2.addEventListener('focusout', function() {
    if (!businessNumber2RegExp.test(businessNumber2.value)) {
        businessNumberBox.style.border = "1px solid red";
        businessNumberTitle.style.color = "#dc3545"
        businessNumber2.style.border = "1px solid red";
    } else {
        businessNumber2.style.border = "1px solid #23dc3d";
        if (businessNumber1RegExp.test(businessNumber1.value) &&
            businessNumber3RegExp.test(businessNumber3.value)) {
            businessNumberBox.style.border = "1px solid #23dc3d";
            businessNumberTitle.style.color = "#198754"
            businessNumber1.style.border = "1px solid #23dc3d";
            businessNumber3.style.border = "1px solid #23dc3d";
        }
    }
});

businessNumber3.addEventListener('focusout', function() {
    if (!businessNumber3RegExp.test(businessNumber3.value)) {
        businessNumberBox.style.border = "1px solid red";
        businessNumberTitle.style.color = "#dc3545"
        businessNumber3.style.border = "1px solid red";
    } else {
        businessNumber3.style.border = "1px solid #23dc3d";
        if (businessNumber1RegExp.test(businessNumber1.value) &&
            businessNumber2RegExp.test(businessNumber2.value)) {
            businessNumberBox.style.border = "1px solid #23dc3d";
            businessNumberTitle.style.color = "#198754"
            businessNumber1.style.border = "1px solid #23dc3d";
            businessNumber2.style.border = "1px solid #23dc3d";
        }
    }
});

const joinBtn = document.querySelector('.btn-join-complete');
businessNumber1.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        businessNumber2.focus();
    }
});
businessNumber2.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        businessNumber3.focus();
    }
});
businessNumber3.addEventListener('keydown', function (event) {
    if (event.keyCode == 13) {
        event.preventDefault();
        joinBtn.focus();
    }
});
