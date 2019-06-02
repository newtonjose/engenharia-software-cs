const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.logaritmoNatural;

test("calcula valor do logaritmo", () => {
    expect(funcao(1, 2)).toBe(2.5);
})

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
        funcao(10, 1);
    }).toThrow(RangeError);
});

test("primeiro argumento deve ser inteiro", () => {
    expect(() => funcao(11.1, 10)).toThrow(TypeError);
});

test("segundo argumento deve ser inteiro", () => {
    expect(() => funcao(11, 10.1)).toThrow(TypeError);
});
