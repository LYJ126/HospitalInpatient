function saveDoctorInfo() {
    const number = document.getElementById('number').value;
    const name = document.getElementById('name').value;
    const sex = document.getElementById('sex').value;
    const zhicheng = document.getElementById('zhicheng').value;
    const zhiwu = document.getElementById('zhiwu').value;
    const kebie = document.getElementById('kebie').value;
    const birthtime = document.getElementById('birthtime').value;
    const worktime = document.getElementById('worktime').value;

    const data = {
        number,
        name,
        sex,
        zhicheng,
        zhiwu,
        kebie,
        birthtime,
        worktime
    };

    // 判断是否是更新操作（这里假设页面有隐藏域或者通过URL参数等方式传递id来判断更新情况，目前示例先按插入处理）
    const id = 0; // 示例先按插入情况，实际中要根据真实逻辑获取id，比如从URL参数获取等

    if (id) {
        // 如果是更新，调用更新的函数（后续完善）
        updateDoctorInfo(id, data);
    } else {
        // 调用插入的函数
        insertDoctorInfo(data);
    }
}

function insertDoctorInfo(data) {
    // 使用fetch API发送请求到后端（这里假设后端接口为 /insertDoctor，实际按部署调整）
    fetch('/insertDoctor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('网络请求错误');
        })
        .then(data => {
            if (data.success) {
                alert('医生信息插入成功');
                // 模拟重定向，实际中如果是单页面应用可通过路由切换等方式实现类似效果，若不是则是浏览器的跳转
                window.location.href = 'list_user.jsp';
            } else {
                alert('插入失败：' + data.message);
            }
        })
        .catch(error => {
            console.error('插入操作出现错误：', error);
            alert('插入操作出现错误，请稍后再试');
        });
}

function updateDoctorInfo(id, data) {
    // 使用fetch API发送请求到后端（这里假设后端接口为 /updateDoctor，实际按部署调整）
    fetch('/updateDoctor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({...data, id })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('网络请求错误');
        })
        .then(data => {
            if (data.success) {
                alert('医生信息更新成功');
                window.location.href = 'list_user.jsp';
            } else {
                alert('更新失败：' + data.message);
            }
        })
        .catch(error => {
            console.error('更新操作出现错误：', error);
            alert('更新操作出现错误，请稍后再试');
        });
}