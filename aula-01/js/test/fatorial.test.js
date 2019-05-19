const Algoritmos = require("../aula-01");
const funcao = Algoritmos.fatorialNumero;


test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd"); }).toThrow(TypeError);
});

test("valor zero fora da faixa", () => {
    expect(() => { funcao(0); }).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao(10.3)).toThrow(RangeError);
});

test("fatorial de um numero (caso de sucesso)", () => {
    expect(funcao(5)).toBe(120);
});
