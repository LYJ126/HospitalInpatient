// 获取页面中的表单元素
const patientForm = document.getElementById('patientForm');

// 为表单的提交事件添加监听器
patientForm.addEventListener('submit', async function (event) {
    event.preventDefault(); // 阻止表单默认提交行为，便于后续使用AJAX进行数据提交

    // 获取表单各字段的值，并进行简单的数据格式转换（可根据实际需求完善）
    const number = document.getElementById('number').value;
    const kebie = document.getElementById('kebie').value;
    const name = document.getElementById('name').value;
    const sex = document.getElementById('sex').value;
    const chuyuan = document.getElementById('chuyuan').value;
    const age = document.getElementById('age').value;
    const bingzheng = document.getElementById('bingzheng').value;
    const doctor = document.getElementById('doctor').value;
    const ruyuan = document.getElementById('ruyuan').value;
    const id = document.getElementById('id').value === '0'? 0 : parseInt(document.getElementById('id').value);

    // 根据id判断是执行插入还是更新操作，构建对应的请求URL和请求方法
    let url, method;
    if (id === 0) {
        url = 'https://your-api-domain/api/patients'; // 替换为真实的后端插入患者信息接口地址
        method = 'POST';
    } else {
        url = `https://your-api-domain/api/patients/${id}`; // 替换为真实的后端更新患者信息接口地址，包含具体患者ID
        method = 'PUT';
    }

    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                number: number,
                kebie: kebie,
                name: name,
                sex: sex,
                chuyuan: chuyuan,
                age: age,
                bingzheng: bingzheng,
                doctor: doctor,
                ruyuan: ruyuan
            })
        });

        if (response.ok) {
            // 如果请求成功，重定向到查看患者列表页面（此处假设为list_patient.html，需替换为真实页面）
            window.location.href = 'list_patient.html';
        } else {
            // 如果请求失败，弹出提示框告知用户
            alert('操作失败，请检查输入信息后重试');
        }
    } catch (error) {
        console.error('请求出现错误：', error);
        alert('网络出现问题，请检查网络连接');
    }
});