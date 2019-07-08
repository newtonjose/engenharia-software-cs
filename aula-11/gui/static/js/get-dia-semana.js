const URL = "http://" + host + ":" + port + "/ds?";

function atualizaDiaDaSemana() {
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("resultado").innerHTML =
                extraiDiaDaSemanaDaResposta(xhttp.responseText);
        } else if (this.status === 0) {
            console.log("Error: Service NotFound!");
            document.getElementById("resultado").innerHTML =
                "Service NotFound";
        } else if (this.status !== 200) {
            console.error(xhttp.responseText);

            const respTextObj = JSON.parse(xhttp.responseText);
            document.getElementById("resultado").innerHTML =
                respTextObj['message'];
        }
    };

    const dataInicial = document.getElementById("datai").value;
    const dataFinal = document.getElementById("dataf").value;
    const data_i = formataData(dataInicial);
    const data_f = formataData(dataFinal);
    const parametros = "dataI=" + data_i + "&" + "dataF=" + data_f;
    console.debug(URL + parametros);
    xhttp.open("GET", URL + parametros, true);
    xhttp.send();
}

// function dataCorrente() {
//     document.getElementById("data").valueAsDate = new Date();
// }

// Funções para integração (satisfazer contrato do servidor)

function extraiDiaDaSemanaDaResposta(resposta) {
    return JSON.parse(resposta).diaDaSemana;
}

// Dia ou mês deve possuir dois dígitos
function formataDiaOuMes(n) {
    return ("00" + n).substr(-2, 2);
}

// Ano deve possuir quatro dígitos
function formataAno(n) {
    return ("0000" + n).substr(-4,4);
}

// ENTRADA: ano-mes-dia SAIDA: dd-mm-yyyy
function formataData(data) {
    let [a, m, d] = data.split("-");

    formataDiaOuMes(d);
    formataDiaOuMes(m);
    formataAno(a);

    return `${d}-${m}-${a}`;
}
