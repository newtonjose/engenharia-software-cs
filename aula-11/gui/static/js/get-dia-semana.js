// Path para a requisição (URL)

//TODO: usar variável local ou config
const PATH = "http://localhost:8000/ds?data=";

function atualizaDiaDaSemana() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let dds = extraiDiaDaSemanaDaResposta(xhttp.responseText);
            document.getElementById("resultado").innerHTML = dds;
        } else if (this.status === 0) {
            console.log("Error: Service NotFound!");
            document.getElementById("resultado").innerHTML =
                "Service NotFound";
        } else {
            console.error(xhttp.responseText);

            const respTextObj = JSON.parse(xhttp.responseText);
            document.getElementById("resultado").innerHTML =
                respTextObj['message'];
        }
    };

    const dataAnoMesDia = document.getElementById("data").value;
    const data = formataData(dataAnoMesDia);
    xhttp.open("GET", PATH + data, true);
    xhttp.send();
}

function dataCorrente() {
    document.getElementById("data").valueAsDate = new Date();
}

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
