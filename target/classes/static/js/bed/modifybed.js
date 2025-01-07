// 获取URL中的参数，这里假设id参数通过查询字符串的方式传递，例如?id=123
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

async function fetchBedData(id) {
    // 这里假设通过fetch API向/api/getBedById接口发送请求获取对应id的病床数据，实际需根据后端接口调整
    const response = await fetch(`/api/getBedById?id=${id}`);
    if (response.ok) {
        return response.json();
    } else {
        throw new Error('获取病床数据失败');
    }
}

function checkform() {
    const kebie = document.getElementById('addForm').kebie.value;
    const number = document.getElementById('addForm').number.value;
    if (kebie === "" || number === "") {
        alert("请输入完整信息！");
        return false;
    } else {
        alert("修改成功！");
        return true;
    }
}

window.addEventListener('load', async () => {
    const id = getQueryParam('id');
    if (id) {
        const bedData = await fetchBedData(id);
        const addForm = document.getElementById('addForm');
        addForm.id.value = bedData.id;
        addForm.kebie.value = bedData.kebie;
        addForm.number.value = bedData.number;
        addForm.cost.value = bedData.cost;
        addForm.state.value = bedData.state;
    }
    const addForm = document.getElementById('addForm');
    addForm.addEventListener('submit', function (event) {
        if (!checkform()) {
            event.preventDefault(); // 如果验证不通过，阻止表单默认提交行为
        }
    });
});