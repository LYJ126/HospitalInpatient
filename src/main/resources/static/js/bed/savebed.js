// 模拟DataFormat.convert函数的功能，实际中需按照原函数的具体逻辑来准确处理数据格式
function convertData(data) {
    return data;
}

// 从URL中获取指定参数的值，类似JSP中获取请求参数的功能
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

// 发送异步请求更新病床信息的函数
async function updateBedInfo() {
    const id = getQueryParam('id');
    const number = convertData(getQueryParam('number'));
    const kebie = convertData(getQueryParam('kebie'));
    const cost = convertData(getQueryParam('cost'));
    const state = convertData(getQueryParam('state'));

    try {
        // 使用fetch API发送POST请求到后端更新接口，这里假设后端接口地址为/api/updateBed，需根据实际情况调整
        const response = await fetch('/api/updateBed', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id,
                number: number,
                kebie: kebie,
                cost: cost,
                state: state
            })
        });

        if (response.ok) {
            // 重定向到对应的展示列表页面，假设对应的HTML页面为list_bed.html，需根据实际项目情况确定
            window.location.href = 'list_bed.html';
        } else {
            throw new Error('更新病床信息失败');
        }
    } catch (error) {
        console.error('更新操作出错：', error);
        alert('更新病床信息时出现错误，请检查网络或联系管理员');
    }
}

// 发送异步请求插入病床信息的函数
async function insertBedInfo() {
    const number = convertData(getQueryParam('number'));
    const kebie = convertData(getQueryParam('kebie'));
    const cost = convertData(getQueryParam('cost'));
    const state = convertData(getQueryParam('state'));

    try {
        // 使用fetch API发送POST请求到后端插入接口，这里假设后端接口地址为/api/insertBed，需根据实际情况调整
        const response = await fetch('/api/insertBed', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                number: number,
                kebie: kebie,
                cost: cost,
                state: state
            })
        });

        if (response.ok) {
            window.location.href = 'list_bed.html';
        } else {
            throw new Error('插入病床信息失败');
        }
    } catch (error) {
        console.error('插入操作出错：', error);
        alert('插入病床信息时出现错误，请检查网络或联系管理员');
    }
}

// 页面加载完成后执行的逻辑，判断是执行更新还是插入操作
window.addEventListener('load', () => {
    const id = getQueryParam('id');
    if (id && parseInt(id) > 0) {
        updateBedInfo();
    } else {
        insertBedInfo();
    }
});