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

// 获取表单元素并添加提交事件监听，替代原来HTML中内联的onclick写法，使代码结构更清晰
const addForm = document.getElementById('addForm');
addForm.addEventListener('submit', function (event) {
    if (!checkform()) {
        event.preventDefault(); // 如果验证不通过，阻止表单默认提交行为
    }
});