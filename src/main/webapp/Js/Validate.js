/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateData() {
    var error = 0;
    email = document.Userform.email.value;
    window.alert(email);
//    name = document.Userform.name.value;
//    password = document.Userform.password.value;
//    status = document.Userform.status.value;

    if (email.length < 5)
    {
        document.Userform.email.style.backgroundColor = "yellow";
        document.Userform.email.focus();
        error++;
    } else {
        document.Userform.email.style.backgroundColor = "white";
    }
    
//     if (name.length < 1 || name.length > 1)
//    {
//        document.Userform.name.style.backgroundColor = "yellow";
//        error++;
//    } else {
//        document.Userform.name.style.backgroundColor = "white";
//    }
    
    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

