// 模拟DataFormat.convert函数的功能，实际中需按照原函数的具体逻辑来准确处理数据格式
function convertData(data) {
    return data;
}

// 从URL中获取指定参数的值，类似JSP中request.getParameter的功能
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

// 发送异步请求更新数据的函数
async function updateCostData() {
    const id = getQueryParam('id');
    if (id === null) {
        alert('缺少必要的参数id，无法进行更新操作');
        return;
    }
    const number = convertData(getQueryParam('number'));
    const kebie = convertData(getQueryParam('kebie'));
    const name = convertData(getQueryParam('name'));
    const xiangmu = convertData(getQueryParam('xiangmu'));
    const danjia = convertData(getQueryParam('danjia'));
    const shuliang = convertData(getQueryParam('shuliang'));
    const jine = convertData(getQueryParam('jine'));
    const riqi = convertData(getQueryParam('riqi'));

    try {
        // 使用fetch API发送POST请求到后端更新接口，这里假设后端接口地址为/api/updateCost，需根据实际情况调整
        const response = await fetch('/api/updateCost', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                number: number,
                kebie: kebie,
                name: name,
                xiangmu: xiangmu,
                danjia: danjia,
                shuliang: shuliang,
                jine: jine,
                riqi: riqi
            })
        });

        if (response.ok) {
            // 重定向到对应的列表页面，假设对应的HTML页面为list_cost.html，需根据实际项目情况确定
            window.location.href = 'list_cost.html';
        } else {
            throw new Error('更新病人费用信息失败');
        }
    } catch (error) {
        console.error('更新操作出错：', error);
        alert('更新病人费用信息时出现错误，请检查网络或联系管理员');
    }
}

// 发送异步请求插入数据的函数
async function insertCostData() {
    const number = convertData(getQueryParam('number'));
    const kebie = convertData(getQueryParam('kebie'));
    const name = convertData(getQueryParam('name'));
    const xiangmu = convertData(getQueryParam('xiangmu'));
    const danjia = convertData(getQueryParam('danjia'));
    const shuliang = convertData(getQueryParam('shuliang'));
    const jine = convertData(getQueryParam('jine'));
    const riqi = convertData(getQueryParam('riqi'));

    try {
        // 使用fetch API发送POST请求到后端插入接口，这里假设后端接口地址为/api/insertCost，需根据实际情况调整
        const response = await fetch('/api/insertCost', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                number: number,
                kebie: kebie,
                name: name,
                xiangmu: xiangmu,
                danjia: danjia,
                shuliang: shuliang,
                jine: jine,
                riqi: riqi
            })
        });

        if (response.ok) {
            window.location.href = 'list_cost.html';
        } else {
            throw new Error('插入病人费用信息失败');
        }
    } catch (error) {
        console.error('插入操作出错：', error);
        alert('插入病人费用信息时出现错误，请检查网络或联系管理员');
    }
}

window.addEventListener('load', () => {
    const id = getQueryParam('id');
    if (id && parseInt(id) > 0) {
        updateCostData();
    } else {
        insertCostData();
    }
});