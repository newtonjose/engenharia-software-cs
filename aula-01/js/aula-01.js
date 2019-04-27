function verificaTipoNumero(num) {
  return typeof num == "number"
}

function verificaTipoArray(a) {
    return Array.isArray(a);
}


// 01
const numVerdadeiro = function numeroVerdadeiroUsandoPropriedade3025(num) {
  let m = Math.floor(num / 100);
  let n = num % 100;
  let s = m + n;

  if (s * s == num) {
    return true;
  }
  
  return false;
}

// 02
const somaCubos = function somaCubosDosDigitosDoNumero(num) {
  if ( !verificaTipoNumero(num) ) {
    throw new TypeError("argumento deve ser um número");
  }
  
  if (num < 100 && num > 999) {
    throw new RangeError("O numeros devem ser 100 <= num <= 999");
  }

  let pow = Math.pow;

  let c = Math.floor(num / 100);
  let du = num % 100;
  let d = Math.floor(du / 10);
  let u = du % 10;
  let s = pow(c, 3) + pow(d, 3) + pow(u, 3);
    
  if (s == n) {
    return true;
  }

  return false;
}

// 03
const diaDaSemana4 = function diaDaSemanaParaData(dia, mes, ano) {
  if ( !verificaTipoNumero(dia) &&  !verificaTipoNumero(mes) &&  !verificaTipoNumero(ano) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
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
const resto = function restoDivisaoInteira(x, y) {
  if ( !verificaTipoNumero(x) &&  !verificaTipoNumero(y) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
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
const somaNaturais = function somaPrimeirosNaturaisAteNumero(n) {
  if ( !verificaTipoNumero(n) ) {
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

// 06
const fatorial = function fatorialNumeroNatual(n) {
  if ( !verificaTipoNumero(n) ) {
    throw new TypeError("O argumento deve ser um número");
  }
  
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
const produto = function produtoInteirosUsandoSomas(a, b){
  if ( !verificaTipoNumero(a) &&  !verificaTipoNumero(b) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
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
const potencia = function calculaPotenciaUsandoSomas(x,  y) {
  if ( !verificaTipoNumero(x) &&  !verificaTipoNumero(y) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
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
const numPi = function calculaNumeroPiDadoNumeroNatual(num) {
  if ( !verificaTipoNumero(num) ) {
    throw new TypeError("O argumento deve ser um número");
  }
  
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
const logNatual = function calculaLogaritmoNaturalDadoNumerosNautais(n, k){
  if ( !verificaTipoNumero(n) &&  !verificaTipoNumero(k) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
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
const razaoAurea = function calculaRazaoAureaDadoNumerosInteiros(x, y, k) {
  if ( !verificaTipoNumero(x) &&  !verificaTipoNumero(y) && !verificaTipoNumero(y) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
  if ((x < 0 && x > y) && k <= 0 ){
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
const quadradoPerfeito = function verificaQuadradoPerfeitoDadoNumero(n) {
  if ( !verificaTipoNumero(n) ) {
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

  if (s == n) {
	  return true;
  }
    
  return false;
}

//13
const raizQuadrada = function calcualRaizQuadradaUsandoMetodoBabilonico(n, i) {
  if ( !verificaTipoNumero(n) &&  !verificaTipoNumero(i) ) {
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

// 14
const numPrimo = function verificaNumeroPrimo(n) {
  if ( !verificaTipoNumero(n) ) {
    throw new TypeError("O argumento deve ser um número");
  }
  
  if (n < 1){
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
function crivoErastostenes(n, a) {
  if ( !verificaTipoNumero(a) &&  !verificaTipoNumero(n) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
  if ( !verificaTipoArray(a) ) {
    throw new TypeError("o argumento a deve ser do tipo array");
  }
  
  if (n < 1){
    throw new RangeError("O numero 'n' tem que ser maior que 1");
  }
  
  // busca por valores diferente de zero
  for (let i = 2; i < n; i++) {
    if (a[i] != 0){
      throw new RangeError("Existe valores em a, onde nao sao iguais a zero");
    }
  }
    
  let i = 2;
  let limite = Math.sqrt(n);
  
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
  if ( !verificaTipoNumero(a) &&  !verificaTipoNumero(b) ) {
    throw new TypeError("os argumentos devem ser do tipo número");
  }
  
  if (b > a && b < 0) {
    throw new RangeError("Os numeros deverao ser a >= b e b > 0");
  }
    
  while (b != 0) {
    let m = a%b;
    a = b;
    b = m;
  }
  
  return a;
}

# 17
function mdc2(b, a) {
  if ( !verificaTipoNumero(b) ) {
    throw new TypeError("O argumento b deve ser um número");
  }
  
  if ( !verificaTipoArray(a) ) {
    throw new TypeError("o argumento a deve ser do tipo array");
  }
  
  if (b < 0){
    throw new RangeError("Os numero deverao 'b tem que ser maior que zero!");
  }

  for (let i = 0; i < a.lenth; i++){
    if (a < b){
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
  if ( !verificaTipoNumero(x) &&  !verificaTipoNumero(g) ) {
    throw new TypeError("os argumentos x e g devem ser do tipo número");
  }
  
  if ( !verificaTipoArray(a) ) {
    throw new TypeError("o argumento a deve ser do tipo array");
  }
  
  if (g < 1) {
    throw new RangeError("o agumento g deve ser maior que zero");
  }

  let p = a[g-1];
  let i = g - 1;
  
  while (i >= 0) {
    p = p*x + a[i];
    i -= 1;
  }
  
  return p;
}

#19
function fibonacci(n) {
  if ( !verificaTipoNumero(n) ) {
    throw new TypeError("O argumento n deve ser um número");
  }
  
  if (n <= 0){
    throw new RangeError("O argumento 'n' tem que ser n>=0");
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
  if ( !verificaTipoArray(d) ) {
    throw new TypeError("o argumento d deve ser do tipo array");
  }
  
  if (d.length != 11) {
   	throw RangeError("o cpf deve ter 11 digitos");
  }
    
  let j = 0;
  let k = 0;
  
  for (let i = 0; i < 9; i++) {
    j += d[i];
  }
    
  for (let i=1; i < 10; i++) {
    k += d[i]; 
  }
    
  let dj = (j%11) % 10;
  let dk = (k%11) % 10;
    
  if (dj == d[d.length - 1] && dk == d[d.length]) {
    return true;
  } else {
    return false; 
  }
}

#21
function cpf2(d) {
  if ( !verificaTipoArray(d) ) {
    throw new TypeError("o argumento d deve ser do tipo array");
  }
  
  if (d.length != 11){
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
    
  let j = (s%11) % 10;
  let k = ((s-p+9*d[10])%11) % 10;
    
  if (j == d[d.length-1] && k == d[d.length]) {
   	return true; 
  } else {
    return false;
  }
}
