function login(e) {

    if($("input[name='memId']").val() !== undefined){
        var id = $("input[name='memId']").val().trim();
        if(id.length==0){
            alert("아이디를 입력해 주세요.");
            return;
        }
    }

    if($("input[name='memPwd']").val() !== undefined){
        var password = $("input[name='memPwd']").val().trim();
        if(password.length==0){
            alert("비밀번호를 입력해 주세요.");
            return;
        }
    }

    var data = {"memId" : id, "memPwd" : password}

    $.ajax({
        type:"POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        url: "/api/login",
        dataType: "json",
        success: function(data){
            console.log(data);
        }
    })
}