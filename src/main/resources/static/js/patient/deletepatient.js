// 从URL中获取参数值，类似JSP中request.getParameter的功能
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

// 发送异步请求删除病人信息数据的函数
async function deletePatientData() {
    const id = getQueryParam('id');
    if (id === null) {
        alert('缺少必要的参数id，无法进行删除操作');
        return;
    }
    try {
        // 使用fetch API发送POST请求到后端删除接口，这里假设后端接口地址为/api/deletePatient，需根据实际情况调整
        const response = await fetch('/api/deletePatient', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ id: id })
        });

        if (response.ok) {
            // 重定向到对应的列表页面，假设对应的HTML页面为list_patient.html，需根据实际项目情况确定
            window.location.href = 'list_patient.html';
        } else {
            throw new Error('删除病人信息失败');
        }
    } catch (error) {
        console.error('删除操作出错：', error);
        alert('删除病人信息时出现错误，请检查网络或联系管理员');
    }
}

window.addEventListener('load', () => {
    deletePatientData();
});