
// 模拟查询函数（实际中要根据真实后端接口发送请求并处理响应）
function queryData(ysxm) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const filteredData = mockData.filter(item => {
                if (ysxm && item.name.includes(ysxm)) {
                    return true;
                }
                return!ysxm;
            });
            resolve(filteredData);
        }, 1000);
    });
}

// 模拟分页相关变量
let pageSize = 6;
let currentPage = 1;
let totalPages = 1;

// 页面加载时初始化数据展示和分页
window.onload = async function () {
    const ysxm = document.querySelector('input[name="ysxm"]').value;
    const data = await queryData(ysxm);
    totalPages = Math.ceil(data.length / pageSize);
    if (totalPages === 0) totalPages = 1;
    updateTable(data, currentPage);
    updatePagination();
};

// 根据当前页更新表格数据显示
function updateTable(data, page) {
    const tableBody = document.querySelector('table.table-border tbody');
    tableBody.innerHTML = "";
    const startIndex = (page - 1) * pageSize;
    const endIndex = Math.min(startIndex + pageSize, data.length);
    for (let i = startIndex; i < endIndex; i++) {
        const item = data[i];
        const row = document.createElement('tr');
        row.innerHTML = `
      <td nowrap align="center">${item.number}</td>
      <td nowrap align="center">${item.name}</td>
      <td nowrap align="center">${item.sex}</td>
      <td nowrap align="center">${item.zhicheng}</td>
      <td nowrap align="center">${item.zhiwu}</td>
      <td nowrap align="center">${item.kebie}</td>
      <td nowrap align="center">${item.birthtime}</td>
      <td nowrap align="center">${item.worktime}</td>
      <td nowrap align="center"><a href="modifyuser.html?id=${item.id}">修改</a> | <a href="deleteuser.html?id=${item.id}">删除</a></td>
    `;
        tableBody.appendChild(row);
    }
}

// 更新分页链接显示
function updatePagination() {
    const paginationDiv = document.querySelector('form[action="list_user.html"] tr td');
    paginationDiv.innerHTML = "";
    if (currentPage!== 1) {
        const firstPageLink = document.createElement('a');
        firstPageLink.href = `list_user.html?Page=1`;
        firstPageLink.textContent = "第一页";
        paginationDiv.appendChild(firstPageLink);
        const prevPageLink = document.createElement('a');
        prevPageLink.href = `list_user.html?Page=${currentPage - 1}`;
        prevPageLink.textContent = "上一页";
        paginationDiv.appendChild(prevPageLink);
    }
    if (currentPage!== totalPages) {
        const nextPageLink = document.createElement('a');
        nextPageLink.href = `list_user.html?Page=${currentPage + 1}`;
        nextPageLink.textContent = "下一页";
        paginationDiv.appendChild(nextPageLink);
        const lastPageLink = document.createElement('a');
        lastPageLink.href = `list_user.html?Page=${totalPages}`;
        lastPageLink.textContent = "最后一页";
        paginationDiv.appendChild(lastPageLink);
    }
    const inputPage = document.createElement('input');
    inputPage.type = "text";
    inputPage.name = "Page";
    inputPage.size = 3;
    paginationDiv.appendChild(inputPage);
    const pageInfo = document.createElement('span');
    pageInfo.textContent = `页数: <font COLOR="Red">${currentPage}/${totalPages}</font>`;
    paginationDiv.appendChild(pageInfo);
    const submitButton = document.createElement('input');
    submitButton.type = "submit";
    submitButton.value = "提交";
    paginationDiv.appendChild(submitButton);
}

// 监听表单提交事件，重新查询和更新页面
const searchForm = document.querySelector('form[action="list_user.html"][method="post"]');
searchForm.addEventListener('submit', async function (e) {
    e.preventDefault();
    const ysxm = this.querySelector('input[name="ysxm"]').value;
    const data = await queryData(ysxm);
    totalPages = Math.ceil(data.length / pageSize);
    if (totalPages === 0) totalPages = 1;
    currentPage = 1;
    updateTable(data, currentPage);
    updatePagination();
});