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
        AjaxRequisition.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')



        var form = document.forms['formsupport'];
        var param1 = form.title.value;
        var param2 = form.description.value;
        var param3 = form.user.value;
        var param4 = form.atendant.value;
        var param5 = form.checkboxcriteria.checked;
        var param6 = form.initialdate.value;
        var param7 = form.finaldate.value;

        qstr = 'title=' + escape(param1) + "&description=" + escape(param2) + "&user=" + escape(param3) + "&atendant=" + escape(param4)
                + "&checkboxcriteria=" + escape(param5) + "&initialdate=" + escape(param6) + "&finaldate=" + escape(param7);


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
