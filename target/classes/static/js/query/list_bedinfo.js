// 模拟DataFormat.convert函数的功能，实际中需按照原函数的具体逻辑来准确处理数据格式
function convertData(data) {
    return data;
}

// 从URL中获取指定参数的值，类似JSP中request.getParameter的功能
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

// 发送异步请求获取数据的函数，根据查询条件和页码获取对应的数据
async function fetchBedInfoData(queryParams, page, pageSize) {
    try {
        const params = {
            page: page,
            pageSize: pageSize,
            ...queryParams
        };
        // 使用fetch API发送POST请求到后端获取数据接口，这里假设后端接口地址为/api/listBedInfo，需根据实际情况调整
        const response = await fetch('/api/listBedInfo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(params)
        });
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('获取病床利用率相关数据失败');
        }
    } catch (error) {
        console.error('获取数据出错：', error);
        return { totalRecord: 0, data: [] };
    }
}

// 根据获取到的数据更新页面表格内容
function updateTableData(data) {
    const tableBody = document.querySelector('table.table-border.margb5 tbody');
    tableBody.innerHTML = '';
    data.forEach(item => {
        const row = document.createElement('tr');
        const kebieCell = document.createElement('td');
        kebieCell.textContent = item.kebie;
        const numberCell = document.createElement('td');
        numberCell.textContent = item.number;
        const nameCell = document.createElement('td');
        nameCell.textContent = item.name || "";
        const sexCell = document.createElement('td');
        sexCell.textContent = item.sex || "";
        const ageCell = document.createElement('td');
        ageCell.textContent = item.age || "";
        const bingzhengCell = document.createElement('td');
        bingzhengCell.textContent = item.bingzheng || "";
        const doctorCell = document.createElement('td');
        doctorCell.textContent = item.doctor || "";
        const ruyuanCell = document.createElement('td');
        ruyuanCell.textContent = item.ruyuan || "";
        const chuyuanCell = document.createElement('td');
        chuyuanCell.textContent = item.chuyuan || "";

        row.appendChild(kebieCell);
        row.appendChild(numberCell);
        row.appendChild(nameCell);
        row.appendChild(sexCell);
        row.appendChild(ageCell);
        row.appendChild(bingzhengCell);
        row.appendChild(doctorCell);
        row.appendChild(ruyuanCell);
        row.appendChild(chuyuanCell);

        tableBody.appendChild(row);
    });
}

// 根据总记录数和当前页码等信息更新分页链接
function updatePageLinks(totalRecord, page, pageSize) {
    const pageForm = document.getElementById('pageForm');
    const totalPage = Math.ceil(totalRecord / pageSize);
    const pageLinksContainer = pageForm.querySelector('td.tabbg.hei12');
    pageLinksContainer.innerHTML = '';
    if (page!== 1) {
        const firstPageLink = document.createElement('a');
        firstPageLink.href = `listBedInfo.html?Page=1`;
        firstPageLink.textContent = '第一页';
        pageLinksContainer.appendChild(firstPageLink);
        pageLinksContainer.appendChild(document.createTextNode(' '));
        const prevPageLink = document.createElement('a');
        prevPageLink.href = `listBedInfo.html?Page=${page - 1}`;
        prevPageLink.textContent = '上一页';
        pageLinksContainer.appendChild(prevPageLink);
    }
    if (page!== totalPage) {
        const nextPageLink = document.createElement('a');
        nextPageLink.href = `listBedInfo.html?Page=${page + 1}`;
        nextPageLink.textContent = '下一页';
        pageLinksContainer.appendChild(nextPageLink);
        pageLinksContainer.appendChild(document.createTextNode(' '));
        const lastPageLink = document.createElement('a');
        lastPageLink.href = `listBedInfo.html?Page=${totalPage}`;
        lastPageLink.textContent = '最后一页';
        pageLinksContainer.appendChild(lastPageLink);
    }
    pageLinksContainer.appendChild(document.createTextNode('&nbsp;输入页数：'));
    const pageInput = document.createElement('input');
    pageInput.type = 'input';
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

window.addEventListener('load', async () => {
    const kebie = convertData(getQueryParam('kebie'));
    const doctor = convertData(getQueryParam('doctor'));
    const startdate = getQueryParam('sksjs');
    const enddate = getQueryParam('sksje');
    const queryParams = {
        kebie: kebie,
        doctor: doctor,
        startdate: startdate,
        enddate: enddate
    };
    const page = getQueryParam('Page')? parseInt(getQueryParam('Page')) : 1;
    const pageSize = 6;
    const bedInfoData = await fetchBedInfoData(queryParams, page, pageSize);
    const { totalRecord, data } = bedInfoData;
    updateTableData(data);
    updatePageLinks(totalRecord, page, pageSize);
    // 为查询表单添加提交事件监听，重新获取数据并更新页面
    const searchForm = document.getElementById('searchForm');
    searchForm.addEventListener('submit', async (event) => {
        event.preventDefault();
        const newQueryParams = {
            kebie: searchForm.kebie.value,
            doctor: searchForm.doctor.value,
            startdate: searchForm.sksjs.value,
            enddate: searchForm.sksje.value
        };
        const newBedInfoData = await fetchBedInfoData(newQueryParams, 1, pageSize);
        const { totalRecord: newTotalRecord, data: newData } = newBedInfoData;
        updateTableData(newData);
        updatePageLinks(newTotalRecord, 1, pageSize);
    });
});