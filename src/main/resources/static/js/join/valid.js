function validElement(element) {
    let wrap = getWrapElement(element.id);
    if (isValid(element.id, element.value)) {
        changeBoarderColor(wrap, vaildColor);
        return;
    }
    changeErrorMsg(getErrorMsg(element.id));
    changeBoarderColor(wrap, inVaildColor);
}

function getWrapElement(id) {
    return document.getElementsByClassName(id + "-wrap")[0];
}

function changeBoarderColor(wrap, color) {
    wrap.style.borderColor = color;
}

function isValid(id, value) {
    if (id === ElementId.AGREESERVICE) {
        CheckResult.AGREESERVICE = agreeServiceElement.checked;
        return agreeServiceElement.checked;
    }
    if (id === ElementId.AGREEPERSONAL) {
        CheckResult.AGREEPERSONAL = agreePersonalElement.checked
        return agreePersonalElement.checked;
    }
    if (id === ElementId.ID) {
        CheckResult.ID = value.length >= 4 && value.length <= 15;
        return value.length >= 4 && value.length <= 15;
    }
    if (id === ElementId.PW) {
        CheckResult.PW = value.length >= 8 && value.length <= 16;
        return value.length >= 8 && value.length <= 16;
    }
    if (id === ElementId.REPW) {
        CheckResult.REPW = pwElement.value === value && value.length > 0;
        return pwElement.value === value && value.length > 0;
    }
    if (id === ElementId.EMAIL) {
        CheckResult.EMAIL = value.length > 0;
        return value.length > 0;
    }
    if (id === ElementId.NAME) {
        CheckResult.NAME = value.length > 0;
        return value.length > 0;
    }
    if (id === ElementId.PHONE) {
        CheckResult.PHONE = value.length === 11;
        return value.length === 11;
    }
    if (id === ElementId.ADRESS) {
        CheckResult.ADRESS = value.length > 0;
        return value.length > 0;
    }
}

function hasInvalid() {

    if (CheckResult.AGREESERVICE === false) {
        return true;
    }
    if (CheckResult.AGREEPERSONAL === false) {
        return true;
    }
    if (CheckResult.ID === false) {
        return true;
    }
    if (CheckResult.PW === false) {
        return true;
    }
    if (CheckResult.REPW === false) {
        return true;
    }
    if (CheckResult.EMAIL === false) {
        return true;
    }
    if (CheckResult.NAME === false) {
        return true;
    }
    if (CheckResult.PHONE === false) {
        return true;
    }
    if (CheckResult.ADRESS === false) {
        return true;
    }
}

// function validEventListener() {
//     let wrap = getWrapElement(this.id);
//     if (isValid(this.id, this.value)) {
//         changeBoarderValid(wrap);
//         errorMsgClose();
//         return;
//     }
//     errorMsgOpen(getErrorMsg(this.id))
//     changeBoarderInValid(wrap)
// }
