function checkform() {
    if (document.addForm.name.value === "" || document.addForm.number.value === "") {
        alert("请输入完整信息！");
        return false;
    } else {
        alert("添加成功！");
        return true;
    }
}