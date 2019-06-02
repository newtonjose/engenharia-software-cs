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
        ValidaParametros.validaEntrada([n]);

        if (!ValidaParametros.verificaTipoNumero(n)) {
            throw new TypeError("Argumento deve ser um número");
        }

        if (n < 0 || n > 9999) {
            throw new RangeError("O numeros devem ser 0 ≤ n ≤ 9999");
        }

        if (ValidaParametros.verificaTipoFloat(n)) {
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
        ValidaParametros.validaEntrada([n]);

        if (!ValidaParametros.verificaTipoNumero(n)) {
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
        ValidaParametros.validaEntrada([dia, mes, ano]);

        if (ValidaParametros.validaData(dia, mes, ano)) {
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
        ValidaParametros.validaEntrada([x, y]);

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
        ValidaParametros.validaEntrada([n]);

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
        ValidaParametros.validaEntrada([n]);

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
        ValidaParametros.validaEntrada([a, b]);

        if (a < 0 || b < 0) {
            throw new RangeError("Os argumentos devem ser: a >= 0; b >= 0");
        }

        let totalParcelas = a;
        let parcela = b;
        if (b < a) {
            totalParcelas = b;
            parcela = a;
        }

        let prod = 0;
        for (let i = 1; i <= totalParcelas; i++) {
            prod = prod + parcela;
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
        ValidaParametros.validaEntrada([x, y]);

        if (x < 0 || y < 0) {
            throw new RangeError("Os argumentos devem ser: x >= 0; y >= 0");
        }

        let potencia = 1;
        for (let i = 1; i <= y; i++) {
            potencia = Algoritmos.produtoInteiros(potencia, x);
        }

        return potencia;
    }

    /**
     * Retorna o valor de Pi aproximado pelo um dado número.
     *
     * @param {number} num Numero inteiro natural.
     *
     * @returns {number} pi Número racional positivo.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 1.
     **/
    static valorPi(num) {
        ValidaParametros.validaEntrada([num]);

        if (num < 1) {
            throw new RangeError("O numero num tem que ser num >= 1");
        }

        let prod = -1;
        let div = -1;
        let pi = 0;

        for (let i = 1; i <= num; i++) {
            div = div + 2;
            prod = prod * -1;
            pi = pi + (4 * prod) / div;
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
        ValidaParametros.validaEntrada([n, k]);

        if (n < 1 || k < 2) {
            throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
        }

        let log = n + 1;
        let numerador = n;
        let denominador = 1;

        for (let i = 2; i <= k; i++) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            log = log + (numerador / denominador);
        }

        return log;
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
        ValidaParametros.validaEntrada([x, y, k]);

        if ((x < 0 || x > y) || k <= 0) {
            throw new RangeError("Números deve ser: x >= 0, x < y e k > 0");
        }

        let numerador = y;
        let denominador = x;

        for (let i = 1; i <= k; i++) {
            const aux = numerador;
            numerador = numerador + denominador;
            denominador = aux;
        }

        return numerador / denominador;
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
        ValidaParametros.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero 'n' deverá ser maior que 1");
        }

        let i = 1;
        let s = 1;

        while (s < n) {
            i = i + 2;
            s = s + i;
        }

        return s === n;
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
        ValidaParametros.validaEntrada([n, prescisao]);

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
        ValidaParametros.validaEntrada([n]);

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser maior que 1");
        }

        for (let i = 2; i < n; i++) {
            if (n % i === 0) {
                return false;
            }
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
        ValidaParametros.validaEntrada([n]);

        for (let j = 0; j < n; j++) {
            ValidaParametros.validaEntrada(a[j]);
        }
        
        if (!ValidaParametros.verificaTipoArray(a)) {
            throw new TypeError("O argumento a deve ser do tipo array.");
        }

        if (n < 1) {
            throw new RangeError("O numero 'n' tem que ser maior que 1");
        }
        
        for (let i = 2; i < n; i++) {
            if (a[i] !== 0) {
                throw new RangeError("Existe valores em a, onde nao sao " +
                    "iguais a zero");
            }
        }
        
        const limite = Math.sqrt(n);
        for (let i = 2; i <= limite; i++) {
            if (a[i] === 0) {
                let multiplo = i + 1;

                while (multiplo <= n) {
                    a[multiplo] = 1;
                    multiplo = multiplo + i;
                }
            }
        }

        return a[n - 1] === 1;
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
        ValidaParametros.validaEntrada([a, b]);

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
     * @param {number} a Número inteiro natural.
     *
     * @returns {number} a Máximo divisor comum de a e b.
     *
     * @throws {TypeError} Se o primeiro argumento não for um número.
     * @throws {RangeError} Se o primeiro argumento estiver fora do intervalo:
     * b > 0.
     **/
    static maiorDivisorComumSemResto(b, a) {
        ValidaParametros.validaEntrada([a, b]);

        if (b < 0 || a < 0) {
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
     * @param {number} num Número real.
     * @param {array} vet Array de numeros rais.
     *
     * @returns {number} p Número real.
     *
     * @throws {TypeError} Se os dois primeiros argumentos não forem um número.
     * @throws {TypeError} Se o terceiro argumento não for um array.
     * @throws {RangeError} Se o segundo argumento estiver for do intervalo:
     * g > 1.
     **/
    static regraHorner(num, vet) {
        ValidaParametros.validaEntrada([num,]);

        if (!ValidaParametros.verificaTipoArray(vet)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (vet.length === 0) {
            throw new RangeError("o agumento g deve ser maior que zero");
        }

        for (let i = 0; i < vet.length; i++) {
            ValidaParametros.validaEntrada([vet[i]]);
        }

        let num_horner = vet[vet.length - 1];
        for (let i = vet.length - 1; i >= 0; i--) {
            num_horner = num_horner * (num + vet[i]);
        }

        return num_horner;
    }

    /**
     * Calcula o número de Fibonacci sem usar recursividade.
     *
     * @param {number} num Número inteiro natural.
     *
     * @returns {number} f Número inteiro natural.
     *
     * @throws {TypeError} Se o argumento não for um número.
     * @throws {RangeError} Se o argumento estiver fora do intervalo: n >= 0.
     **/
    static fibonacci(num) {
        ValidaParametros.validaEntrada([num]);

        if (num <= 0) {
            throw new RangeError("O argumento 'n' tem que ser n>=0");
        }

        if (num === 0 || num === 1) {
            return 1;
        }

        let aux = 0;
        let fibo = 1;
        for (let i = 2; i <= num; i++) {
            const auxFibo = fibo;
            fibo = fibo + aux;
            aux = auxFibo;
        }

        return fibo;
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamente.
     *
     * @param {array} cpf Array de numeros rais.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um array.
     * @throws {TypeError} Se o argumento tiver elemento que não é número.
     * @throws {RangeError} Se o argumento não tiver 11 digitos.
     * @throws {RangeError} Se no argumento tiver algum número: 0 <= n >= 9.
     **/
    static validaCPF(cpf) {
        if (!ValidaParametros.verificaTipoArray(cpf)) {
            throw new TypeError("o argumento d deve ser do tipo array");
        }

        if (cpf.length !== 11) {
            throw RangeError("O cpf deve ter 11 digitos");
        }

        for (let i = 0; i < cpf.length; i++) {
            ValidaParametros.validaEntrada([cpf[i]]);
        }

        for (let i = 0; i < 11; i++) {
            if (cpf[i] < 0 || cpf[i] > 9) {
                throw RangeError("Os números do CPF devem ser de 0 a 9: " +
                    cpf[i]);
            }
        }

        let aux1 = 0;
        let k = 0;
        for (let i = 0; i < 9; i++) {
            aux1 = aux1 + cpf[i];
        }

        for (let i = 1; i < 10; i++) {
            k = k + cpf[i];
        }

        const aj = (aux1 % 11) % 10;
        const ak = (k % 11) % 10;

        return (ak === cpf[cpf.length - 1]) && (aj === cpf[cpf.length - 1]);
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamenten usando o Método de Horner.
     *
     * @param {array} cpf Array de numeros rais.
     *
     * @returns {boolean} true ou false Valor lógico.
     *
     * @throws {TypeError} Se o argumento não for um array.
     * @throws {TypeError} Se o argumento tiver elemento que não é número.
     * @throws {RangeError} Se o argumento não tiver 11 digitos.
     * @throws {RangeError} Se no argumento tiver algum número: 0 <= n >= 9.
     **/
    static validaCPFRegraHorner(cpf) {
        if (!ValidaParametros.verificaTipoArray(cpf)) {
            throw new TypeError("o argumento d deve ser do tipo array");
        }

        if (cpf.length !== 11) {
            throw RangeError("O cpf deve ter 11 digitos");
        }

        for (let i = 0; i < cpf.length; i++) {
            ValidaParametros.validaEntrada([cpf[i]]);
        }

        for (let i = 0; i < 11; i++) {
            if (cpf[i] < 0 || cpf[i] > 9) {
                throw RangeError("Os números do CPF devem ser de 0 a 9: " +
                    cpf[i]);
            }
        }

        let aux_cpf = cpf[9];
        let aux = cpf[9];

        for (let i = 7; i >= 0; i--) {
            aux_cpf = aux_cpf + cpf[i];
            aux = aux + aux_cpf;
        }

        const j = (aux % 11) % 10;
        const k = ((aux - aux_cpf + (10 * cpf[10])) % 11) % 10;

        return (j === cpf[9]) && (k === cpf[9]);
    }
}

module.exports = Algoritmos;
