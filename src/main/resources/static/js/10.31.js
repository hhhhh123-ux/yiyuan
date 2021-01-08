function fnLogin() {
    var oUname = document.getElementById("mobile");
    var oUpass = document.getElementById("password");
    var oUpass1 = document.getElementById("password1");
    oError.innerHTML = "<br>";
    if (oUname.value.length<6||oUname.value.length>20){
        oError.innerHTML="用户名要6-20位";
        return;
    }
    if (oUpass.value.length<6||oUpass.value.length>20){
        oError.innerHTML="密码至少6-20位";
        return;
    }
    if (oUpass1.value!=oUpass.value){
        oError.innerHTML="密码不一致,请重新输入";
        return;
    }
    window.alert("注册成功！")
}