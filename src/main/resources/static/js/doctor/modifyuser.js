// 模拟从URL获取参数的函数（原JSP中通过request.getParameter获取参数）
function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

// 模拟通过AJAX获取教师信息数据（实际中要根据后端真实接口来调整）
function fetchTeacherInfo(id) {
    return new Promise((resolve, reject) => {
        // 这里使用setTimeout模拟异步请求的延迟效果，实际中应是真实的网络请求（如使用fetch、axios等库）
        setTimeout(() => {
            // 模拟返回的数据，实际应替换为从后端获取到的真实数据
            const mockData = {
                id: id,
                number: "001",
                name: "示例教师姓名",
                sex: "男",
                zhicheng: "中级职称",
                zhiwu: "任课教师",
                kebie: "数学",
                birthtime: "1985-01-01",
                worktime: "2010-01-01"
            };
            resolve(mockData);
        }, 1000);
    });
}

window.onload = async function () {
    const teacherId = getQueryParam('id');
    if (teacherId) {
        const teacherInfo = await fetchTeacherInfo(teacherId);
        const form = document.forms.addForm;
        form.id.value = teacherInfo.id;
        form.number.value = teacherInfo.number;
        form.name.value = teacherInfo.name;
        form.sex.value = teacherInfo.sex;
        form.zhicheng.value = teacherInfo.zhicheng;
        form.zhiwu.value = teacherInfo.zhiwu;
        form.kebie.value = teacherInfo.kebie;
        form.birthtime.value = teacherInfo.birthtime;
        form.worktime.value = teacherInfo.worktime;
    }
};

function checkform() {
    if (document.addForm.name.value === "" || document.addForm.number.value === "") {
        alert("请输入完整信息！");
        return false;
    } else {
        alert("修改成功！");
        return true;
    }
}