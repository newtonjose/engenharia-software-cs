const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.regraHorner;

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao numerico", () => {
    expect(() => { funcao("abcd", "vet"); }).toThrow(TypeError);
    expect(() => { funcao(1, ["um", "dois", "tres"]); }).toThrow(TypeError);
});

test("valor fora da faixa", () => {
    expect(() => { funcao(1, []); }).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao(1.5, [0, 1, 2])).toThrow(TypeError);
});

test("regra de horner (caso de sucesso)", () => {
    expect(funcao(1, [0, 1, 2])).toBe(12);
});

