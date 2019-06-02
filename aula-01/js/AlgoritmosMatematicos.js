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
    verificaTipoNumero(n) {
        return typeof n == "number";
    }

    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'array'.
     * @param a Váriável do tipo array.
     * @returns {arg is Array<any>}
     */
    verificaTipoArray(a) {
        return Array.isArray(a);
    }

    /**
     * Metódo auxiliar que verifica se um parametro é número do tipo float.
     * @param n Número inteiro.
     * @returns {boolean}
     */
    verificaTipoFloat(n) {
        return Number(n) === n && n % 1 !== 0;
    }

    /**
     * Verifica se os elementos de um array de parametros é do tipo número.
     *
     * @param {array} prts Array de numeros.
     * @returns {boolean} true ou false Valor lógico.
     **/
    validaParametrosTipoNumero(prts) {
        for (let i = 0; i < prts.length; i++) {
            if (!this.verificaTipoNumero(prts[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Função auxiliar que verifica se uma data é invalida para a
     * função diaDaSemana.
     * @param d Inteiro dia da semana.
     * @param m Inteiro mes do ano.
     * @param a Inteiro ano.
     * @returns {boolean}
     */
    validaData(d, m, a) {
        return d < 1 || d > 31 || m < 1 || m > 12 || a <= 1753;
    }

    /**
     * Método auxiliar que realiza teste sobre um array de parâmetros.
     * @param a Array de parâmetros de entrada.
     * @throws {Error} Caso a entrada seja null ou undefined.
     * @throws {TypeError} Caso a entrada não do tipo numero.
     * @throws {TypeError} Caso a entrada não seja números inteiros.
     */
    validaEntrada(a) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] == null || a[i] == undefined) {
                throw new Error("Entrada invalidada, null e undefined nao " +
                    "sao entradas validas");
            }
            
            if (!this.verificaTipoNumero(a[i])) {
                throw new TypeError("argumento(s) valido(s) é/são do tipo " + 
                    "número.");
            }

            if (this.verificaTipoFloat(a[i])) {
                throw new TypeError("agumento(s) deve(m) ser tipo inteiro.");
            }
        }
    }
}

const vp = new ValidaParametros();

/**
 * 21 algoritmos matemáticos com o propósito de fazer aquecimento em
 * Construção de Software.
 *
 * <p>Os algoritmos implementados estão disponíveis na
 * <a href="https://drive.google.com/file/d/1zCxtSyjkEvF6T3ieJ0r3_BJii9kx-FMI"/>
 * aula 01.</p>
 *
 * @type {module.Algoritmos}
 */
class Algoritmos {

    /**
     * Verifica se um dado numero é verdadeiro usando a Propriedade 3025.
     *
     * @param {number} n Numero inteiro natural.
     *
     * @returns {boolean} true ou false Valor lógico.
     **/
    static propriedade3025(n) {
        vp.validaEntrada([n]);

        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("Argumento deve ser um número");
        }

        if (n < 0 || n > 9999) {
            throw new RangeError("O numeros devem ser 0 ≤ n ≤ 9999");
        }

        if (vp.verificaTipoFloat(n)) {
            throw new RangeError("O numeros devem ser tipo inteiro.");
        }

        const m = Math.floor(n / 100);
        const p = n % 100;
        const s = m + p;

        return s * s === n;
    }

    /**
     * Verifica se a soma dos cubos dos digitos de um dado número é
     * igual ao número dado.
     *
     * @param {number} n Numero inteiro natural.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo 100 a 999.
     **/
    static propriedade153(n) {
        vp.validaEntrada([n]);

        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("Argumento deve ser um número");
        }

        if (n < 100 || n > 999) {
            throw new RangeError("O numeros devem ser 100 <= n <= 999");
        }

        const c = Math.floor(n / 100);
        const du = n % 100;
        const d = Math.floor(du / 10);
        const u = du % 10;
        const s = c * c * c + d * d * d + u * u * u;

        return s === n;
    }

    /**
     * A função implementa um algoritmo que dado uma data retorna o dia
     * semana, 1 - segunda; 2 - terça, 3 ...
     *
     * @param {number} dia Numero natural menor ou igual a 31.
     * @param {number} mes Número natural menor ou igual a 12.
     * @param {number} ano Número natural maior ou igual a 1753.
     *
     * @returns {number} Numero natural entre 0 e 8.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiver fora dos seguintes
     * intervalos: 1 <= dia <= 31; 1 <= mes <= 12 e ano > 1753.
     **/
    static diaDaSemana(dia, mes, ano) {
        vp.validaEntrada([dia, mes, ano]);

        if (vp.validaData(dia, mes, ano)) {
            throw new RangeError("A data é invalida! Para uma data valida " +
                "1 <= dia <= 31, 1 <= mes <= 12 e ano > 1753!");
        }


        if (mes === 1 || mes === 2) {
            mes = mes + 12;
            ano = ano - 1;
        }

        const i = dia + 2 * mes + (3 * (mes + 1)) / 5;
        const j = ano + (ano / 4) - (ano / 100) + (ano / 400);
        const s = i + j;

        return Math.floor(s % 7);
    }

    /**
     * Dado dois numeros, está função encontra o resto da divisão
     * de x por y.
     *
     * @param {number} x Numero racional.
     * @param {number} y Número racional.
     *
     * @returns {number} resto Número inteiro natural.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiver fora dos intervalos:
     * y >= 0; x > 0.
     **/
    static restoDivisaoInteira(x, y) {
        vp.validaEntrada([x, y]);

        if (x < 0 || y <= 0) {
            throw new RangeError("Os numeros devem ser y >= 0 && x > 0");
        }

        let resto = x;
        while (y <= resto) {
            resto = resto - y;
        }

        return resto;
    }

    /**
     * Dado um número natural, soma os todos os primeiros naturais
     * ate o dado número.
     *
     * @param {number} n Número inteiro natural.
     *
     * @returns {number} s Número inteiro natural.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static somaNaturais(n) {
        vp.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser n >= 1");
        }

        let s = 1;
        for(let i = 2; i <= n; i++) {
            s = s + i;
        }

        return s;
    }

    /**
     * Calcula o fatorial de um dado numero natural sem usar
     * recursividade.
     *
     * @param {number} n Número inteiro natural.
     *
     * @returns {number} fat Número inteiro natural.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static fatorialNumero(n) {
        vp.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O argumento deve ser maior ou igual a 1.");
        }

        let i = 2;
        let fat = 1;
        while (i <= n) {
            fat = fat * i;
            i += 1;
        }

        return fat;
    }

    /**
     * Dado dois numeros inteiros a função calcula o produto dos dois
     * usando somatório.
     *
     * @param {number} a Número inteiro natural.
     * @param {number} b Número inteiro natural.
     *
     * @returns {number} prod Número inteiro natural.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiverem fora dos intervalos:
     * a >= 0; b >= 0.
     **/
    static produtoInteiros(a, b) {
        vp.validaEntrada([a, b]);

        if (a < 0 || b < 0) {
            throw new RangeError("Os argumentos devem ser: a >= 0; b >= 0");
        }

        let totalParcelas = a;
        let parcela = b;
        if (b < a) {
            totalParcelas = b;
            parcela = a;
        }

        let i = 1;
        let prod = 0;
        while (i <= totalParcelas) {
            prod = prod + parcela;
            i += 1; //TODO: Use o for
        }

        return prod;
    }

    /**
     * Calcula a potência de dois numeros usando apenas somas.
     *
     * @param {number} x Numero inteiro natural.
     * @param {number} y Número inteiro natural.
     *
     * @returns {number} p Número inteiro natural.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiver fora dos intervalos:
     * x >= 0; y >= 0.
     **/
    static calculaPotencia(x, y) {
        vp.validaEntrada([x, y]);

        if (x < 0 || y < 0) {
            throw new RangeError("Os argumentos devem ser: x >= 0; y >= 0");
        }

        let p = 1;
        let i = 1;
        while (i <= y) {
            p = Algoritmos.produtoInteiros(p, x);
            i += 1; //TODO: Use o for
        }

        return p;
    }

    /**
     * Retorna o valor de Pi aproximado pelo um dado número.
     *
     * @param {number} n Numero inteiro natural.
     *
     * @returns {number} pi Número racional positivo.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static valorPi(n) {
        vp.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero num tem que ser num >= 1");
        }

        let i = 1;
        let s = -1;
        let d = -1;
        let pi = 0;

        while (i <= n) {
            d = d + 2;
            s = s * -1;
            pi = pi + (4 * s) / d;
            i += 1; //TODO: Use o for
        }

        return pi;
    }

    /**
     * Calcula o logaritmo natural de um dado número usando uma
     * aproximação.
     *
     * @param {number} n Numero inteiro natural.
     * @param {number} k Numero inteiro nartual usado como o fator de
     * aproximação.
     *
     * @returns {number} e Número racional positivo.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiver fora dos intervalos:
     * n >= 1; k >= 2.
     **/
    static logaritmoNatural(n, k) {
        vp.validaEntrada([n, k]);

        if (n < 1 || k < 2) {
            throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
        }

        let i = 2;
        let e = n + 1;
        let numerador = n;
        let denominador = 1;

        while (i <= k) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            e = e + (numerador / denominador);
            i += 1; //TODO: Use o for
        }

        return e;
    }

    /**
     * Calcula a razão área através do processo iniciado com dois
     * números inteiros positivos e um valor que determina a precisão.
     *
     * @param {number} x Numero inteiro natural.
     * @param {number} y Numero inteiro natural.
     * @param {number} k Numero inteiro natural usado como fator de prescisão.
     *
     * @returns {number} c/a Número racional positivo.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiverem fora dos intervalos:
     * x >= 0; x < y e k > 0.
     **/
    static razaoAurea(x, y, k) {
        vp.validaEntrada([x, y, k]);

        if ((x < 0 || x > y) || k <= 0) {
            throw new RangeError("Números deve ser: x >= 0, x < y e k > 0");
        }

        let c = y;
        let a = x;
        let i = 1;

        while (i <= k) {
            const t = c;
            c = c + a;
            a = t;
            i += 1; //TODO: Use o for
        }

        return c / a;
    }

    /**
     * Verifica se o dado número é um quadrado perefeito, satisfazendo
     * esquação do algoritmo.
     *
     * @param {number} n Número inteiro.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static quadradoPerfeito(n) {
        vp.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero 'n' deverá ser maior que 1");
        }

        let i = 1;
        let s = 1;

        while (s < n) {
            i = i + 2;
            s = s + i;
        }

        return s == n;
    }

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     *
     * @param {number} n Número racional positivo.
     * @param {number} prescisao Numero inteiro nartual usado como o fator de
     * prescisão.
     *
     * @returns {number} r Número racional positivo.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiverem fora dos intervalos:
     * n > 0.
     **/
    static raizQuadrada(n, prescisao) {
        vp.validaEntrada([n, prescisao]);

        if (n < 0) {
            throw new RangeError("O numero 'n' deverá ser maior que 0");
        }

        let r = 1;

        while (prescisao >= 0) {
            r = (r + n / r) / 2;
            prescisao = prescisao - 1;
        }

        return r;
    }

    /**
     * Verifica se um número é primo quando seus únicos divisores são 1
     * ou ele mesmo.
     *
     * @param {number} n Número inteiro natural.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static numeroPrimo(n) {
        vp.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser maior que 1");
        }

        let i = 2;

        while (i < n) {
            if (n % i == 0) {
                return false;
            }

            i += 1; //TODO: Use o for
        }

        return true;
    }

    /**
     * Verifica se um dado número é primo usando o método
     * Crivo de Erastóstenes.
     *
     * @param {number} n Número inteiro natural.
     * @param {array} a Array de inteiros, com valores iguais a zero.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {TypeError} Se o argumento a não for um array.
     * @throws {RangeError} Se o argumento estiver for do intervalo: n > 1.
     * @throws {RangeError} Se o argumento array tiver valor diferente de zero.
     **/
    static crivoErastostenes(n, a) {
        vp.validaEntrada([n]);

        for (let j = 0; j < n; j++) {
            vp.validaEntrada(a[j]);
        }
        
        if (!vp.verificaTipoArray(a)) {
            throw new TypeError("O argumento a deve ser do tipo array.");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser maior que 1");
        }

        // busca por valores diferente de zero
        for (let i = 2; i < n; i++) {
            if (a[i] != 0) {
                throw new RangeError("Existe valores em a, onde nao sao " +
                    "iguais a zero");
            }
        }


        let i = 2;
        const limite = Math.sqrt(n);
        while (i <= limite) {
            if (a[i] == 0) {
                let multiplo = i + 1;

                while (multiplo <= n) {
                    a[multiplo] = 1;
                    multiplo = multiplo + i;
                }
            }

            i += 1; //TODO: Use o for
        }

        return a[n - 1] == 1;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros.
     *
     * @param {number} a Número inteiro natural.
     * @param {number} b Número inteiro natural.
     *
     * @returns {number} a Número inteiro natural.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiverem fora dos intervalos:
     * a >= b e b > 0.
     **/
    static maiorDivisorComum(a, b) {
        vp.validaEntrada([a, b]);

        if (b > a || b < 0) {
            throw new RangeError("Os numeros deverao ser a >= b e b > 0");
        }

        while (b !== 0) {
            const m = a % b;
            a = b;
            b = m;
        }

        return a;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros
     * sem usar resto da divisão inteira.
     *
     * @param {number} b Número inteiro natural.
     * @param {array} a Array de números inteiros naturais.
     *
     * @returns {array} a Máximo divisor comum de a e b.
     *
     * @throws {TypeError} Se o primeiro argumento não for um número.
     * @throws {RangeError} Se o primeiro argumento estiver fora do intervalo:
     * b > 0.
     **/
    static maiorDivisorComumSemResto(b, a) {
        vp.validaEntrada([a, b]);

        if (b < 0) {
            throw new RangeError("Os numero deverao 'b tem que ser " +
                "maior que zero!");
        }

        while (a !== b) {
            // 'a' sempre sera maior que 'b' pelo if anterior
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    /**
     * Avalia um polinônimo por meio de somas, produtos e potências.
     *
     * @param {number} x Número real.
     * @param {number} g Número real.
     * @param {array} a Array de numeros rais.
     *
     * @returns {number} p Número real.
     *
     * @throws {TypeError} Se os dois primeiros argumentos não forem um número.
     * @throws {TypeError} Se o terceiro argumento não for um array.
     * @throws {RangeError} Se o segundo argumento estiver for do intervalo:
     * g > 1.
     **/
    static regraHorner(x, g, a) {
        vp.validaEntrada([x, g]);

        if (!vp.verificaTipoArray(a)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (g < 1) {
            throw new RangeError("o agumento g deve ser maior que zero");
        }

        let p = a[g - 1];
        let i = g - 1;
        while (i >= 0) {
            p = p * x + a[i];
            i -= 1; //TODO: Use o for
        }

        return p;
    }

    /**
     * Calcula o número de Fibonacci sem usar recursividade.
     *
     * @param {number} n Número inteiro natural.
     *
     * @returns {number} f Número inteiro natural.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 0.
     **/
    static fibonacci(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento n deve ser um número");
        }

        if (n <= 0) {
            throw new RangeError("O argumento 'n' tem que ser n>=0");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        let a = 0;
        let f = 1;
        let i = 1;
        while (i <= n) {
            const t = f;
            f = f + a;
            a = t;
            i += 1; //TODO: Use o for
        }

        return f;
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamente.
     *
     * @param {array} a Array de numeros rais.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um array.
     * @throws {TypeError} Se o argumento tiver elemento que não é número.
     * @throws {RangeError} Se o argumento não tiver 11 digitos.
     * @throws {RangeError} Se no argumento tiver algum número: 0 <= n >= 9.
     **/
    static validaCPF(a) {
        if (!vp.verificaTipoArray(a)) {
            throw new TypeError("o argumento d deve ser do tipo array");
        }

        if (!vp.validaParametrosTipoNumero(a)) {
            throw new TypeError("Os valores do array dever ser do tipo " +
                "número.");
        }

        if (a.length != 11) {
            throw RangeError("O cpf deve ter 11 digitos");
        }

        for (let i = 0; i < 11; i++) {
            if (a[i] < 0 || a[i] > 9) {
                throw RangeError("Os números do CPF devem ser de 0 a 9: " +
                    a[i]);
            }
        }

        let j = 0;
        let k = 0;
        for (let i = 0; i < 9; i++) {
            j = j + a[i];
        }

        for (let i = 1; i < 10; i++) {
            k = k + a[i];
        }

        const aj = (j % 11) % 10;
        const ak = (k % 11) % 10;

        return (ak === a[a.length]) && (aj === a[a.length - 1]);
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamenten usando o Método de Horner.
     *
     * @param {array} d Array de numeros rais.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um array.
     * @throws {TypeError} Se o argumento tiver elemento que não é número.
     * @throws {RangeError} Se o argumento não tiver 11 digitos.
     * @throws {RangeError} Se no argumento tiver algum número: 0 <= n >= 9.
     **/
    static validaCPFRegraHorner(d) {
        if (!vp.verificaTipoArray(d)) {
            throw new TypeError("o argumento d deve ser do tipo array");
        }

        if (!vp.validaParametrosTipoNumero(d)) {
            throw new TypeError("Os valores do array dever ser do tipo " +
                "número.");
        }

        if (d.length !== 11) {
            throw RangeError("o cpf deve ter 11 digitos");
        }

        for (let i = 0; i < 11; i++) {
            if (d[i] < 0 || d[i] > 9) {
                throw RangeError("Os números do CPF devem ser de 0 a 9: " +
                    d[i]);
            }
        }

        let c = 8;
        let p = d[9];
        let s = d[9];

        while (c >= 1) {
            p = p + d[c];
            s = s + p;
            c -= 1; //TODO: Use o for
        }

        const j = (s % 11) % 10;
        const k = ((s - p + (9 * d[10])) % 11) % 10;

        return (j === d[d.length - 1]) && (k === d[d.length]);
    }
}

module.exports = Algoritmos;
