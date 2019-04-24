// JavaScript
# 01
const numVerdadeiro = function numeroVerdadeiroUsandoPropriedade3025(num) {
    let m = Math.floor(num / 100);
    let n = num % 100;
    let s = m + n;

    if (s * s == num) {
    	return true;
    }
    
    return false;
}

# 02
function propriedade153(cdu) {
    if (cdu < 100 && cdu > 999) {
	throw new RangeError("O numeros devem ser 100 <= cdu <= 999");
    }
    
    let c = n/100;
    let cdu = n%100;
    let d = cdu/10;
    let u = cdu%10;
    if ((c*c*c + d*d*d + u*u*u) == n) {
	return true;
    } else {
	return false;
    }
}


# 03
function diaDaSemana(d, m, a){
    if ((d < 1 && d > 31) && (m < 1 && m > 12) && (a <= 1753)) {
	throw new RangeError("O numeros devem ser d >= 1, d <= 31, m >= 1, m <= 12, a > 1753!");
    }
    
    if (m == 1 || m == 2) {
	m = m + 12;
	a = a - 1;
    }
    let i = d + 2*m + 3*(m+1);
    let j = 5 + a + (a/4) – (a/100) + (a/400);
    let s = i / j;
    return s % 7;
}

# 04
function restoDivisaoInteira(x, y){
    if (y < 0 && x <= 0) {
	throw new RangeError("O numeros devem ser y >= 0 && x > 0");
    }
    let s = x;
    while(y <= s) {
	s = s - y;
	y = y + 1;
    }
    return s;
}

# 05
function somaNaturais(n){
    if (n < 1) {
	throw new RangeError("O numero 'n' tem que ser n >= 1");
    }
    let i = 2;
    let s = 1;

    while(i <= n){
	s = s + i;
	i = i + 1;
    }

    return s;
}

# 06
function Fatorial(n){
    if (n < 1) {
	throw new RangeError("O numero 'n' tem que ser n >= 1");
    }
    
    let i = 2;
    let f = 1;
    while(i <= n){
	f = f * i;
	i = i + 1;
    }
    
    return f;
}

# 07
function Produto(a, b){
    if (a >= 0 && b >=0){
	let totalParcelas = a;
	let parcela = b;
    }

    if (b < a){
	totalParcelas = b;
	parcela = a;
    }

    let i = 1;
    let s = 0;

    while (i <= totalParcelas){
	s = s + parcela;
	i = i + 1;
    }

    return s;
}

# 08
function Potencia(x,  y) {
    let potencia = 1;
    let i = 1;

    while(i <= y) {
	potencia = Potencia(potencia, x);
	i = i + 1;
    }

    return potencia;
}

# 09
function Pi(n) {
    let i = 1;
    let s = -1;
    let d = -1;
    let p = 0;

    while (i <= n){
	d = d + 2;
	s = -1 * s;
	p = p + (4*s)/d;
	i = i + 1;
    }

    return p;
}

#10
function logaritmoNatural(n, k){
    if (n < 1 && k < 2){
	throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
    }
    let i = 2;
    let e = n + 1;
    let numerador = n;
    let denomidador = 1;

    while (i <= k){
	numerador = numerador*numerador;
	denominador = denominador*i;
	e += (numerador/denominador);
	i += 1;
    }

    return e;
}

#11
function RazaoAurea(x, y, k) {
    if ((x < 0 && x > y) && k <= 0){
	throw new RangeError("Números deve ser: x >= 0, x < y e k > 0");
    }
    let c = y;
    let a = x;
    let i = 1;

    while (i <= k){
	let t = c;
	c += a;
	a = t;
	i = i + 1;
    }

    return c/a;
}

#12
function QuadradoPerfeito(n){
    if (n < 1){
	throw new RangeError("O numero 'n' deverá ser maior que 1");
    }
    let i = 1;
    let s = 1;

    while (s < n){
	i += 2;
	s += i;
    }

    if (s = n)
	return true;
    else
	return false;
}

#13
function Raiz(n, i) {
    let r = 1;

    while(i >= 0){
	r = (r + n/r)/2;
	i -= 1;
    }
}

# 14
function primo(n) {
    if (n < 1){
	throw new RangeError("O numero 'n' tem que ser maior que 1");
    }
    
    let i = 2;
    while (i < n){
    	if (n%i == 0){
	    return false;   
	}
	i += 1;
    }
    return true;
}

# 15
function crivoErastostenes(a, n) {
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
    let limite = Math.sqrt(n); // numero base 
    while (i <= limite) {
	if (a[i] == 0){
	    let multiplo = i + 1;
	    while (multiplo <= n){
		a[multiplo] = 1;
		multiplo += i;
	    }
	}
	i += 1;
    }
}

# 16
function mdc(a, b) {
    if (b > a && b < 0){
	throw new RangeError("Os numeros deverao ser a >= b e b > 0");
    }
    
    while (b != 0){
	let m = a%b;
	a = b;
	b = m;
    }
    return a;
}

# 17
function mdc2(a, b) {
    if (b < 0){
	throw new RangeError("Os numero deverao 'b' tem que ser maior que zero!");
    }

    for (let i = 0; i < a.lenth; i++){
	if (a < b){
	    throw new RangeError("Existem valores em no vetor a que e' menor que 'b'!");
	}
    }
    
    while (b != a){
	// 'a' sempre sera maior que 'b' pelo if anterior
	if (a > b){
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

    let p = a[g-1];
    let i = g - 1;
    while (i >= 0){
	p = p*x + a[i];
	i -= 1;
    }
    return p;
}

#19
function fibonacci(n) {
    if (n <= 0){
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
    if (d.length != 11){
   	throw RangeError("o cpf deve ter 11 digitos");
    }
    
    let j = 0;
    let k = 0;
    for (let i = 0; i < 9; i++){
   	j += d[i];
    }
    
    for (let i=1; i < 10; i++){
   	k += d[i]; 
    }
    
    let dj = (j%11) % 10;
    let dk = (k%11) % 10;
    
    if (dj == d[d.length - 1] && dk == d[d.length]){
	return true;
    } else {
	return false; 
    }
}

#21
function cpf2(d) {
    if (d.length != 11){
   	throw RangeError("o cpf deve ter 11 digitos");
    }
    
    let c = 8;
    let p = d[9];
    let s = d[9];
    
    while (c >= 1){
	p += d[c];
	s += p;
	c -= 1;
    }
    
    let j = (s%11) % 10;
    let k = ((s-p+9*d[10])%11) % 10;
    
    if (j == d[d.length-1] && k == d[d.length]){
   	return true; 
    } else {
	return false;
    }
}
