const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.valorPi;

test("calcula valor aproximado", () => {
    expect(funcao(700)).toBe(3.1401640828900845);
});

test("argumento null/undefined", () => {
    expect(() => {funcao();}).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um", "dois");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    expect(() => {
        funcao(-1);
    }).toThrow(RangeError);
});

test("o argumento não inteiro", () => {
    expect(() => funcao(11.1)).toThrow(TypeError);
});
