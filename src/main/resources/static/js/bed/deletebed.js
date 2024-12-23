// 获取URL中的参数，这里假设id参数通过查询字符串的方式传递，例如?id=123
function getQueryParam(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

const id = getQueryParam('id');
if (id === null) {
    alert('缺少必要的参数id，无法进行删除操作');
    // 这里可以根据实际情况决定如何处理，比如跳转到某个错误页面等，示例中仅做提示
} else {
    // 这里假设使用fetch API来模拟向后端发送删除请求，实际中需要替换为真实的后端接口地址和处理逻辑
    // 示例中假设后端接口地址为 /api/deleteBed，并且后端接收一个名为id的参数来执行删除操作
    fetch('/api/deleteBed', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: id })
    })
        .then(response => {
            if (response.ok) {
                // 重定向到 list_bed.html页面，假设原JSP中的list_bed.jsp对应的HTML页面是list_bed.html
                window.location.href = 'list_bed.html';
            } else {
                alert('删除操作失败，请检查网络或联系管理员');
            }
        })
        .catch(error => {
            console.error('发生错误：', error);
            alert('发生网络错误，无法完成删除操作');
        });
}