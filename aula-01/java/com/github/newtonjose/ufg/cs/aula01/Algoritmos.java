package com.github.newtonjose.ufg.cs.aula01;

/**
 * Classe que implementa vários algoritmos acerca de propriedades matemáticas
 * e operações com números.
 */
public class Algoritmos {

    public boolean numeroVerdadeiro(final int n) {
        final double i = n / 100;
        final double j = n % 100;
        final double m = i + j;

        return m * m == n;
    }

    public boolean propriedade153(final int cdu) {
        if (cdu < 100 || cdu > 999) {
            throw new IllegalArgumentException("numero fora da faixa");
        }

        final double c = cdu / 100;
        final double du = cdu % 100;
        final double d = du / 10;
        final double u = du % 10;

        return (c * c * c + d * d * d + u * u * u) == cdu;
    }

    public int diaDaSemana(int d, int m, int a) throws Exception {
        if (dataInvalida(d, a)) {
            throw new Exception("O numeros devem ser d >= 1, d <= 31, d >= 1, d <= 12, a > 1753!");
        }
        if (m == 1 || m == 2) {
            m = m + 12;
            a = a - 1;
        }

        int i = d + 2 * m + 3 * (m + 1);
        int j = 5 + a + a / 4 - a / 100 + (a / 400);
        int s = i / j;

        return s % 7;
    }

    private boolean dataInvalida(int d, int a) {
        // FIXME admite 31/04/2019 (erro)
        return (d < 1 || d > 31) || (d < 1 || d > 12) || (a <= 1753);
    }

    public int restoDivisaoInteira(int x, int y) throws Exception {
        if (y >= 0 && x > 0) {

            int s = x;
            while (y <= s) {
                s = s - y;
                y = y + 1;
            }

            return s;
        } else {
            throw new Exception("Os numeros x tem que ser maior 0 e y tem que ser maior");
        }
    }

    public int somaNaturais(int n) throws Exception {
        if (n >= 1) {

            int i = 2;
            int s = 1;
            while (i <= n) {
                s += i;
                i += 1;
            }

            return s;
        } else {
            throw new Exception("O numero n tem que ser maior que 1");
        }
    }


    public long fatorial(int n) throws Exception {
        if (n >= 1) {

            int i = 2;
            long f = 1;
            while (i <= n) {
                f = f * i;
                i = i + 1;
            }

            return f;
        } else {
            throw new Exception("O numero n tem que ser maior que 1");
        }
    }

    public int produto(int a, int b) {
        if (a >= 0 && b >= 0) {

            int totalParcelas = a;
            int parcela = b;

            if (b < a) {
                totalParcelas = b;
                parcela = a;
            }

            int i = 1;
            int s = 0;

            while (i <= totalParcelas) {
                s = s + parcela;
                i = i + 1;
            }

            return s;
        } else {
            throw new IllegalArgumentException("O numero a >= 0  e b >=0");
        }
    }

    public long potencia(int x, int y) {
        int produtorio = 1;
        int i = 1;

        while (i <= y) {
            produtorio = produto(produtorio, x);
            i = i + 1;
        }

        return produtorio;
    }

    public double pi(int n) {
        int i = 1;
        int s = -1;
        int d = -1;
        double p = 0;

        while (i <= n) {
            d = d + 2;
            s = -1 * s;
            p = p + (4 * s) / d;
            i = i + 1;
        }

        return p;
    }

    public double logaritmoNatural(int n, int k) throws Exception {
        if (n >= 1 && k >= 2) {

            int i = 2;
            double e = n + 1;
            int numerador = n;
            int denomidador = 1;

            while (i <= k) {
                numerador = numerador * numerador;
                denominador = denominador * i;
                e += (numerador / denominador);
                i += 1;
            }

            return e;
        } else {
            throw new RangeError("O numeros tem que ser n >= 1 && k >= 2");
        }
    }

    public double razaoAurea(int x, int y, int k) throws Exception {
        if ((x >= 0 && x < y) && k > 0) {

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
        } else {
            throw new Exception("Números deve ser: x >= 0, x < y e k > 0");
        }
    }

    public boolean quadradoPerfeito(int n) throws Exception {
        if (n < 1) {
            throw new Exception("O numero 'n' deverá ser maior que 1");
        }

        int i = 1;
        int s = 1;

        while (s < n) {
            i += 2;
            s += i;
        }

        if (s = n) {
            return true;
        } else {
            return false;
        }
    }

    public double raiz(int n, int i) {
        double r = 1;

        while (i >= 0) {
            r = (r + n / r) / 2;
            i -= 1;
        }

        return r;
    }

    public boolean primo(int n) throws Exception {
        if (n < 1) {
            throw new Exception("O numero 'n' tem que ser maior que 1");
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

    public intArray crivoErastostenes(intArray a, int n) throws Exception {
        if (n < 1) {
            throw new Exception("O numero 'n' tem que ser maior que 1");
        }

        for (int i = 2; i < n; i++) {
            if (a[i] != 0) {
                throw new Exception("Existe valores em a, onde nao sao iguais a zero");
            }
        }

        int i = 2;
        int multiplo;
        double limite = Math.sqrt(n);
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

    public int mdc(int a, int b) throws Exception {
        if (b > a && b < 0) {
            throw new Exception("Os numeros deverao ser a >= b e b > 0");
        }

        while (b != 0) {
            int m = a % b;
            a = b;
            b = m;
        }
        return a;
    }

    public int mdc2(int a, int b) throws Exception {
        if (b < 0) {
            throw new Exception("Os numero deverao 'b' tem que ser maior que zero!");
        }

        for (int i = 0; i < a.lenth; i++) {
            if (a < b) {
                throw new Exception("Existem valores em no vetor a que e' menor que 'b'!");
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

    public int horner(int x, int g, intArray a) throws Exception {
        if (g < 1) {
            throw new Exception("g deve ser maior que zero");
        }

        int p = a[g - 1];
        int i = g - 1;
        while (i >= 0) {
            p = p * x + a[i];
            i -= 1;
        }

        return p;
    }

    public long fibonacci(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("O numero 'n' tem que ser n>=0");
        }

        int a = 0;
        long c = 1;
        long t;

        if (n == 0 || n == 1) {
            return n;
        }

        int i = 1;
        while (i <= n) {
            t = c;
            c += a;
            a = t;
            i += 1;
        }

        return c;
    }

    public boolean cpf(intArray d) throws Exception {
        if (d.length != 11) {
            throw Exception("o cpf deve ter 11 digitos");
        }

        int j = 0;
        int k = 0;
        for (int i = 0; i < 9; i++) {
            j += d[i];
        }

        for (int i = 1; i < 10; i++) {
            k += d[i];
        }

        int dj = (j % 11) % 10;
        int dk = (k % 11) % 10;

        if (dj == d[d.length - 1] && dk == d[d.length]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cpf2(intArray d) throws Exception {
        if (d.length != 11) {
            throw Exception("o cpf deve ter 11 digitos");
        }

        int c = 8;
        int p = d[9];
        int s = d[9];

        while (c >= 1) {
            p += d[c];
            s += p;
            c -= 1;
        }

        int j = (s % 11) % 10;
        int k = ((s - p + 9 * d[10]) % 11) % 10;

        if (j == d[d.length - 1] && k == d[d.length]) {
            return true;
        } else {
            return false;
        }
    }
}

