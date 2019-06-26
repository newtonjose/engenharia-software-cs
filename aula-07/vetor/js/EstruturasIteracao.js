/**
 * Classe auxiliar para validar parametros passados. A classe valida tipo
 * {array} e tipo {number}.
 *
 * @type {module.ValidaParametros}
 */
class ValidaParametros {
    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'number'.
     * @param n Parametros tipo número.
     * @returns {boolean}
     */
    static verificaTipoNumero(n) {
        return typeof n == "number";
    }

    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'array'.
     * @param a Váriável do tipo array.
     * @returns {arg is Array<any>}
     */
    static verificaTipoArray(a) {
        return Array.isArray(a);
    }

    /**
     * Metódo auxiliar que verifica se um parametro é número do tipo float.
     * @param n Número inteiro.
     * @returns {boolean}
     */
    static verificaTipoFloat(n) {
        return Number(n) === n && n % 1 !== 0;
    }

    /**
     * Função auxiliar que verifica se uma data é invalida para a
     * função diaDaSemana.
     * @param d Inteiro dia da semana.
     * @param m Inteiro mes do ano.
     * @param a Inteiro ano.
     * @returns {boolean}
     */
    static validaData(d, m, a) {
        return d < 1 || d > 31 || m < 1 || m > 12 || a <= 1753;
    }

    /**
     * Método auxiliar que realiza teste sobre um array de parâmetros.
     * @param a Array de parâmetros de entrada.
     * @throws {Error} Caso a entrada seja null ou undefined.
     * @throws {TypeError} Caso a entrada não do tipo numero.
     * @throws {TypeError} Caso a entrada não seja números inteiros.
     */
    static validaEntrada(a) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] == null || a[i] === undefined) {
                throw new Error("Entrada invalidada, null e undefined nao " +
                    "sao entradas validas");
            }

            if (!ValidaParametros.verificaTipoNumero(a[i])) {
                throw new TypeError("argumento(s) valido(s) é/são do tipo " +
                    "número.");
            }

            if (ValidaParametros.verificaTipoFloat(a[i])) {
                throw new TypeError("agumento(s) deve(m) ser tipo inteiro.");
            }
        }
    }
}

class EstruturasIteracao {

    /**
     * Método que encontra a menor temperatura em um vetor.
     *
     * @param {array} temperatures Vetor de temperaturas.
     * @return {int} Menor temperatura do vetor passado como paramentro.
     * @throws {TypeError} Se o argumento 'temps' não for um array.
     * @throws {RangeError} Se o vetor de temperatura for vazio.
     * @throws {TypeError} Se algum elemento do vetor de temperaturas
     * não for do tipo número.
     */
    static encontrarMenorTemp(temps) {

        if (!ValidaParametros.verificaTipoArray(temps)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (temps.length === 0) {
            throw new RangeError("nenhuma temperatura fio informada");
        }

        temps.forEach((temp) => {
            ValidaParametros.validaEntrada(temp);
        });

        let menorTemp = temperatures[0];
        let maiorTemp = temperatures[0];

        temps.forEach((value) => {
            if (value > maiorTemp) {
                maiorTemp = value
            };

            if (value < menorTemp) {
                menorTemp = value
            };
        });

        return menorTemp;
    }
}

module.exports = EstruturasIteracao
