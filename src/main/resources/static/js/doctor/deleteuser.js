function deleteDoctor() {
    const doctorId = document.getElementById('doctorId').value;
    if (!doctorId) {
        alert('请输入医生ID');
        return;
    }
    // 使用fetch API发送请求到后端（这里假设后端接口为 /deleteDoctor，实际按部署调整）
    fetch('/deleteDoctor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: doctorId })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('网络请求错误');
        })
        .then(data => {
            if (data.success) {
                alert('医生信息删除成功');
                // 模拟重定向，实际中如果是单页面应用可通过路由切换等方式实现类似效果，若不是则是浏览器的跳转
                window.location.href = 'list_user.jsp';
            } else {
                alert('删除失败：' + data.message);
            }
        })
        .catch(error => {
            console.error('删除操作出现错误：', error);
            alert('删除操作出现错误，请稍后再试');
        });
}