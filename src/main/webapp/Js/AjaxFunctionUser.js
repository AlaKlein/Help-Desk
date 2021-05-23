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



        var form = document.forms['formuser'];
        var param1 = form.title.value;
        var param2 = form.checkboxcriteria.value;
       
        qstr = 'title=' + escape(param1) + "&checkboxcriteria=" + escape(param2);


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
