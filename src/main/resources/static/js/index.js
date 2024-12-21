// 可以在这里添加页面加载完成后或者其他交互相关的函数等
window.onload = function () {
    // 例如获取某个iframe元素进行操作，这里只是示例，实际可能按需求来写逻辑
    var leftFrame = document.getElementsByName('leftFrame')[0];
    if (leftFrame) {
        leftFrame.onload = function () {
            console.log('leftFrame已加载完成');
            // 可以在这里继续添加针对leftFrame加载后要做的事情，比如操作其内部的DOM元素等
        };
    }
};