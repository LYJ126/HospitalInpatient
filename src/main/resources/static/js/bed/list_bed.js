// 模拟从后端获取数据，这里只是示例，实际中需要通过AJAX等方式从真实后端接口获取数据
function fetchData(ysxm, page) {
    return new Promise((resolve, reject) => {
        // 假设发送AJAX请求获取数据，这里用setTimeout模拟异步请求
        setTimeout(() => {
            // 这里模拟返回的数据结构，实际中根据后端接口返回的数据格式进行调整
            const mockData = {
                totalRecord: 0,
                data: []
            };
            // 假设通过fetch或者其他AJAX库向/api/listBed接口发送请求，携带ysxm（医生姓名）和page参数
            // 示例中省略真实请求代码，直接模拟返回数据
            resolve(mockData);
        }, 1000);
    });
}

let page = 1;
const pageSize = 6;
const ysxm = new URLSearchParams(window.location.search).get('ysxm');

function updatePageLinks() {
    const pageForm = document.getElementById('pageForm');
    const totalPage = Math.ceil(totalRecord / pageSize);
    const firstPageLink = document.createElement('a');
    const prevPageLink = document.createElement('a');
    const nextPageLink = document.createElement('a');
    const lastPageLink = document.createElement('a');

    if (page!== 1) {
        firstPageLink.href = `list_bed.html?ysxm=${ysxm}&Page=1`;
        firstPageLink.textContent = '第一页';
        prevPageLink.href = `list_bed.html?ysxm=${ysxm}&Page=${page - 1}`;
        prevPageLink.textContent = '上一页';
    }

    if (page!== totalPage) {
        nextPageLink.href = `list_bed.html?ysxm=${ysxm}&Page=${page + 1}`;
        nextPageLink.textContent = '下一页';
        lastPageLink.href = `list_bed.html?ysxm=${ysxm}&Page=${totalPage}`;
        lastPageLink.textContent = '最后一页';
    }

    const pageLinksContainer = pageForm.querySelector('td.tabbg.hei12');
    pageLinksContainer.innerHTML = '';
    if (page!== 1) {
        pageLinksContainer.appendChild(firstPageLink);
        pageLinksContainer.appendChild(document.createTextNode(' '));
        pageLinksContainer.appendChild(prevPageLink);
    }
    if (page!== totalPage) {
        pageLinksContainer.appendChild(document.createTextNode(' '));
        pageLinksContainer.appendChild(nextPageLink);
        pageLinksContainer.appendChild(document.createTextNode(' '));
        pageLinksContainer.appendChild(lastPageLink);
    }
    pageLinksContainer.appendChild(document.createTextNode('&nbsp;输入页数：'));
    const pageInput = document.createElement('input');
    pageInput.type = 'text';
    pageInput.name = 'Page';
    pageInput.size = 3;
    pageLinksContainer.appendChild(pageInput);
    pageLinksContainer.appendChild(document.createTextNode('页数:'));
    const pageText = document.createElement('font');
    pageText.color = 'Red';
    pageText.textContent = `${page}/${totalPage}`;
    pageLinksContainer.appendChild(pageText);
    const submitButton = document.createElement('input');
    submitButton.type = 'submit';
    submitButton.value = '提交';
    pageLinksContainer.appendChild(submitButton);
}

function displayData(data) {
    const tableBody = document.querySelector('table.table-border.margb5 tbody');
    tableBody.innerHTML = '';
    data.forEach(item => {
        const row = document.createElement('tr');
        const kebieCell = document.createElement('td');
        kebieCell.textContent = item.kebie;
        const numberCell = document.createElement('td');
        numberCell.textContent = item.number;
        const costCell = document.createElement('td');
        costCell.textContent = item.cost || "";
        const stateCell = document.createElement('td');
        stateCell.textContent = item.state || "";
        const manageCell = document.createElement('td');
        const modifyLink = document.createElement('a');
        modifyLink.href = `modifybed.html?id=${item.id}`;
        modifyLink.textContent = '修改';
        const deleteLink = document.createElement('a');
        deleteLink.href = `deletebed.html?id=${item.id}`;
        deleteLink.textContent = '删除';
        manageCell.appendChild(modifyLink);
        manageCell.appendChild(document.createTextNode(' | '));
        manageCell.appendChild(deleteLink);

        row.appendChild(kebieCell);
        row.appendChild(numberCell);
        row.appendChild(costCell);
        row.appendChild(stateCell);
        row.appendChild(manageCell);

        tableBody.appendChild(row);
    });
}

window.addEventListener('load', async () => {
    const data = await fetchData(ysxm, page);
    totalRecord = data.totalRecord;
    displayData(data.data);
    updatePageLinks();
});