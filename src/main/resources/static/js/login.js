function login() {
    if (document.forms["form1"]["username"].value == "") {
        alert("用户名不能为空，请确定后重新输入");
        document.forms["form1"]["username"].focus();
        return false;
    }
    if (document.forms["form1"]["password"].value == "") {
        alert("密码不能为空，请确定后重新输入");
        document.forms["form1"]["password"].focus();
        return false;
    }
    return true;
}