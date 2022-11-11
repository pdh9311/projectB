function getErrorMsg(id) {
    if (id === ElementId.ID) {
        return ErrorMsg.ID;
    }
    if (id === ElementId.PW) {
        return ErrorMsg.PW;
    }
    if (id === ElementId.REPW) {
        return ErrorMsg.REPW;
    }
    if (id === ElementId.EMAIL) {
        return ErrorMsg.EMAIL;
    }
    if (id === ElementId.NAME) {
        return ErrorMsg.NAME;
    }
    if (id === ElementId.PHONE) {
        return ErrorMsg.PHONE;
    }
    if (id === ElementId.ADRESS) {
        return ErrorMsg.ADRESS;
    }
    if (id === ElementId.AGREESERVICE) {
        return ErrorMsg.AGREESERVICE;
    }
    if (id === ElementId.AGREEPERSONAL) {
        return ErrorMsg.AGREEPERSONAL;
    }
}

function errorMsgOpen() {
    errorMsgElement.textContent = errorMessage;
    errorMsgElement.parentElement.style.visibility = "visible"
}
function errorMsgClose() {
    errorMsgElement.parentElement.style.visibility = "hidden"
}
function changeErrorMsg(msg) {
    errorMessage = msg;
}


