const personal = document.querySelector('.personal-corporate ul li:nth-child(1)');
const corporate = document.querySelector('.personal-corporate ul li:nth-child(3)');
const socialLogin = document.querySelector('.social-login');
const joinAnchor = document.querySelector('.join > a');

personal.addEventListener('click', function () {
    if (this.classList.contains("personal-highlight") == false) {
        this.classList.add("personal-highlight");
    }
    if (corporate.classList.contains('corporate-highlight') == true) {
        corporate.classList.remove("corporate-highlight");
    }
    socialLogin.style.display = 'block';
    joinAnchor.innerHTML = '개인 회원가입';
    joinAnchor.setAttribute('href', "#");
});
corporate.addEventListener('click', function () {
    if (this.classList.contains('corporate-highlight') == false) {
        this.classList.add('corporate-highlight');
    }
    if (personal.classList.contains('personal-highlight') == true) {
        personal.classList.remove('personal-highlight');
    }
    socialLogin.style.display = 'none';
    joinAnchor.innerHTML = "기업 회원가입";
    joinAnchor.setAttribute('href', "#");
});