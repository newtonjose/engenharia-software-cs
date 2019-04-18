// Java
public class Algoritmos {
    public static void main(String[] args){
    }

    public boolean numeroVerdadeiro(int n) {
	double i = n/100;
	double j = n%100;
	double m = i + j;

	if (m*m == n){
	    return true;
	} else {
	    return false;
	}
    }

    public boolean propriedade153(int cdu) {
	if (cdu >= 100 && cdu <= 999){
	    double c = n/100;
	    double cdu = n%100;
	    double d = cdu/10;
	    double u = cdu%10;
	    if ((c*c*c + d*d*d + u*u*u) == n){
		return true;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }

    public int diaDaSemana(int d, int m, int a) {
	if ((d >= 1 && d <= 31) && (d >= 1 && d <= 12) && (a > 1753)) {
	    if (m == 1 || m == 2) {
		m = m + 12;
		a = a - 1;
	    }
	    int i = d + 2*m + 3*(m+1);
	    double j = 5 + a + (a/4) – (a/100) + (a/400);
	    double s = i / j;
	    return s % 7;
	}
    }

    public int restoDivisaoInteira(int x, int y) {
	if (y >= 0 && x > 0) {
	    int s = x;
	    while(y <= s) {
		s = s - y;
		y = y + 1;
	    }
	    return s;
	}
	System.out.println("Os numeros x tem que ser maior 0 e y tem que ser maior");
	return null;
	    
    }

    public long int somaNaturais(int n) {
	if (n >= 1) {
	    int i = 2;
	    int s = 1;
	    
	    while(i <= n){
		s += i;
		i += 1;
	    }
	    
	    return s;
	}
	System.out.println("O numero n tem que ser maior que 1");
	return null;
    }

    public long int fatorial(int n) {
	if (n >= 1) {
	    int i = 2;
	    long int f = 1;
	    while(i <= n){
		f = f * i;
		i = i + 1;
	    }
	    return f;
	}

	System.out.println("O numero n tem que ser maior que 1");
	return null;
    }

    public long int produto(int a, int b) {
	if (a >= 0 && b >=0){
	    int totalParcelas = a;
	    int parcela = b;
	    
	
	    if (b < a){
		totalParcelas = b;
		parcela = a;
	    }
	    
	    int i = 1;
	    long int s = 0;
	    
	    while (i <= totalParcelas){
		s = s + parcela;
		i = i + 1;
	    }
	    
	    return s;
	}
	System.out.println("O numero a >= 0  e b >=0");
	return null;
    }

    public long int potencia(int x, int y) {
	long int potencia = 1;
	int i = 1;

	while(i <= y) {
	    potencia = potencia(potencia, x);
	    i = i + 1;
	}

	return potencia;
    }

    public double pi(int n) {
	 int i = 1;
	 int s = -1;
	 int d = -1;
	 double p = 0;

	 while (i <= n){
	     d = d + 2;
	     s = -1 * s;
	     p = p + (4*s)/d;
	     i = i + 1;
	 }

	 return p;
    }

    public double logaritmoNatural(int n, int k) {
	if (n >= 1 && k >= 2){
	    int i = 2;
	    double e = n + 1;
	    int numerador = n;
	    int denomidador = 1;
	    
	    while (i <= k){
		numerador = numerador*numerador;
		denominador = denominador*i;
		e += (numerador/denominador);
		i += 1;
	    }
	    
	    return e;
	}
    }

    public double razaoAurea(int x, int y, int k) {
	if ((x >= 0 && x < y) && k > 0){
	    int c = y;
	    int a = x;
	    int i = 1;
	    
	    while (i <= k){
		int t = c;
		c += a;
		a = t;
		i = i + 1;
	    }
	    
	    return c/a;
	}
	
	System.out.println("Números deve ser: x >= 0, x < y e k > 0");
	return null;
    }

    public boolean QuadradoPerfeito(int n){
	if (n >= 1){
	    int i = 1;
	    int s = 1;

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
	return null;
    }

    public double raiz(int n, int i) {
	double r = 1;

	while(i >= 0){
	    r = (r + n/r)/2;
	    i -= 1;
	}
	
	return r;
    }
}



