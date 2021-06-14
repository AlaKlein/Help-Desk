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
    ipAddress = document.Equipmentform.ipAddress.value;
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

    if (vendor === "Choose") {
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

    if (ipAddress.length < 15) {
        document.Equipmentform.ipAddress.style.backgroundColor = "yellow";
        document.Equipmentform.ipAddress.focus();
        error++;
    } else {
        document.Equipmentform.ipAddress.style.backgroundColor = "white";
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

function validateDataTicketUser() {
    var error = 0;
    title = document.Ticketform.title.value;
    telephone = document.Ticketform.telephone.value;
    equipmentId = document.Ticketform.equipmentId.value;
    priority = document.Ticketform.priority.value;
    description = document.Ticketform.description.value;

    if (title.length < 5) {
        document.Ticketform.title.style.backgroundColor = "yellow";
        document.Ticketform.title.focus();
        error++;
    } else {
        document.Ticketform.title.style.backgroundColor = "white";
    }

    if (telephone.length < 9) {
        document.Ticketform.telephone.style.backgroundColor = "yellow";
        document.Ticketform.telephone.focus();
        error++;
    } else {
        document.Ticketform.telephone.style.backgroundColor = "white";
    }

    if (equipmentId === "Choose") {
        document.Ticketform.equipmentId.style.backgroundColor = "yellow";
        document.Ticketform.equipmentId.focus();
        error++;
    } else {
        document.Ticketform.equipmentId.style.backgroundColor = "white";
    }

    if (priority === "Choose") {
        document.Ticketform.priority.style.backgroundColor = "yellow";
        document.Ticketform.priority.focus();
        error++;
    } else {
        document.Ticketform.priority.style.backgroundColor = "white";
    }

    if (description.length < 1) {
        document.Ticketform.description.style.backgroundColor = "yellow";
        document.Ticketform.description.focus();
        error++;
    } else {
        document.Ticketform.description.style.backgroundColor = "white";
    }
    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataTicketItem() {
    var error = 0;
    descriptionItem = document.TicketItemform.descriptionItem.value;

    if (descriptionItem.length < 5) {
        document.TicketItemform.descriptionItem.style.backgroundColor = "yellow";
        document.TicketItemform.descriptionItem.focus();
        error++;
    } else {
        document.TicketItemform.descriptionItem.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataReportEquipByVendor() {
    var error = 0;
    vendor = document.EquipByVendor.vendor.value;

    if (vendor === "Choose") {
        document.EquipByVendor.vendor.style.backgroundColor = "yellow";
        document.EquipByVendor.vendor.focus();
        error++;
    } else {
        document.EquipByVendor.vendor.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataReportTicketByAtendant() {
    var error = 0;
    atendant = document.TicketByAtendant.atendant.value;

    if (atendant === "Choose") {
        document.TicketByAtendant.atendant.style.backgroundColor = "yellow";
        document.TicketByAtendant.atendant.focus();
        error++;
    } else {
        document.TicketByAtendant.atendant.style.backgroundColor = "white";
    }


    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validateDataReportItemByTicket() {
    var error = 0;
    ticket = document.ItemByTicket.ticket.value;

    if (ticket === "Choose") {
        document.ItemByTicket.ticket.style.backgroundColor = "yellow";
        document.ItemByTicket.ticket.focus();
        error++;
    } else {
        document.ItemByTicket.ticket.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else {
        return true;
    }
}

function validadeDateTicketSupport() {
    var dateerror = 0;
    initialdate = document.formsupport.initialdate.value;
    finaldate = document.formsupport.finaldate.value;
    const date1 = new Date(initialdate);
    const date2 = new Date(finaldate);
    if (date1 > date2) {
        document.formsupport.initialdate.style.backgroundColor = "yellow";
        document.formsupport.finaldate.style.backgroundColor = "yellow";
        dateerror++;
    } else {
        document.formsupport.initialdate.style.backgroundColor = "white";
        document.formsupport.finaldate.style.backgroundColor = "white";
    }
    if (dateerror > 0) {
        window.alert("Final date is greater than initial date!");
        return false;
    } else {
        return true;
    }
}

function validateDataReportTicketByDate() {
    var error = 0;
    var dateerror = 0;
    initialdate = document.TicketByDate.initialdate.value;
    finaldate = document.TicketByDate.finaldate.value;
    const date1 = new Date(initialdate);
    const date2 = new Date(finaldate);

    if (initialdate === "") {
        document.TicketByDate.initialdate.style.backgroundColor = "yellow";
        document.TicketByDate.finaldate.style.backgroundColor = "white";
        document.TicketByDate.initialdate.focus();
        error++;
    } else if (finaldate === "") {
        document.TicketByDate.initialdate.style.backgroundColor = "white";
        document.TicketByDate.finaldate.style.backgroundColor = "yellow";
        document.TicketByDate.finaldate.focus();
        error++;
    } else if (date1 > date2) {
        document.TicketByDate.initialdate.style.backgroundColor = "yellow";
        document.TicketByDate.finaldate.style.backgroundColor = "yellow";
        dateerror++;
    } else {
        document.TicketByDate.initialdate.style.backgroundColor = "white";
        document.TicketByDate.finaldate.style.backgroundColor = "white";
    }

    if (error > 0) {
        window.alert("Please review inserted data!");
        return false;
    } else if (dateerror > 0) {
        window.alert("Final date is greater than initial date!");
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


