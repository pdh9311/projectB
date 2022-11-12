
const worker = document.querySelector('.login-select ul li:nth-child(1)');
const employer = document.querySelector('.login-select ul li:nth-child(3)');
const socialLogin = document.querySelector('.social-login');
const joinAnchor = document.querySelector('.join');
const idInput = document.querySelector('.id');
const pwInput = document.querySelector('.pw input[type="password"]');
const form = document.querySelector('form');

worker.addEventListener('click', function () {
    if (this.classList.contains("worker-highlight") == false) {
        this.classList.add("worker-highlight");
    }
    if (employer.classList.contains('employer-highlight') == true) {
        employer.classList.remove("employer-highlight");
    }
    socialLogin.style.display = 'block';
    joinAnchor.innerHTML = '개인 회원가입';
    idInput.name = "workerId";
    pwInput.name = "workerPw";
    form.action = "/login/worker";
    joinAnchor.setAttribute('href', "#");
});

employer.addEventListener('click', function () {
    if (this.classList.contains('employer-highlight') == false) {
        this.classList.add('employer-highlight');
    }
    if (worker.classList.contains('worker-highlight') == true) {
        worker.classList.remove('worker-highlight');
    }
    socialLogin.style.display = 'none';
    joinAnchor.innerHTML = "기업 회원가입";
    idInput.name = "employerId";
    pwInput.name = "employerPw";
    form.action="/login/employer"
    joinAnchor.setAttribute('href', "/join/employer");

});
