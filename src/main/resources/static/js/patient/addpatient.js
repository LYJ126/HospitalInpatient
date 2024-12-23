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
            // 收集表单数据
            const formData = {
                kebie: addForm.kebie.value,
                number: addForm.number.value,
                name: addForm.name.value,
                sex: addForm.sex.value,
                age: addForm.age.value,
                bingzheng: addForm.bingzheng.value,
                doctor: addForm.doctor.value,
                ruyuan: addForm.ruyuan.value,
                chuyuan: addForm.chuyuan.value
            };
            // 使用fetch API发送POST请求到后端添加接口，这里假设后端接口地址为/api/addPatient，需根据实际情况调整
            fetch('/api/addPatient', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
                .then(response => {
                    if (response.ok) {
                        // 提交成功后可进行相应处理，如跳转到某个页面，此处假设跳转到listPatient.html，按需调整
                        window.location.href = 'listPatient.html';
                    } else {
                        alert('添加病人信息失败，请检查网络或联系管理员');
                    }
                })
                .catch(error => {
                    console.error('提交表单数据出错：', error);
                    alert('发生网络错误，无法添加病人信息');
                });
        }
    });
    // 为入院日期和出院日期输入框添加日期选择功能，调用引入的WdatePicker.js插件提供的功能
    const ruyuanInput = document.getElementsByName('ruyuan')[0];
    ruyuanInput.onfocus = function () {
        WdatePicker({ readOnly: true });
    };
    const chuyuanInput = document.getElementsByName('chuyuan')[0];
    chuyuanInput.onfocus = function () {
        WdatePicker({ readOnly: true });
    };
});