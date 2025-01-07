// 模拟通过AJAX获取用户信息（这里只是示例，实际中需要替换成真实的接口请求等）
function getUserInfo() {
    return new Promise((resolve, reject) => {
        // 假设这里是一个假的异步操作，模拟获取用户信息
        setTimeout(() => {
            const username = "示例用户名"; // 实际应该是从接口获取
            const usertype = "示例用户类型"; // 实际应该是从接口获取
            resolve({ username, usertype });
        }, 1000);
    });
}

// 页面加载完成后执行获取用户信息并填充到对应位置的操作（这里简单演示填充用户名）
window.onload = async function () {
    try {
        const userInfo = await getUserInfo();
        const currentUserLink = document.querySelector('.top-link[href="#"]');
        if (currentUserLink) {
            currentUserLink.textContent += userInfo.username;
        }
    } catch (error) {
        console.error("获取用户信息出错:", error);
    }
};