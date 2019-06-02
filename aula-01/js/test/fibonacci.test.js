const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.fibonacci;

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd"); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(-1); }).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao(10.3)).toThrow(TypeError);
});

test("calcula núemro de fibonacci corretamente", () => {
    expect(funcao(8)).toBe(21);
});
