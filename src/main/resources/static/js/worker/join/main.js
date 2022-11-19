document.addEventListener("DOMContentLoaded", function (){
    init();
});

    function init() {
        const agreeCheckAll = document.getElementById(agree_element_id.CHK_ALL);
        const agreeService = document.getElementById(agree_element_id.SERVICE);
        const agreePersonal = document.getElementById(agree_element_id.PERSONAL);
        const agreeSMS = document.getElementById(agree_element_id.SMS);
        const agreeEmail = document.getElementById(agree_element_id.EMAIL);
        const agreeMemberAll = document.getElementsByClassName(agree_elements_class.MEMBER);
        const agreeMemberRequired = document.getElementsByClassName(agree_elements_class.REQUIRED);

        const userId = document.getElementById(personal_element_id.USER_ID);
        const userPw = document.getElementById(personal_element_id.USER_PW);
        const userRePw = document.getElementById(personal_element_id.USER_REPW);
        const userName = document.getElementById(personal_element_id.USER_NAME);
        const userBirth = document.getElementById(personal_element_id.USER_BIRTH);
        const userEmail = document.getElementById(personal_element_id.USER_EMAIL);
        const userPhone = document.getElementById(personal_element_id.USER_PHONE);

        const expirationDate = document.getElementsByClassName(expiration_elements_class.MEMBER);

        const submitButton = document.getElementById(button_element_id.SUBMIT);
    }

    function agreeChangeAll(){

    }
