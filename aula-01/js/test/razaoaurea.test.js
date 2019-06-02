const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.razaoAurea;

test("calcula valor da razão aurea", () => {
    expect(funcao(1, 2, 1)).toBe(1.5);
})

test("argumento null/undefined", () => {
    expect(() => {funcao();}).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um", "dois", "tres");
    }).toThrow();
});

test("primeiro argumento fora da faixa", () => {
    expect(() => {
        funcao(-1, 2, 1);
    }).toThrow(RangeError);
});

test("segundo argumento fora da faixa", () => {
    expect(() => {
        funcao(10, 1, 1);
    }).toThrow(RangeError);
});

test("terceiro argumento fora da faixa", () => {
    expect(() => {
        funcao(1, 2, 0);
    }).toThrow(RangeError);
});

test("os argumento devem ser do tipo inteiro", () => {
    expect(() => funcao(1.0, 2.5, 1.0)).toThrow(RangeError);
});
