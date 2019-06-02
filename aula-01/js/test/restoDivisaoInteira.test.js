const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.restoDivisaoInteira;

test("resto da divisão caso valido (data valida)", () => {
    expect(funcao(10, 5)).toBe(0);
});

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd", "y"); }).toThrow();
});

test("valor negativo fora da faixa", () => {
    expect(() => { funcao(-10, -5);}).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => { funcao(10.3, 10.5);}).toThrow(RangeError);
});
