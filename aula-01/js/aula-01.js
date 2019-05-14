/**
 * Classe auxiliar para validar parametros passados. A classe valida tipo
 * {array} e tipo {number}.
 *
 * @type {module.ValidaParametros}
 */
class ValidaParametros {
    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'number'.
     **/
    verificaTipoNumero(n) {
        return typeof n == "number";
    }

    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'array'.
     **/
    verificaTipoArray(a) {
        return Array.isArray(a);
    }

    verificaTipoFloat(n) {
        return Number(n) === n && n % 1 !== 0;
    }

    /**
     * Verifica se os elementos de um array de parametros é do tipo número.
     *
     * @param {array} prts Array de numeros.
     *
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
     **/
    static validaData(d, m, a) {
        return d < 1 || d > 31 || m < 1 || m > 12 || a <= 1753;
    }

    static validaEntrada(a) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] == null || a[i] == undefined) {
                return false;
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
    static numeroVerdadeiro(n) {
        if (ValidaParametros.validaEntrada([n])) {
            throw new Error("Entrada invalidada, null e undefined nao " +
                "sao entradas validas");
        }

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
    static verificaCubosDosDigitos(n) {
        if (ValidaParametros.validaEntrada([n])) {
            throw new Error("Entrada invalidada, null e undefined nao " +
                "sao entradas validas");
        }

        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("Argumento deve ser um número");
        }

        if (n < 100 || n > 999) {
            throw new RangeError("O numeros devem ser 100 <= n <= 999");
        }

        if (vp.verificaTipoFloat(n)) {
            throw new RangeError("O numeros devem ser tipo inteiro.");
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
        if (ValidaParametros.validaEntrada([dia, mes, ano])) {
            throw new Error("Entrada invalidada, null e undefined nao " +
                "sao entradas validas");
        }

        if (!vp.validaParametrosTipoNumero([dia, mes, ano])) {
            throw new TypeError("os argumentos devem ser do tipo número");
        }

        if (ValidaParametros.validaData(dia, mes, ano)) {
            throw new RangeError("A data é invalida! Para uma data valida " +
                "1 <= dia <= 31, 1 <= mes <= 12 e ano > 1753!");
        }

        if (vp.verificaTipoFloat(dia) || vp.verificaTipoFloat(mes) ||
            vp.verificaTipoFloat(ano)) {
            throw new RangeError("O numeros devem ser tipo inteiro.");
        }

        if (mes === 1 || mes === 2) {
            mes += 12;
            ano -= 1;
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
        if (ValidaParametros.validaEntrada([x, y])) {
            throw new Error("Entrada invalidada, null e undefined nao " +
                "sao entradas validas");
        }
        if (!vp.validaParametrosTipoNumero([x, y])) {
            throw new TypeError("Os argumentos devem ser do tipo número");
        }

        if (x < 0 || y <= 0) {
            throw new RangeError("Os numeros devem ser y >= 0 && x > 0");
        }

        if (vp.verificaTipoFloat(x) || vp.verificaTipoFloat(y)) {
            throw new RangeError("O numeros devem ser tipo inteiro.");
        }

        let resto = x;

        while (y <= resto) {
            resto -= y;
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
    somaNaturais(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento deve ser um número");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser n >= 1");
        }

        let i = 2;
        let s = 1;

        while (i <= n) {
            s += i;
            i += 1;
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
    fatorialNumero(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento deve ser um número");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser n >= 1");
        }

        let i = 2;
        let fat = 1;

        while (i <= n) {
            fat *= i;
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
    produtoInteiros(a, b) {
        if (!vp.validaParametrosTipoNumero([a, b])) {
            throw new TypeError("os argumentos devem ser do tipo número");
        }

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
            prod += parcela;
            i += 1;
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
    calculaPotencia(x, y) {
        if (!vp.validaParametrosTipoNumero([x, y])) {
            throw new TypeError("Os argumentos devem ser do tipo número");
        }

        if (x < 0 || y < 0) {
            throw new RangeError("Os argumentos devem ser: x >= 0; y >= 0");
        }

        let p = 1;
        let i = 1;

        while (i <= y) {
            p = this.produtoInteiros(p, x);
            i += 1;
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
    numeroPi(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento deve ser um número");
        }

        if (n < 1) {
            throw new RangeError("O numero num tem que ser num >= 1");
        }

        let i = 1;
        let s = -1;
        let d = -1;
        let pi = 0;

        while (i <= n) {
            d += 2;
            s *= -1;
            pi += (4 * s) / d;
            i += 1;
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
    logaritmoNatural(n, k) {
        if (!vp.validaParametrosTipoNumero([n, k])) {
            throw new TypeError("Os argumentos devem ser do tipo número");
        }

        if (n < 1 && k < 2) {
            throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
        }

        let i = 2;
        let e = n + 1;
        let numerador = n;
        let denominador = 1;

        while (i <= k) {
            numerador *= numerador;
            denominador *= i;
            e += (numerador / denominador);
            i += 1;
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
    razaoAurea(x, y, k) {
        if (!vp.validaParametrosTipoNumero([x, y, k])) {
            throw new TypeError("Os argumentos devem ser do tipo número");
        }

        if ((x < 0 && x > y) && k <= 0) {
            throw new RangeError("Números deve ser: x >= 0, x < y e k > 0");
        }

        let c = y;
        let a = x;
        let i = 1;
        let t;

        while (i <= k) {
            t = c;
            c += a;
            a = t;
            i += 1;
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
    quadradoPerfeito(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento deve ser um número");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' deverá ser maior que 1");
        }

        let i = 1;
        let s = 1;

        while (s < n) {
            i += 2;
            s += i;
        }

        return s == n;
    }

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     *
     * @param {number} n Número racional positivo.
     * @param {number} i Numero inteiro nartual usado como o fator de
     * prescisão.
     *
     * @returns {number} r Número racional positivo.
     *
     * @throws {TypeError} Se qualquer um dos argumentos não for um número.
     * @throws {RangeError} Se os argumentos estiverem fora dos intervalos:
     * n > 0.
     **/
    raizQuadrada(n, i) {
        if (!vp.validaParametrosTipoNumero([n, i])) {
            throw new TypeError("os argumentos devem ser do tipo número");
        }

        if (n < 0) {
            throw new RangeError("O numero 'n' deverá ser maior que 0");
        }

        let r = 1;

        while (i >= 0) {
            r = (r + n / r) / 2;
            i -= 1;
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
    numeroPrimo(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento deve ser um número");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser maior que 1");
        }

        let i = 2;

        while (i < n) {
            if (n % i == 0) {
                return false;
            }

            i += 1;
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
    crivoErastostenes(n, a) {
        if (!vp.validaParametrosTipoNumero([n, a])) {
            //!vp.verificaTipoNumero(a) &&  !this.verificaTipoNumero(n)
            throw new TypeError("Os argumentos devem ser do tipo número.");
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
        let multiplo;
        const limite = Math.sqrt(n);

        while (i <= limite) {
            if (a[i] == 0) {
                multiplo = i + 1;

                while (multiplo <= n) {
                    a[multiplo] = 1;
                    multiplo += i;
                }
            }

            i += 1;
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
    maiorDivisorComum(a, b) {
        if (!vp.validaParametrosTipoNumero([a, b])) {
            throw new TypeError("Os argumentos devem ser do tipo número");
        }

        if (b > a && b < 0) {
            throw new RangeError("Os numeros deverao ser a >= b e b > 0");
        }

        let m;

        while (b != 0) {
            m = a % b;
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
    maiorDivisorComumSemResto(b, a) {
        if (!vp.verificaTipoNumero(b)) {
            throw new TypeError("O argumento b deve ser um número");
        }

        if (b < 0) {
            throw new RangeError("Os numero deverao 'b tem que ser " +
                "maior que zero!");
        }

        while (b != a) {
            // 'a' sempre sera maior que 'b' pelo if anterior
            if (a > b) {
                a -= b;
            } else {
                b -= a;
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
    regraHorner(x, g, a) {
        if (!vp.validaParametrosTipoNumero([x, g])) {
            throw new TypeError("os argumentos x e g devem ser do tipo número");
        }

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
            i -= 1;
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
    fibonacci(n) {
        if (!vp.verificaTipoNumero(n)) {
            throw new TypeError("O argumento n deve ser um número");
        }

        if (n <= 0) {
            throw new RangeError("O argumento 'n' tem que ser n>=0");
        }

        let a = 0;
        let f = 1;

        if (n == 0 || n == 1) {
            return n;
        }

        let i = 1;
        let t;

        while (i <= n) {
            t = f;
            f += a;
            a = t;
            i += 1;
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
    validaCPF(a) {
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
        let i;

        for (i = 0; i < 9; i++) {
            j += a[i];
        }

        for (i = 1; i < 10; i++) {
            k += a[i];
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
    validaCPFRegraHorner(d) {
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
            p += d[c];
            s += p;
            c -= 1;
        }

        const j = (s % 11) % 10;
        const k = ((s - p + (9 * d[10])) % 11) % 10;

        return (j === d[d.length - 1]) && (k === d[d.length]);
    }
}

module.exports = Algoritmos;
