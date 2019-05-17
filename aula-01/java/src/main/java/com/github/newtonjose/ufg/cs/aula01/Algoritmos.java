package com.github.newtonjose.ufg.cs.aula01;
//
///**
// * <h1>Algoritmos Matemáticos.</h1>
// * Classe que implementa vários algoritmos acerca de propriedades matemáticas
// * e operações com números.
// * <p>Os algoritmos implementados estão disponíveis na
// * <a href="https://drive.google.com/file/d/1zCxtSyjkEvF6T3ieJ0r3_BJii9kx-FMI"/>
// * aula 01.</p>
// * <p></p>
// *
// * @author Josenilton Santos
// * @version 1.0
// * @since 2019-03-15
// */
//public class Algoritmos {
//
//
//
//    /**
//     * Dado dois numeros inteiros a função calcula o produto dos dois
//     * usando somatório.
//     *
//     * @param a Número inteiro natural.
//     * @param b Número inteiro natural.
//     * @throws IllegalArgumentException Se os argumentos estiverem fora
//     * dos intervalos: a >= 0; b >= 0.
//     * @return int Produto dos dois parâmetros.
//     */
//    public int produtoInteiros(final int a, final int b) {
//        if (a < 0 || b < 0) {
//            throw new IllegalArgumentException("Os numeros a e b tem que ser "
//                    + "maior ou igual a zero");
//        }
//
//        int totalParcelas = a;
//        int parcela = b;
//
//        if (b < a) {
//            totalParcelas = b;
//            parcela = a;
//        }
//
//        int i = 1;
//        int prod = 0;
//
//        while (i <= totalParcelas) {
//            prod = prod + parcela;
//            i = i + 1;
//        }
//
//        return prod;
//    }
//
//    /**
//     * Calcula a potência de dois numeros usando apenas somas.
//     *
//     * @param x Numero inteiro natural.
//     * @param y Número inteiro natural.
//     * @throws IllegalArgumentException Se os argumentos estiver fora dos
//     * intervalos: x >= 0; y >= 0.
//     * @return int Potência dos parâmetros.
//     */
//    public int calculaPotencia(final int x, final int y) {
//        int i = 1;
//        int produtorio = 1;
//
//        while (i <= y) {
//            produtorio = produtoInteiros(produtorio, x);
//            i = i + 1;
//        }
//
//        return produtorio;
//    }
//
//    /**
//     * Retorna o valor de Pi aproximado pelo um dado número.
//     *
//     * @param n Numero inteiro natural.
//     * @throws IllegalArgumentException Se o argumento estiver fora do
//     * intervalo: n >= 1.
//     * @return double Valor do número Pi aproximado.
//     */
//    public double numeroPi(final int n) {
//        if (n < 1) {
//            throw new IllegalArgumentException("O numero n tem que ser n >= 1");
//        }
//
//        int i = 1;
//        int s = -1;
//        int d = -1;
//        double numPi = 0;
//
//        while (i <= n) {
//            d = d + 2;
//            s = -1 * s;
//            numPi = numPi + (4 * s) / d;
//            i = i + 1;
//        }
//
//        return numPi;
//    }
//
//    /**
//     * Calcula o logaritmo natural de um dado número usando uma
//     * aproximação.
//     *
//     * @param n Numero inteiro natural.
//     * @param k Numero inteiro nartual usado como o fator de aproximação.
//     * @throws IllegalArgumentException Se os argumentos estiver fora dos
//     * intervalos: n >= 1; k >= 2.
//     * @return double Logaritmo do parâmetro.
//     */
//    public double logaritmoNatural(final int n, final int k) {
//        if (n < 1 && k < 2) {
//            throw new IllegalArgumentException("O numeros tem que ser n >= 1 "
//                    + "&& k >= 2");
//        }
//
//        int i = 2;
//        double logNatural = n + 1;
//        int numerador = n;
//        int denominador = 1;
//
//        while (i <= k) {
//            numerador = numerador * numerador;
//            denominador = denominador * i;
//            logNatural += (numerador / denominador);
//            i += 1;
//        }
//
//        return logNatural;
//    }
//
//    /**
//     * Calcula a razão área através do processo iniciado com dois
//     * números inteiros positivos e um valor que determina a precisão.
//     *
//     * @param x Numero inteiro natural.
//     * @param y Numero inteiro natural.
//     * @param k Numero inteiro natural usado como fator de prescisão.
//     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
//     * intervalos: x >= 0; x < y e k > 0.
//     * @return double Razão áurea de dois numeros.
//     */
//    public double razaoAurea(final int x, final int y, final int k) {
//        if ((x < 0 && x > y) && k <= 0) {
//            throw new IllegalArgumentException("Números deve ser: x >= 0, x < "
//                    + "y e k > 0");
//        }
//
//        int c = y;
//        int a = x;
//        int i = 1;
//
//        while (i <= k) {
//            int t = c;
//            c += a;
//            a = t;
//            i = i + 1;
//        }
//
//        return c / a;
//    }
//
//    /**
//     * Verifica se o dado número é um quadrado perefeito, satisfazendo
//     * esquação do algoritmo.
//     *
//     * @param n Número inteiro.
//     * @throws IllegalArgumentException Se o argumento estiver fora do
//     * intervalo: n >= 1.
//     * @return {boolean} boolean Retorna {true} se o número fornecido é
//     * um quadrado perfeito, caso contrário, {false}.
//     **/
//    public boolean quadradoPerfeito(final int n) {
//        if (n < 1) {
//            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
//                    + "que 1");
//        }
//
//        int i = 1;
//        int s = 1;
//
//        while (s < n) {
//            i += 2;
//            s += i;
//        }
//
//        return s == n;
//    }
//
//    /**
//     * Calcula a raiz quadrada de um número usando o Método Babilônico.
//     *
//     * @param n Número racional positivo.
//     * @param i Numero inteiro nartual usado como o fator de prescisão.
//     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
//     * intervalos: n > 0.
//     * @return double Retorna raiz quadrada de n usando a precisão i.
//     **/
//    public double raizQuadrada(final int n, int i) {
//        if (n < 0) {
//            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
//                    + "que 0");
//        }
//
//        double numRaiz = 1;
//
//        while (i >= 0) {
//            numRaiz = (numRaiz + n / numRaiz) / 2;
//            i -= 1;
//        }
//
//        return numRaiz;
//    }
//
//    /**
//     * Verifica se um número é primo quando seus únicos divisores são 1
//     * ou ele mesmo.
//     *
//     * @param n Número inteiro natural.
//     * @throws IllegalArgumentException Se o argumento estiver fora do
//     * intervalo: n >= 1.
//     * @return boolean Retorna {true} caso n é primo, {false} caso contrario.
//     **/
//    public boolean numeroPrimo(final int n) {
//        if (n < 1) {
//            throw new IllegalArgumentException("O numero 'n' tem que ser "
//                    + "maior que 1");
//        }
//
//        int i = 2;
//        while (i < n) {
//            if (n % i == 0) {
//                return false;
//            }
//
//            i += 1;
//        }
//
//        return true;
//    }
//
//    /**
//     * Verifica se um dado número é primo usando o método
//     * Crivo de Erastóstenes.
//     *
//     * @param n Número inteiro natural.
//     * @param a Array de inteiros, com valores iguais a zero.
//     * @throws IllegalArgumentException Se o argumento estiver
//     * for do intervalo: n > 1.
//     * @throws IllegalArgumentException Se o argumento array tiver valor
//     * diferente de zero.
//     * @return boolean Retorna {true} caso o valor da n possição do array
//     * seja diferente de 1, {false} caso contrario.
//     **/
//    public boolean crivoErastostenes(final int[] a, final int n) {
//        if (n < 1) {
//            throw new IllegalArgumentException("O numero 'n' tem que ser "
//                    + "maior que 1");
//        }
//
//        for (int i = 2; i < n; i++) {
//            if (a[i] != 0) {
//                throw new IllegalArgumentException("Existe valores em a, onde "
//                        + "nao sao iguais a zero");
//            }
//        }
//
//        int i = 2;
//        int multiplo;
//        final double limite = Math.sqrt(n);
//
//        while (i <= limite) {
//            if (a[i] == 0) {
//                multiplo = i + 1;
//
//                while (multiplo <= n) {
//                    a[multiplo] = 1;
//                    multiplo += i;
//                }
//            }
//
//            i += 1;
//        }
//
//        return a[n] != 1;
//    }
//
//    /**
//     * Calcula qual o maior divisor comum entre dois números inteiros.
//     *
//     * @param a Número inteiro natural.
//     * @param b Número inteiro natural.
//     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
//     * intervalos: a >= b e b > 0.
//     * @return int Máximo divisor comum de a e b.
//     **/
//    public int maiorDivisorComum(int a, int b) {
//        if (b > a && b < 0) {
//            throw new IllegalArgumentException("Os numeros deverao ser a >= b"
//                    + " e b > 0");
//        }
//
//        int m;
//
//        while (b != 0) {
//            m = a % b;
//            a = b;
//            b = m;
//        }
//
//        return a;
//    }
//
//    /**
//     * Calcula qual o maior divisor comum entre dois números inteiros
//     * sem usar resto da divisão inteira.
//     *
//     * @param b Número inteiro natural.
//     * @param a Array de números inteiros naturais.
//     * @throws IllegalArgumentException Se o primeiro argumento estiver
//     * fora do intervalo: b > 0.
//     * @return int Máximo divisor comum de a e b.
//     **/
//    public int maiorDivisorComumSemResto(int a, int b) {
//        if (b < 0) {
//            throw new IllegalArgumentException("Os numero deverao 'b' tem que "
//                    + "ser maior que zero!");
//        }
//
//        while (b != a) {
//            // 'a' sempre sera maior que 'b' pelo if anterior
//            if (a > b) {
//                a -= b;
//            } else {
//                b -= a;
//            }
//        }
//
//        return a;
//    }
//
//    /**
//     * Avalia um polinônimo por meio de somas, produtos e potências.
//     *
//     * @param x Número real.
//     * @param g Número real.
//     * @param a Array de numeros rais.
//     * @throws IllegalArgumentException Se o segundo argumento estiver for do
//     * intervalo: g > 1.
//     * @return int Número real.
//     **/
//    public int regraHorner(final int x, final int g, final int[] a) {
//        if (g < 1) {
//            throw new IllegalArgumentException("g deve ser maior que zero");
//        }
//
//        int p = a[g - 1];
//        int i = g - 1;
//        while (i >= 0) {
//            p = p * x + a[i];
//            i -= 1;
//        }
//
//        return p;
//    }
//
//    /**
//     * Calcula o número de Fibonacci sem usar recursividade.
//     *
//     * @param n Número inteiro natural.
//     * @throws IllegalArgumentException Se o argumento estiver fora do
//     * intervalo: n >= 0.
//     * @return long Número inteiro natural.
//     **/
//    public long fibonacci(final int n) {
//        if (n < 0) {
//            throw new IllegalArgumentException("O numero 'n' tem que ser n>=0");
//        }
//
//        long a = 0;
//        long fibo = 1;
//        long t;
//
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        int i = 1;
//        while (i <= n) {
//            t = fibo;
//            fibo += a;
//            a = t;
//            i += 1;
//        }
//
//        return fibo;
//    }
//
//    /**
//     * Verifica se um dado CPF segue a regra de formação dos digitos
//     * corretamente.
//     *
//     * @param d Array de numeros rais.
//     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
//     * @throws IllegalArgumentException Se no argumento tiver algum
//     * número: 0 <= n >= 9.
//     * @return boolean true ou false Valor lógico.
//     **/
//    public boolean validaCPF(final int[] d) {
//        if (d.length != 11) {
//            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
//        }
//
//        int j = 0;
//        int k = 0;
//        for (int i = 0; i < 9; i++) {
//            j += d[i];
//        }
//
//        for (int i = 1; i < 10; i++) {
//            k += d[i];
//        }
//
//        final int dj = (j % 11) % 10;
//        final int dk = (k % 11) % 10;
//
//        return (dj == d[d.length - 1]) && (dk == d[d.length]);
//    }
//
//    /**
//     * Verifica se um dado CPF segue a regra de formação dos digitos
//     * corretamenten usando o Método de Horner.
//     *
//     * @param d Array de numeros rais.
//     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
//     * @throws IllegalArgumentException Se no argumento tiver algum
//     * número: 0 <= n >= 9.
//     * @return boolean true ou false Valor lógico.
//     **/
//    public boolean validaCPFRegraHorner(final int[] d) {
//        if (d.length != 11) {
//            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
//        }
//
//        int c = 8;
//        int p = d[9];
//        int s = d[9];
//
//        while (c >= 1) {
//            p += d[c];
//            s += p;
//            c -= 1;
//        }
//
//        final int j = (s % 11) % 10;
//        final int k = ((s - p + 9 * d[10]) % 11) % 10;
//
//        return (j == d[d.length - 1]) && (k == d[d.length]);
//    }
//}
