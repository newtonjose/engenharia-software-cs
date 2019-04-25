// 01
function numeroVerdadeiroUsandoPropriedade3025(num) {
    let m = Math.floor(num / 100);
    let n = num % 100;
    let s = m + n;

    return s * s == num;
}

// 02
function samaCubosDosDigitosUsandoPropriedade153(num) {
    if (num < 100 && num > 999) {
        throw new RangeError("O numeros devem ser 100 <= num <= 999");
    }

    let c = Math.floor(n / 100);
    let du = num % 100;
    let d = Math.floor(du / 10);
    let u = du % 10;
    const s = c * c * c + d * d * d + u * u * u;

    if (s == n) {
        return true;
    }

    return false;
}

// 03
function diaDaSemanaParaData(dia, mes, ano) {
    if ((dia < 1 && dia > 31) && (mes < 1 && mes > 12) && (ano <= 1753)) {
        throw new RangeError("O numeros devem ser d >= 1, d <= 31, m >= 1, m <= 12, a > 1753!");
    }

    if (mes == 1 || mes == 2) {
        mes += 12;
        ano -= 1;
    }

    let i = dia + (2 * mes) + (3 * (mes + 1));
    let j = 5 + ano + (ano / 4) - (ano / 100) + (ano / 400);
    let s = i / j;

    return s % 7;
}

// 04
function restoDivisaoInteira(x, y) {
    if (y < 0 && x <= 0) {
        throw new RangeError("O numeros devem ser y >= 0 && x > 0");
    }

    let s = x;

    while (y <= s) {
        s = s - y;
        y = y + 1;
    }

    return s;
}

// 05
function somaPrimeirosNaturaisAteNumero(n) {
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

// 06
function fatorialNumeroNatual(n) {
    if (n < 1) {
        throw new RangeError("O numero 'n' tem que ser n >= 1");
    }

    let i = 2;
    let f = 1;

    while (i <= n) {
        f *= i;
        i += 1;
    }

    return f;
}

// 07
function produtoInteirosUsandoSomas(a, b) {
    if (a < 0 || b < 0) {
        throw new RangeError("Os numeros a e b tem que ser maior ou igual a zero");
    }

    let totalParcelas = a;
    let parcela = b;

    if (b < a) {
        totalParcelas = b;
        parcela = a;
    }

    let i = 1;
    let s = 0;

    while (i <= totalParcelas) {
        s += parcela;
        i += 1;
    }

    return s;
}

// 08
function calculaPotenciaUsandoSomas(x, y) {
    if (x < 0 || y < 0) {
        throw new RangeError("Os numeros x e y tem que ser maior ou igual a zero");
    }

    let p = 1;
    let i = 1;

    while (i <= y) {
        p = produto(p, x);
        i += 1;
    }

    return p;
}

// 09
function calculaNumeroPiDadoNumeroNatual(num) {
    if (num < 1) {
        throw new RangeError("O numero num tem que ser num >= 1");
    }

    let i = 1;
    let s = -1;
    let d = -1;
    let pi = 0;

    while (i <= num) {
        d += 2;
        s *= -1;
        pi += (4 * s) / d;
        i += 1;
    }

    return pi;
}

//10
function calculaLogaritmoNaturalDadoNumerosNautais(n, k) {
    if (n < 1 && k < 2) {
        throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
    }

    let i = 2;
    let e = n + 1;
    let numerador = n;
    let denomidador = 1;

    while (i <= k) {
        numerador *= numerador;
        denominador *= i;
        e += (numerador / denominador);
        i += 1;
    }

    return e;
}

//11
function calculaRazaoAureaDadoNumerosInteiros(x, y, k) {
    if ((x < 0 && x > y) && k <= 0) {
        throw new RangeError("Números deve ser: x >= 0, x < y e k > 0");
    }

    let c = y;
    let a = x;
    let i = 1;

    while (i <= k) {
        let t = c;
        c += a;
        a = t;
        i += 1;
    }

    return c / a;
}

//12
function verificaQuadradoPerfeitoDadoNumero(n) {
    if (n < 1) {
        throw new RangeError("O numero 'n' deverá ser maior que 1");
    }

    let i = 1;
    let s = 1;

    while (s < n) {
        i += 2;
        s += i;
    }

    if (s == n) {
        return true;
    }

    return false;
}

//13
function calcualRaizQuadradaUsandoMetodoBabilonico(n, i) {
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

// 14
function verificaNumeroPrimo(n) {
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

# 15

function crivoErastostenes(a, n) {
    if (n < 1) {
        throw new RangeError("O numero 'n' tem que ser maior que 1");
    }

    // busca por valores diferente de zero
    for (let i = 2; i < n; i++) {
        if (a[i] != 0) {
            throw new RangeError("Existe valores em a, onde nao sao iguais a zero");
        }
    }

    let i = 2;
    let limite = Math.sqrt(n); // numero base 
    while (i <= limite) {
        if (a[i] == 0) {
            let multiplo = i + 1;
            while (multiplo <= n) {
                a[multiplo] = 1;
                multiplo += i;
            }
        }
        i += 1;
    }
}

# 16

function mdc(a, b) {
    if (b > a && b < 0) {
        throw new RangeError("Os numeros deverao ser a >= b e b > 0");
    }

    while (b != 0) {
        let m = a % b;
        a = b;
        b = m;
    }
    return a;
}

# 17

function mdc2(a, b) {
    if (b < 0) {
        throw new RangeError("Os numero deverao 'b' tem que ser maior que zero!");
    }

    for (let i = 0; i < a.lenth; i++) {
        if (a < b) {
            throw new RangeError("Existem valores em no vetor a que e' menor que 'b'!");
        }
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


#18

function horner(x, g, a) {
    if (g < 1) {
        throw new RangeError("g deve ser maior que zero");
    }

    let p = a[g - 1];
    let i = g - 1;
    while (i >= 0) {
        p = p * x + a[i];
        i -= 1;
    }
    return p;
}

#19

function fibonacci(n) {
    if (n <= 0) {
        throw new RangeError("O numero 'n' tem que ser n>=0");
    }

    let a = 0;
    let c = 1;
    if (n == 0 || n == 1) {
        return n;
    }
    let i = 1;
    while (i <= n) {
        let t = c;
        c += a;
        a = t;
        i += 1;
    }

    return c;
}

#20

function cpf(d) {
    if (d.length != 11) {
        throw RangeError("o cpf deve ter 11 digitos");
    }

    let j = 0;
    let k = 0;
    for (let i = 0; i < 9; i++) {
        j += d[i];
    }

    for (let i = 1; i < 10; i++) {
        k += d[i];
    }

    let dj = (j % 11) % 10;
    let dk = (k % 11) % 10;

    if (dj == d[d.length - 1] && dk == d[d.length]) {
        return true;
    } else {
        return false;
    }
}

#21

function cpf2(d) {
    if (d.length != 11) {
        throw RangeError("o cpf deve ter 11 digitos");
    }

    let c = 8;
    let p = d[9];
    let s = d[9];

    while (c >= 1) {
        p += d[c];
        s += p;
        c -= 1;
    }

    let j = (s % 11) % 10;
    let k = ((s - p + 9 * d[10]) % 11) % 10;

    if (j == d[d.length - 1] && k == d[d.length]) {
        return true;
    } else {
        return false;
    }
}
