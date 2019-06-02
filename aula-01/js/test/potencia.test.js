const Algoritmos = require("../aula-01");
const funcao = Algoritmos.calculaPotencia;

test("calcula a potencia correta", () => {
    expect(funcao(2, 2)).toBe(4);
});

test("argumento null/undefined", () => {
    expect(() => {funcao();}).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um", "dois");
    }).toThrow();
});

test("primeiro argumento fora da faixa", () => {
    expect(() => {
        funcao(-1, 1);
    }).toThrow(RangeError);
});

test("segundo argumento fora da faixa", () => {
    expect(() => {
        funcao(1, -1);
    }).toThrow(RangeError);
});

test("primeiro argumento deve ser inteiro", () => {
    expect(() => funcao(11.1, 10)).toThrow(RangeError);
});

test("segundo argumento deve ser inteiro", () => {
    expect(() => funcao(11, 10.0)).toThrow(RangeError);
});
