document.getElementById('register-form').addEventListener('submit', function(e) {
    e.preventDefault();

    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirm-password').value;

    if (password !== confirmPassword) {
        alert('两次输入的密码不一致！');
        return;
    }

    // 这里可以添加更多验证逻辑

    // 提交表单
    this.submit();
});
