function checkform() {
    const kebie = document.getElementById('addForm').kebie.value;
    const number = document.getElementById('addForm').number.value;
    if (kebie === "" || number === "") {
        alert("请输入完整信息！");
        return false;
    } else {
        alert("添加成功！");
        return true;
    }
}

window.addEventListener('load', () => {
    const addForm = document.getElementById('addForm');
    addForm.addEventListener('submit', function (event) {
        if (!checkform()) {
            event.preventDefault(); // 如果验证不通过，阻止表单默认提交行为
        } else {
            // 此处可添加与后端交互的代码，例如通过fetch发送POST请求提交表单数据
            // 假设后端接口地址为/api/addCost，需根据实际情况调整
            fetch('/api/addCost', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    kebie: addForm.kebie.value,
                    number: addForm.number.value,
                    name: addForm.name.value,
                    xiangmu: addForm.xiangmu.value,
                    danjia: addForm.danjia.value,
                    shuliang: addForm.shuliang.value,
                    jine: addForm.jine.value,
                    riqi: addForm.riqi.value
                })
            })
                .then(response => {
                    if (response.ok) {
                        // 提交成功后可进行相应处理，如跳转到某个页面，此处假设跳转到listCost.html，按需调整
                        window.location.href = 'listCost.html';
                    } else {
                        alert('添加收费信息失败，请检查网络或联系管理员');
                    }
                })
                .catch(error => {
                    console.error('提交表单数据出错：', error);
                    alert('发生网络错误，无法添加收费信息');
                });
        }
    });
    // 为日期输入框添加日期选择功能，调用引入的WdatePicker.js插件提供的功能
    const riqiInput = document.getElementsByName('riqi')[0];
    riqiInput.onfocus = function () {
        WdatePicker({ readOnly: true });
    };
});