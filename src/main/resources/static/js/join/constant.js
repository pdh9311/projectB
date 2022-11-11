let agreeAllElement = null;
let agreeMemberElements = null;
let agreeServiceElement = null;
let agreePersonalElement = null;
let agreeSmsElement = null;
let agreeEmailElement = null;

let idElement = null;
let pwElement = null;
let repwElement = null;
let emailElement = null;
let nameElement = null;
let phoneElement = null;
let adressElement = null;
let adressDetailElement = null;
let historyStartElement = null;
let historyEndElement = null;
let historyContentElement = null;
let photoContentElement = null;
let radioButtonElement = null;

let errorMsgElement = null;
let btnElement = null;
let errorMessage = null;

const vaildColor = "#16EAB7";
const inVaildColor = "#dc3545";

const ElementSelectorAll = {
    HISTORYSTART: ".history-start-date",
    HISTORYEND: ".history-end-date",
    HISTORYCONTENT: ".history-content",
    PHOTOCONTENT: ".photo-content",
    RADIOBUTTON: ".radio-button",
}

const ElementId = {
    AGREESERVICE: "agree-service",
    AGREEPERSONAL: "agree-personal-info",
    AGREESMS: "agree-sms",
    AGREEEMAIL: "agree-email",
    AGREEEALL: "agree-chk-all",
    ID: "id",
    PW: "pw",
    REPW: "re-pw",
    EMAIL: "email",
    NAME: "name",
    PHONE: "phone",
    ADRESS: "adr",
    ADRESSDETAIL: "adr-detail",
    ERRORMSG: "error-msg",
    BUTTON: "submit"
}
const ElementClass = {
    IDWRAP: "id-wrap",
    PWWRAP: "pw-wrap",
    REPWWRAP: "re-pw-wrap",
    EMAILWRAP: "email-wrap",
    NAMEWRAP: "name-wrap",
    PHONEWRAP: "phone-wrap",
    ADRESSWRAP: "adr-wrap",
    AGREEWRAP: "agree-list",
    AGREEMEMBER: ".agree-member",
    ERRORMSG: "alert-box"
}

let CheckResult = {
    ID: false,
    PW: false,
    REPW: false,
    EMAIL: false,
    NAME: false,
    PHONE: false,
    ADRESS: false,
    AGREESERVICE: false,
    AGREEPERSONAL: false,
}

const ErrorMsg = {
    ID: "아이디는 5글자이상 10글자 이하로 입력해주세요.",
    PW: "비밀번호를 확인해주세요.",
    REPW: "비밀번호가 일치하지않습니다.",
    EMAIL: "이메일을 확인해주세요.",
    NAME: "이름을 확인해주세요.",
    PHONE: "핸드폰 번호를 확인해주세요.",
    ADRESS: "주소를 입력해주세요.",
    AGREESERVICE: "필수 이용약관을 체크해주세요",
    AGREEPERSONAL: "필수 이용약관을 체크해주세요"
}