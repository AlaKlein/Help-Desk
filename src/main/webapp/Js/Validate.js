/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateDataUser() {
    var error = 0;
    email = document.Userform.email.value;
    var pattern = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    nameUser = document.Userform.name.value;
    password = document.Userform.password.value;
    statusUser = document.Userform.status.value;

    if (!email.match(pattern)) {
        document.Userform.email.style.backgroundColor = "yellow";
        document.Userform.email.focus();
        error++;
    } else {
        document.Userform.email.style.backgroundColor = "white";
    }

    if (nameUser.length < 5) {
        document.Userform.name.style.backgroundColor = "yellow";
        document.Userform.name.focus();
        error++;
    } else {
        document.Userform.name.style.backgroundColor = "white";
    }

    if (password.length < 8) {
        document.Userform.password.style.backgroundColor = "yellow";
        document.Userform.password.focus();
        error++;
    } else {
        document.Userform.password.style.backgroundColor = "white";
    }

    if (statusUser === "Choose") {
        document.Userform.status.style.backgroundColor = "yellow";
        document.Userform.status.focus();
        error++;
    } else {
        document.Userform.status.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataEquipment() {
    var error = 0;
    nameEquipment = document.Equipmentform.name.value;
    model = document.Equipmentform.model.value;
    type = document.Equipmentform.type.value;
    vendor = document.Equipmentform.vendor.value;
    serialNumber = document.Equipmentform.serialNumber.value;
    statusEquipment = document.Equipmentform.status.value;

    if (nameEquipment.length < 5) {
        document.Equipmentform.name.style.backgroundColor = "yellow";
        document.Equipmentform.name.focus();
        error++;
    } else {
        document.Equipmentform.name.style.backgroundColor = "white";
    }

    if (model.length < 3) {
        document.Equipmentform.model.style.backgroundColor = "yellow";
        document.Equipmentform.model.focus();
        error++;
    } else {
        document.Equipmentform.model.style.backgroundColor = "white";
    }

    if (type.length < 5) {
        document.Equipmentform.type.style.backgroundColor = "yellow";
        document.Equipmentform.type.focus();
        error++;
    } else {
        document.Equipmentform.type.style.backgroundColor = "white";
    }

    if (vendor.length < 5) {
        document.Equipmentform.vendor.style.backgroundColor = "yellow";
        document.Equipmentform.vendor.focus();
        error++;
    } else {
        document.Equipmentform.serialNumber.style.backgroundColor = "white";
    }

    if (serialNumber.length < 5) {
        document.Equipmentform.serialNumber.style.backgroundColor = "yellow";
        document.Equipmentform.serialNumber.focus();
        error++;
    } else {
        document.Equipmentform.serialNumber.style.backgroundColor = "white";
    }

    if (statusEquipment === "Choose") {
        document.Equipmentform.status.style.backgroundColor = "yellow";
        document.Equipmentform.status.focus();
        error++;
    } else {
        document.Equipmentform.status.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataLogin() {
    var error = 0;
    var pattern = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    email = document.Loginform.email.value;
    password = document.Loginform.password.value;

    if (!email.match(pattern)) {
        document.Loginform.email.style.backgroundColor = "yellow";
        document.Loginform.email.focus();
        error++;
    } else {
        document.Loginform.email.style.backgroundColor = "white";
    }

    if (password.length < 8) {
        document.Loginform.password.style.backgroundColor = "yellow";
        document.Loginform.password.focus();
        error++;
    } else {
        document.Loginform.password.style.backgroundColor = "white";
    }
    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}


