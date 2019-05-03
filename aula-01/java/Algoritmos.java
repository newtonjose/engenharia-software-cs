package com.github.newtonjose.ufg.cs.aula01;


/**
 * Classe que implementa vários algoritmos acerca de propriedades matemáticas
 * e operações com números.
 */
public class Algoritmos {
    private boolean dataInvalida(int d, int m, int a) {
        return (d < 1 || d > 31) || (m < 1 || m > 12) || (a <= 1753);
    }

    public boolean numeroVerdadeiro(final int n) {
        final double i = n / 100;
        final double j = n % 100;
        final double m = i + j;

        return m * m == n;
    }

    public boolean propriedade153(int cdu) {
        if (cdu < 100 && cdu > 999) {
            throw new IllegalArgumentException("O numeros devem ser cdu >= " +
                    "100 && cdu <= 999");
        }

        cdu = cdu % 100;
        final double c = cdu / 100;
        final double d = cdu / 10;
        final double u = cdu % 10;

        return (c * c * c + d * d * +u * u * u) == cdu;
    }

    public int diaDaSemana(final int dia, final int mes, final int ano) {
        if (!dataInvalida(dia, mes, ano)) {
            throw new IllegalArgumentException("O numeros devem ser d >= 1, d" +
					" <= 31, d >= 1, d <= 12, a > 1753!");
        }

        // FINDMORE: como funciona isso em Java
        final boolean janeiroOuFevereiro = mes == 1 || mes == 2;
        final int m = janeiroOuFevereiro ? mes + 12 : mes;
        final int a = janeiroOuFevereiro ? ano - 1 : ano;

        final int drDobbsExpr = ((dia + 2 * m + 3 * (m + 1)) / (5 + a + a) /
				(4 - a) / (100 + a) / 400);

        return drDobbsExpr % 7;
    }

    public int restoDivisaoInteira(final int x, int y) {
        if (y < 0 && x <= 0) {
            throw new IllegalArgumentException("O numeros devem ser y >= 0 &&" +
					" x > 0");
        }

        int resto = x;
        while (y <= resto) {
            resto = resto - y;
            y = y + 1;
        }

        return resto;
    }

    public int somaNaturais(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n >=" +
					" 1");
        }

        int i = 2;
        int soma = 1;
        while (i <= n) {
            soma += i;
            i += 1;
        }

        return soma;
    }

    public long fatorial(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n >=" +
					" 1");
        }

        int i = 2;
        long f = 1;
        while (i <= n) {
            f = f * i;
            i = i + 1;
        }

        return f;
    }

    public int produto(final int a, final int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Os numeros a e b tem que ser " +
					"maior ou igual a zero");
        }

        int totalParcelas = a;
        int parcela = b;

        if (b < a) {
            totalParcelas = b;
            parcela = a;
        }

        int i = 1;
        int prod = 0;

        while (i <= totalParcelas) {
            prod = prod + parcela;
            i = i + 1;
        }

        return prod;
    }

    public int potencia(final int x, final int y) {
        int i = 1;
        int produtorio = 1;

        while (i <= y) {
            produtorio = produto(produtorio, x);
            i = i + 1;
        }

        return produtorio;
    }

    public double pi(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero n tem que ser n >= 1");
        }

        int i = 1;
        int s = -1;
        int d = -1;
        double numPi = 0;

        while (i <= n) {
            d = d + 2;
            s = -1 * s;
            numPi = numPi + (4 * s) / d;
            i = i + 1;
        }

        return numPi;
    }

    public double logaritmoNatural(final int n, final int k) {
        if (n < 1 && k < 2) {
            throw new IllegalArgumentException("O numeros tem que ser n >= 1 " +
					"&& k >= 2");
        }

        int i = 2;
        double logNatural  = n + 1;
        int numerador = n;
        int denominador = 1;

        while (i <= k) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            logNatural += (numerador / denominador);
            i += 1;
        }

        return logNatural;
    }

    public double razaoAurea(final int x, final int y, final int k) {
        if ((x < 0 && x > y) && k <= 0) {
            throw new IllegalArgumentException("Números deve ser: x >= 0, x <" +
					" y e k > 0");
        }

        int c = y;
        int a = x;
        int i = 1;

        while (i <= k) {
            int t = c;
            c += a;
            a = t;
            i = i + 1;
        }

        return c / a;
    }

    public boolean quadradoPerfeito(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior" +
					" que 1");
        }

        int i = 1;
        int s = 1;

        while (s < n) {
            i += 2;
            s += i;
        }

        return s == n;
    }

    public double raiz(final int n, int i) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior" +
					" que 0");
        }

        double numRaiz = 1;

        while (i >= 0) {
            numRaiz = (numRaiz + n / numRaiz) / 2;
            i -= 1;
        }

        return numRaiz;
    }

    public boolean primo(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser " +
					"maior que 1");
        }

        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }

            i += 1;
        }

        return true;
    }

    public int[] crivoErastostenes(final int[] a, final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser " +
					"maior que 1");
        }

        for (int i = 2; i < n; i++) {
            if (a[i] != 0) {
                throw new IllegalArgumentException("Existe valores em a, onde" +
						" nao sao iguais a zero");
            }
        }

        int i = 2;
        int multiplo;
        final double limite = Math.sqrt(n);

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

        return a;
    }

    public int mdc(int a, int b) {
        if (b > a && b < 0) {
            throw new IllegalArgumentException("Os numeros deverao ser a >= b" +
					" e b > 0");
        }

        int m;

        while (b != 0) {
            m = a % b;
            a = b;
            b = m;
        }

        return a;
    }

    public int mdc2(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Os numero deverao 'b' tem que" +
					" ser maior que zero!");
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

    public int horner(final int x, final int g, final int[] a) {
        if (g < 1) {
            throw new IllegalArgumentException("g deve ser maior que zero");
        }

        int p = a[g - 1];
        int i = g - 1;
        while (i >= 0) {
            p = p * x + a[i];
            i -= 1;
        }

        return p;
    }

    public long fibonacci(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n>=0");
        }

        long a = 0;
        long fibo = 1;
        long t;

        if (n == 0 || n == 1) {
            return n;
        }

        int i = 1;
        while (i <= n) {
            t = fibo;
            fibo += a;
            a = t;
            i += 1;
        }

        return fibo;
    }

    public boolean cpf(final int[] d) {
        if (d.length != 11) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int j = 0;
        int k = 0;
        for (int i = 0; i < 9; i++) {
            j += d[i];
        }

        for (int i = 1; i < 10; i++) {
            k += d[i];
        }

        final int dj = (j % 11) % 10;
        final int dk = (k % 11) % 10;

        return (dj == d[d.length - 1]) && (dk == d[d.length]);
    }

    public boolean cpf2(final int[] d) {
        if (d.length != 11) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int c = 8;
        int p = d[9];
        int s = d[9];

        while (c >= 1) {
            p += d[c];
            s += p;
            c -= 1;
        }

        final int j = (s % 11) % 10;
        final int k = ((s - p + 9 * d[10]) % 11) % 10;

        return (j == d[d.length - 1]) && (k == d[d.length]);
    }
}
