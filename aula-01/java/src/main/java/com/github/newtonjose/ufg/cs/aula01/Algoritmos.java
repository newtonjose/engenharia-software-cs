package com.github.newtonjose.ufg.cs.aula01;

/**
 * Implementação dos Algoritmos Matemáticos dado na aula 01.
 * <p>Os algoritmos implementados estão disponíveis na
 * <a href="https://drive.google.com/file/d/1zCxtSyjkEvF6T3ieJ0r3_BJii9kx-FMI"/>
 * aula 01.</p>
 * @author Josenilton Santos
 * @version 2.0
 */
public final class Algoritmos {

    /**
     * Contrutor da classe definido como privado pois a mesma é do tipo final.
     */
    private Algoritmos() {

    }

    /**
     * Verifica se um dado número é primo usando o método Crivo de Erastóstenes.
     * @param num Número inteiro natural.
     * @param vetInt Array de inteiros, com valores iguais a zero.
     * @return boolean Retorna {true} se o array[n] == 1.
     * @throws IllegalArgumentException Caso argumento for n < 1.
     * @throws IllegalArgumentException Caso o array tiver valor != 0.
     */
    public static boolean calculaCrivoEratostenes(final int num,
                                                  final int... vetInt) {
        if (num < 1) {
            throw new IllegalArgumentException("Argumanto fora do intervalo: "
                    + "n >= 1.");
        }

        for (int i = 0; i < num; i++) {
            if (vetInt[i] != 0) {
                throw new IllegalArgumentException("Existe valores em a, onde "
                        + "nao sao iguais a zero");
            }
        }

        int multiplo;
        final double limite = Math.sqrt(num);

        int idx = 2;
        while (idx <= limite) {
            if (vetInt[idx] == 0) {
                multiplo = idx + 1;

                while (multiplo <= num) {
                    vetInt[multiplo] = 1;
                    multiplo = multiplo + idx;
                }
            }
            idx += 1;
        }

        return vetInt[num] != 1;
    }

    /**
     * Função auxiliar para validar uma data.
     *
     * @param dia Dia do mês.
     * @param mes Mês do ano.
     * @param ano Ano depois de 1753.
     * @return boolean Verdadeiro caso a data seja valida, false caso contrário.
     */
    private static boolean dataInvalida(final int dia, final int mes,
                                        final int ano) {
        return dia < 1 || dia > ConstAux.DIA_MAX || mes < 1
                || mes > ConstAux.MES_MAX || ano <= ConstAux.ANO_MIN;
    }

    /**
     * Dado uma data, retorna o dia da semana: 1 - segunda; 2 - terça, 3 ...
     * @param dia Numero natural menor ou igual a 31.
     * @param mes Número natural menor ou igual a 12.
     * @param ano Número natural maior ou igual a 1753.
     * @return int Retorna um número representando o dia da semana.
     * @throws IllegalArgumentException Caso os argumento sejam invalidos.
     */
    public static int getDiaDaSemana(final int dia, int mes,
                                     int ano) {
        if (dataInvalida(dia, mes, ano)) {
            throw new IllegalArgumentException("O numeros devem ser: "
                    + "1 <= dia <= 31, 1 <= mes <= 12 e ano > 1753!");
        }

        final boolean janOuFev = mes == 1 || mes == 2;

        if (janOuFev) {
            mes = mes + ConstAux.NUM_MESES;
        }

        if (janOuFev) {
            ano = ano - 1;
        }

        final int drDobbsExpr = dia + (2 * mes)
                + ((ConstAux.NUM_TRES * (mes + 1)) / ConstAux.NUM_CINCO) + ano
                + (ano / ConstAux.NUM_QUATRO) - (ano / ConstAux.NUM_CEM)
                + (ano / ConstAux.NUM_QUATROCENTOS);

        return drDobbsExpr % ConstAux.DIAS_SEMANA;
    }

    /**
     * Calcula o fatorial de um dado numero natural sem usar recursividade.
     *
     * @param num Número inteiro natural.
     * @return int Fatorial do número n.
     * @throws IllegalArgumentException Argumento fora do intervalo: n >= 1.
     */
    public static long calculaFatorial(final int num) {
        if (num < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        long fatorial = 1;
        for (int i = 2; i <= num; i++) {
            fatorial = fatorial * i;
        }

        return fatorial;
    }

    /**
     * Calcula o número de Fibonacci sem usar recursividade.
     * @param num Número inteiro natural.
     * @return long Número inteiro natural.
     * @throws IllegalArgumentException Argumento fora do intervalo: n >= 0.
     **/
    public static long fibonacci(final long num) {
        if (num < 0) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n>=0");
        }

        long auxFibo;
        long aux = 0;
        long fibo = 1;
        for (int i = 1; i <= num; i++) {
            auxFibo = fibo;
            fibo = fibo + aux;
            aux = auxFibo;
        }

        return fibo;
    }

    /**
     * Avalia um polinônimo por meio de somas, produtos e potências.
     * @param poli Número real.
     * @param aprox Número real.
     * @param vetNum Array de numeros rais.
     * @return int Número real.
     * @throws IllegalArgumentException Caso o argumento g < 1.
     */
    public static int regraHorner(final int poli, final int aprox,
                                  final int... vetNum) {
        if (aprox < 1) {
            throw new IllegalArgumentException("g deve ser maior que zero");
        }

        int numHorner = vetNum[aprox - 1];
        for (int i = aprox - 1; i >= 0; i--) {
            numHorner = numHorner * poli + vetNum[i];
        }

        return numHorner;
    }

    /**
     * Calcula o logaritmo natural de um dado número usando uma aproximação.
     * @param num Numero inteiro natural.
     * @param aprox Numero inteiro nartual usado como o fator de aproximação.
     * @return double Logaritmo do parâmetro.
     * @throws IllegalArgumentException Caso temos num < 1 || k < 2.
     */
    public static double calculaLogNatural(final int num, final int aprox) {
        if (num < 1 || aprox < 2) {
            throw new IllegalArgumentException("O numeros tem que ser num >= 1 "
                    + "&& k >= 2");
        }

        double logNatural = num + 1;
        int numerador = num;
        int denominador = 1;

        for (int i = 2; i <= aprox; i++) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            logNatural = logNatural + (numerador / denominador);
        }

        return logNatural;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros.
     * @param numA Número inteiro natural.
     * @param numB Número inteiro natural.
     * @return int Máximo divisor comum de a e b.
     * @throws IllegalArgumentException Se os argumentos b > a ou b < 0
     **/
    public static int maiorDivisorComum(final int numA, final int numB) {
        if (numB > numA || numB < 0) {
            throw new IllegalArgumentException("Os numeros deverao ser a >= b"
                    + " e b > 0");
        }

        int maiorDc;
        int auxA = numA;
        int auxB = numB;
        while (auxB != 0) {
            maiorDc = auxA % auxB;
            auxA = auxB;
            auxB = maiorDc;
        }

        return auxA;
    }

    /**
     * Calcula maior divisor comum entre dois números inteiros sem usar resto.
     * @param numB Número inteiro natural.
     * @param numA Array de números inteiros naturais.
     * @return int Máximo divisor comum de numA e b.
     * @throws IllegalArgumentException Se o argumento b < 0.
     **/
    public static int maiorDivisorComumSemResto(final int numA,
                                                final int numB) {
        if (numB < 0) {
            throw new IllegalArgumentException("Os numero deverao 'b' tem que "
                    + "ser maior que zero!");
        }

        int auxA = numA;
        int auxB = numB;
        while (auxA != auxB) {
            if (auxA > auxB) {
                auxA = auxA - auxB;
            } else {
                auxB = auxB - auxA;
            }
        }

        return auxA;
    }

    /**
     * Retorna o valor de Pi aproximado pelo um dado número.
     *
     * @param num Numero inteiro natural.
     * @return double Valor do número Pi aproximado.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    public static double numeroPi(final int num) {
        if (num < 1) {
            throw new IllegalArgumentException("O numero n tem que ser n >= 1");
        }

        double numPi = 0;
        int prod = -1;
        int aux = -1;

        for (int i = 1; i <= num; i++) {
            aux = aux + 2;
            prod = prod * -1;
            numPi = numPi + (prod * ConstAux.MULT) / aux;
        }

        return numPi;
    }

    /**
     * Verifica se um número é primo.
     * @param num Número inteiro natural.
     * @return boolean Retorna {true} caso n é primo, {false} caso contrario.
     * @throws IllegalArgumentException Se o argumento n < 1.
     */
    public static boolean numeroPrimo(final int num) {
        if (num < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "maior que 1");
        }

        boolean aux = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                aux = false;
            }
        }

        return aux;
    }

    /**
     * Calcula a potência de dois numeros usando apenas somas.
     * @param numX Numero inteiro natural.
     * @param numY Número inteiro natural.
     * @return int Potência dos parâmetros.
     * @throws IllegalArgumentException Se os argumentos x <= 0 ou y <= 0.
     */
    public static int calculaPotencia(final int numX, final int numY) {
        if (numX <= 0 || numY <= 0) {
            throw new IllegalArgumentException("Os numeros x e y deverão "
                    + "ser x >=0 e y >=0.");
        }

        int produtorio = 1;
        for (int i = 1; i <= numY; i++) {
            produtorio = calculaProdutoInteiros(produtorio, numX);
        }

        return produtorio;
    }

    /**
     * Calcula o produto dos dois numeros usando somatório.
     * @param numA Número inteiro natural.
     * @param numB Número inteiro natural.
     * @return int Produto dos dois parâmetros.
     * @throws IllegalArgumentException Se os argumentos a < 0 ou b < 0.
     */
    public static int calculaProdutoInteiros(final int numA, final int numB) {
        if (numA < 0 || numB < 0) {
            throw new IllegalArgumentException("Os numeros a e b tem que ser "
                    + "maior ou igual a zero");
        }

        int totalParcelas = numA;
        int parcela = numB;

        if (numB < numA) {
            totalParcelas = numB;
            parcela = numA;
        }

        int produto = 0;
        for (int i = 1; i <= totalParcelas; i++) {
            produto = produto + parcela;
        }

        return produto;
    }

    /**
     * Maior valor válido para propriedade 153.
     */
    private static final int MAX = 999;

    /**
     * Menor valor válido para propriedade 153.
     */
    private static final int MIN = 100;

    /**
     * Número usado como divisor para obter centena.
     */
    private static final int DIVISOR_CEM = 100;

    /**
     * Número usado como divisor para obter dezena.
     */
    private static final int DIVISOR_DEZ = 10;

    /**
     * Verifica se a soma dos cubos dos digitos de um dado número é
     * igual ao número dado.
     * @param num Numero inteiro natural.
     * @return boolean Retorna {true} se satisfazer a propriedade 153.
     * @throws IllegalArgumentException Se o argumento n < 100 ou n > 999.
     */
    public static boolean verificaPropriedade153(final int num) {
        if (num < MIN || num > MAX) {
            throw new IllegalArgumentException("O número não está no "
                    + "intervalor: 100 <= n <= 999");
        }

        final int aux = num % DIVISOR_CEM;

        return Math.pow(num / DIVISOR_CEM, ConstAux.NUM_TRES)
                + Math.pow(aux / DIVISOR_DEZ, ConstAux.NUM_TRES)
                + Math.pow(aux % DIVISOR_DEZ, ConstAux.NUM_TRES) == num;
    }

    /**
     * Maximo número que a propriedade se aplica.
     */
    private static final int MAX2 = 9999;

    /**
     * Verifica se um dado numero é verdadeiro usando a Propriedade 3025.
     * @param num Numero inteiro natural.
     * @return boolean Retorna {true} se o número fornecido como argumento
     * satisfaz a propriedade Propriedade 3025, {false} caso contrário.
     * @throws IllegalArgumentException Se o argumento n < 0 ou n > 9999.
     */
    public static boolean verificaPropriedade3025(final int num) {
        if (num < 0 || num > MAX2) {
            throw new IllegalArgumentException("Numero fora do range "
                    + "100 <= n <= 999");
        }

        final double prop = num / DIVISOR_CEM + num % DIVISOR_CEM;

        return prop * prop == num;
    }

    /**
     * Constante usada pelo método verificaQuadradoPerfeito.
     */
    private static final int CONST = 2;

    /**
     * Verifica se o dado número é um quadrado perefeito.
     * @param num Número inteiro.
     * @return {boolean} boolean Retorna {true} se o número fornecido é
     * um quadrado perfeito, caso contrário, {false}.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    public static boolean verificaQuadradoPerfeito(final int num) {
        if (num < 1) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 1");
        }

        int idx = 1;
        int quadrado = 1;
        while (quadrado < num) {
            idx = idx + CONST;
            quadrado = quadrado + idx;
        }

        return quadrado == num;
    }

    /**
     * Constante divisora usada pelo método @raizQuadrada.
     */
    private static final int DIV = 2;

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     * @param num Número racional positivo.
     * @param precisao Numero inteiro nartual usado como o fator de prescisão.
     * @return double Retorna raiz quadrada de n usando a precisão i.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     *                                  intervalos: n > 0.
     */
    public static double raizQuadrada(final int num, final int precisao) {
        if (num < 0) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 0");
        }
        double numRaiz = 1;

        int aux = precisao;
        while (aux >= 0) {
            numRaiz = (numRaiz + num / numRaiz) / DIV;
            aux = aux - 1;
        }

        return numRaiz;
    }

    /**
     * Calcula a razão área usando uma determinada prescisão.
     * @param numX Numero inteiro natural.
     * @param numY Numero inteiro natural.
     * @param prescisao Numero inteiro natural usado como fator de prescisão.
     * @return double Razão áurea de dois numeros.
     * @throws IllegalArgumentException Caso temos: x < 0 ou x > y ou k <= 0.
     */
    public static double calculaRazaoAurea(final int numX, final int numY,
                                           final int prescisao) {
        if (numX < 0 || numX > numY || prescisao <= 0) {
            throw new IllegalArgumentException("Números deve ser: x >= 0, x < "
                    + "y e k > 0");
        }

        int aux;
        int numY1 = numY;
        int numAurea = numX;
        for (int i = 1; i <= prescisao; i++) {
            aux = numY1;
            numY1 = numY1 + numAurea;
            numAurea = aux;
        }

        return numY1 / numAurea;
    }

    /**
     * Dado dois numeros, está função encontra o resto da divisão de x por y.
     * @param numX Numero racional.
     * @param numY Número racional.
     * @return int Retorna o resto da duvisão inteira.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     *                                  intervalos: y >= 0; x > 0.
     */
    public static int calculaRestoDivisao(final int numX, final int numY) {
        if (numX < 0 || numY <= 0) {
            throw new IllegalArgumentException("O numeros devem ser y >= 0 && "
                    + "x > 0.");
        }

        int resto = numX;
        while (numY <= resto) {
            resto = resto - numY;
        }

        return resto;
    }

    /**
     * Dado um número natural, soma os todos os primeiros naturais
     * ate o dado número.
     * @param num Número inteiro natural.
     * @return int Número inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    public static int somaNaturais(final int num) {
        if (num < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        int soma = 1;
        for (int i = 2; i <= num; i++) {
            soma = soma + i;
        }

        return soma;
    }

    /**
     * Constate resto usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int RESTO = 10;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int ONZE = 11;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int DEZ = 10;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int NOVE = 9;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int OITO = 8;

    /**
     * Verifica se um dado CPF é válido.
     * @param cpf Array de numeros rais.
     * @return boolean true ou false Valor lógico.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     *                                  número: 0 <= n >= 9.
     */
    public static boolean validaCPF(final int... cpf) {
        if (cpf.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        for (final int v : cpf) {
            if (v < 0 || v > NOVE) {
                throw new IllegalArgumentException("os números do cpf fora do "
                        + "range aceito.");
            }
        }

        int aux = 0;
        int aux1 = 0;

        for (int i = 0; i < NOVE; i++) {
            aux = aux + cpf[i];
        }

        for (int i = 1; i < DEZ; i++) {
            aux1 = aux1 + cpf[i];
        }

        final int digiJ = (aux % ONZE) % RESTO;
        final int digiK = (aux1 % ONZE) % RESTO;

        return digiJ == cpf[cpf.length - 1] && digiK == cpf[cpf.length];
    }

    /**
     * Verifica se um dado CPF é valido usando o Método de Horner.
     * @param cpf Array de numeros rais.
     * @return boolean true ou false Valor lógico.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     *                                  número: 0 <= n >= 9.
     */
    public static boolean validaCPFRegraHorner(final int... cpf) {
        if (cpf.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        for (final int v : cpf) {
            if (v < 0 || v > NOVE) {
                throw new IllegalArgumentException("os números do cpf fora do "
                        + "range aceito.");
            }
        }

        int aux1 = cpf[NOVE];
        int aux2 = cpf[NOVE];
        int oito = OITO;
        while (oito >= 1) {
            aux1 = aux1 + cpf[oito];
            aux2 = aux2 + aux1;
            oito = oito - 1;
        }

        final int digJ = (aux2 % ONZE) % RESTO;
        final int digK = ((aux2 - aux1 + NOVE * cpf[DEZ]) % ONZE) % RESTO;

        return digJ == cpf[cpf.length - 1] && digK == cpf[cpf.length];
    }
}
