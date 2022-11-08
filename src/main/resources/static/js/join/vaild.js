document.addEventListener("DOMContentLoaded", function () {
    let idIsValid = false;

//1. 입력한 value 값을 읽어온다.
//2. value 검증한다.
//3. 검증 결과에 따라 input 요소에 is-valid 또는 is-invalid 클래스 추가
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

    function validEventListener(){
            let wrap = getWrapElement(this.id);
            if (isValid(this.id , this.value)) {
                changeMsgValid(this.classList);
                changeBoarderValid(wrap);
                return;
            }
            changeMsgInValid(this.classList);
            changeBoarderInValid(wrap)
    }

    function getWrapElement(id) {
        return document.getElementsByClassName(id+"-wrap");
    }
    function changeMsgValid(classList) {
        classList.remove("is-invalid");
        classList.add("is-valid");
    }
    function changeBoarderValid(wrap) {
        wrap[0].style.border = "1px solid #16EAB7";
    }
    function changeMsgInValid(classList) {
        classList.remove("is-valid");
        classList.add("is-invalid");
    }
    function changeBoarderInValid(wrap) {
        wrap[0].style.border = "1px solid #dc3545";
    }

    function isValid(id , value) {

        let condition = false;
        if (id === "id") {
            condition = value.length >= 4 && value.length <= 15;
            idIsValid = condition;
            return condition;
        }
        if (id === "pw") {
            condition = value.length >= 8 && value.length <= 16;
            idIsValid = condition;
            return condition;
        }
        if (id === "re-pw") {
            let pw = document.getElementById("pw").value;
            condition = pw == value;
            idIsValid = condition;
            return condition;
        }
        if (id === "email") {
            condition = value.length > 0;
            idIsValid = condition;
            return condition;
        }
        if (id === "name") {
            condition = value.length > 0;
            idIsValid = condition;
            return condition;
        }
        if (id === "phone") {
            condition = value.length == 11;
            idIsValid = condition;
            return condition;
        }
        if (id === "adr") {
            condition = value.length > 0;
            idIsValid = condition;
            return condition;
        }
        // if (id === "adr-detail") {
        //     condition = value.length >= 5 && value.length <= 10;
        //     idIsValid = condition;
        //     return condition;
        // }
    }


    function submit() {
        if (idIsValid) {
            alert("clear")
        } else {
            alert("fail")
        }
    }

});

