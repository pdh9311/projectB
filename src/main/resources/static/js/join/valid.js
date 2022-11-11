document.addEventListener("DOMContentLoaded", function () {
    let idIsValid = false;

    document.getElementById("id").addEventListener("input", validEventListener);
    document.getElementById("pw").addEventListener("input", validEventListener);
    document.getElementById("re-pw").addEventListener("input", validEventListener);
    document.getElementById("email").addEventListener("focusout", validEventListener);
    document.getElementById("name").addEventListener("input", validEventListener);
    document.getElementById("phone").addEventListener("focusout", validEventListener);
    document.getElementById("adr").addEventListener("focusout", validEventListener);
    document.getElementById("agree-service").addEventListener("focusout", validEventListener);
    document.getElementById("agree-personal-info").addEventListener("input", validEventListener);

    // document.getElementById("adr-detail").addEventListener("input", validEventListener);

    function validEventListener() {
        let wrap = getWrapElement(this.id);
        if (isValid(this.id, this.value)) {
            // changeMsgValid(this.classList);
            changeBoarderValid(wrap);
            document.getElementById("error-msg").textContent = ""
            document.getElementById("error-msg").parentElement.style.visibility = "hidden"
            return;
        }
        document.getElementById("error-msg").textContent = "에러"
        document.getElementById("error-msg").parentElement.style.visibility = "visible"
        // changeMsgInValid(this.classList);
        changeBoarderInValid(wrap)
    }

    function getWrapElement(id) {
        return document.getElementsByClassName(id + "-wrap");
    }

    function changeBoarderValid(wrap) {
        wrap[0].style.border = "1px solid #16EAB7";
    }

    function changeBoarderInValid(wrap) {
        wrap[0].style.border = "1px solid #dc3545";
    }
    function isValid(id, value) {
        if (id === ElementIdList.ID) {
            return value.length >= 4 && value.length <= 15;
        }
        if (id === ElementIdList.PW) {
            return value.length >= 8 && value.length <= 16;
        }
        if (id === ElementIdList.REPW) {
            return ElementCheckList.PW.value == value;
        }
        if (id === ElementIdList.EMAIL) {
            return value.length > 0;
        }
        if (id === ElementIdList.NAME) {
            return value.length > 0;
        }
        if (id === ElementIdList.PHONE) {
            return value.length == 11;
        }
        if (id === ElementIdList.ADRESS) {
            return value.length > 0;
        }
    }
    // function isValid(id , value) {
    //
    //     let condition = false;
    //     if (id === "id") {
    //         condition = value.length >= 4 && value.length <= 15;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "pw") {
    //         condition = value.length >= 8 && value.length <= 16;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "re-pw") {
    //         let pw = document.getElementById("pw").value;
    //         condition = pw == value;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "email") {
    //         condition = value.length > 0;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "name") {
    //         condition = value.length > 0;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "phone") {
    //         condition = value.length == 11;
    //         idIsValid = condition;
    //         return condition;
    //     }
    //     if (id === "adr") {
    //         condition = value.length > 0;
    //         idIsValid = condition;
    //         return condition;
    //     }
    // if (id === "adr-detail") {
    //     condition = value.length >= 5 && value.length <= 10;
    //     idIsValid = condition;
    //     return condition;
    // }
    // }


    function submit() {
        if (idIsValid) {
            alert("clear")
        } else {
            alert("fail")
        }
    }

});

