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

    axios({
        method: 'post',
        url: 'index',
        data: {
            username: document.forms["form1"]["username"].value, // 获取用户名
            password: document.forms["form1"]["password"].value // 获取密码
        }
    }).then((result)=>{
        console.log(result)
    })

    return true;
}