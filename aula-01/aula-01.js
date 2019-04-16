// JavaScript
# 01
function numVerdadeiro(n){
	var i = n/100;
    var j = n%100;
    var m = i+j;
    if (m*m == n){
    	return true;
    } else {
    	return false;
    }
}

# 02
function propriedade153(cdu) {
    if (cdu >= 100 && cdu <= 999) {
	let c = n/100;
	let cdu = n%100;
	let d = cdu/10;
	let u = cdu%10;
	if ((c*c*c + d*d*d + u*u*u) == n) {
	    return true;
	} else {
	    return false;
	}
    } else {
	return false;
    }
}

# 03
function diaDaSemana(d, m, a){
    if ((d >= 1 && d <= 31) && (d >= 1 && d <= 12) && (a > 1753)) {
	if (m == 1 || m == 2) {
	    m = m + 12;
	    a = a - 1;
	}
	let i = d + 2*m + 3*(m+1);
	let j = 5 + a + (a/4) – (a/100) + (a/400);
	let s = i / j;
	return s % 7;
    }
}

# 04
function restoDivisaoInteira(x, y){
    if (y >= 0 && x > 0) {
	let s = x;
	while(y <= s) {
	    s = s - y;
	    y = y + 1;
	}
	return s;
    }
}

# 05
function somaNaturais(n){
    if (n >= 1) {
	let i = 2;
	let s = 1;

	while(i <= n){
	    s = s + i;
	    i = i + 1;
	}

	return s;
    }
}

# 06
function Fatorial(n){
    if (n >= 1) {
	let i = 2;
	let f = 1;
	while(i <= n){
	    f = f * i;
	    i = i + 1;
	}
	return f;
    }
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
    if (n >= 1 && k >= 2){
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
}

#11
function RazaoAurea(x, y, k) {
    if ((x >= 0 && x < y) && k > 0){
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

    console.log("Números deve ser: x >= 0, x < y e k > 0");
    return;
}

#12
function QuadradoPerfeito(n){
    if (n >= 1){
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
    
    console.log("o Numero n deverá ser maior que 1!");
    return;
}

#13
function Raiz(n, i) {
    let r = 1;

    while(i >= 0){
	r = (r + n/r)/2;
	i -= 1;
    }

    return r;
}

    
