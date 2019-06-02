const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.somaNaturais;

test("soma dos naturais caso valido", () => {
    expect(funcao(5)).toBe(15);
});

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd"); }).toThrow();
});

test("valor fora da faixa", () => {
    expect(() => { funcao(0);}).toThrow(RangeError);
});

test("valor que não é inteiro", () => {
    expect(() => { funcao(10.3);}).toThrow(TypeError);
});
