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
	let du = n%100;
	let d = du/10;
	let u = du%10;
	if ((c*c*c + d*d*d + u*u*u) = n) {
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
function restoDivisaoInteira(){
    if (y >= 0 && x > 0) {
	let s = x;
	while(y <= s) {
	    s = s - y;
	    y = y + 1;
	}
	return s
    }
}

