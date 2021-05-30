function loadPage(page) {

    //  document.getElementById('insere_aqui').style.display = "inline"; // mostra div    

    var AjaxRequisition = initAjax();

    if (AjaxRequisition) {
        AjaxRequisition.onreadystatechange = function () {

            if (AjaxRequisition.readyState === 4) {
                if (AjaxRequisition.status === 200 || AjaxRequisition.status === 304) {
                    document.getElementById("AjaxReturn").innerHTML = AjaxRequisition.responseText;
                }
            }
        };

        AjaxRequisition.open("POST", page, true);
        AjaxRequisition.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset:ISO8859-1')
        //contentType:"application/x-javascript; charset:ISO-8859-1"



        var form = document.forms['formequipment'];
        var param1 = form.id.value;
        var param2 = form.name.value;
        var param3 = form.vendor.value;
        var param4 = form.serial.value;
        var param5 = form.ip.value;
        var param6 = form.checkboxcriteria.checked;
       
        qstr = 'id=' + escape(param1) + '&name=' + escape(param2) + '&vendor=' + escape(param3) + '&serial=' + escape(param4) + '&ip=' + escape(param5) + "&checkboxcriteria=" + escape(param6);


        AjaxRequisition.send(qstr);
        return true;
    } else {
        return false;
    }
}

// Funcao que cria objeto Ajax XMLHttpRequest
function initAjax() {
    var objAjax = false;

    if (window.XMLHttpRequest) { // tenta carregar componente Mozilla/safari
        objAjax = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // se falhar, tenta carregar o ActiveX do IE :-(
        try {
            objAjax = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                objAjax = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (ex) {
                objAjax = false;
            }
        }
    }
    return objAjax;
}
