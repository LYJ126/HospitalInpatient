function showsubmenu(sid) {
    const whichEl = document.getElementById("submenu" + sid);
    if (whichEl.style.display === "none") {
        whichEl.style.display = "";
    } else {
        whichEl.style.display = "none";
    }
}

function loginout() {
    window.location.href = "login.html";
}