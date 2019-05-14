const Algoritmos = require("../aula-01");
const funcao = Algoritmos.verificaCubosDosDigitos;

test("153 satisfaz (caso classico)", () => {
    expect(funcao(153)).toBe(true);
});

test("154 nao satisfaz", () => {
    expect(funcao(154)).toBe(false);
});

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd"); }).toThrow();
});

test("valor negativo fora da faixa", () => {
    expect(() => { funcao(-1); }).toThrow(RangeError);
});

test("valor com mais de 3 digitos fora da faixa", () => {
    expect(() => funcao(1000)).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao(10.3)).toThrow(RangeError);
});
