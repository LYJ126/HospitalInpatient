// 获取页面中的相关DOM元素
const pwdForm = document.getElementById('pwdForm');
const pwd1 = document.getElementById('pwd1');
const pwd2 = document.getElementById('pwd2');
const pwd3 = document.getElementById('pwd3');
const submitBtn = document.getElementById('submitBtn');

// 模拟从后端获取原密码的数据（这里暂时写死，实际需通过接口请求获取）
let originalPwd = "";

// 假设这里有个函数从后端获取原密码，实际需按具体情况实现，比如使用fetch API请求后端接口
async function fetchOriginalPwd() {
    // 示例代码，模拟异步获取原密码，实际要替换为真实请求后端接口逻辑
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve("123456"); // 模拟原密码，实际从后端获取
        }, 1000);
    });
}

// 页面加载完成后执行的逻辑
window.addEventListener('load', async () => {
    originalPwd = await fetchOriginalPwd();
});

// 为表单的提交事件添加监听器
pwdForm.addEventListener('submit', function (event) {
    event.preventDefault(); // 阻止表单默认提交行为

    // 验证原密码是否正确
    if (pwd1.value!== originalPwd || pwd1.value === "") {
        alert("输入的原始密码不正确，请重新输入");
        pwd1.focus();
        return;
    }

    // 验证新密码是否为空
    if (pwd2.value === "") {
        alert("请输入新密码");
        pwd2.focus();
        return;
    }

    // 验证两次输入的新密码是否一致
    if (pwd2.value!== pwd3.value) {
        alert("两次输入的新密码不同，请重新输入");
        pwd3.focus();
        return;
    }

    // 如果验证通过，可在这里进行实际的提交操作，比如通过fetch发送POST请求到后端接口
    alert("密码修改成功");
    // 以下是示例的提交请求代码，需替换为真实后端接口地址及根据实际情况完善请求参数等
    fetch('https://your-api-domain/updatePwd', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            oldPwd: pwd1.value,
            newPwd: pwd2.value
        })
    }).then(response => {
        if (response.ok) {
            // 处理成功后的逻辑，比如跳转到其他页面等
            console.log("密码修改请求成功");
        } else {
            // 处理失败后的逻辑，弹出提示告知用户
            alert("密码修改失败，请稍后再试");
        }
    }).catch(error => {
        console.error("请求出现错误：", error);
        alert("网络出现问题，请检查网络连接");
    });
});