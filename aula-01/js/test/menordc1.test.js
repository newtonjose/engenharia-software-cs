const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.maiorDivisorComum;

test("verifica se o numero é primo pelo crivo de erastostenes (situação verdadeira)", () => {
    expect(funcao(4, 2)).toBe(2);
})

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um", "dois");
    }).toThrow();
});

test("os argumentos fora da faixa", () => {
    expect(() => {
        funcao(1, -1);
    }).toThrow(RangeError);

    expect(() => {
        funcao(1, 2);
    }).toThrow(RangeError);
});

test("os argumentos devem ser do tipo inteiro", () => {
    expect(() => {
        funcao(1.5, 2);
    }).toThrow(TypeError);

    expect(() => {
        funcao(1, 2.4);
    }).toThrow(TypeError);
});
