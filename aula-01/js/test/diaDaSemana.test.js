const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.diaDaSemana;

test("data que satisfaz (data valida)", () => {
    expect(funcao(14, 5, 2019)).toBe(2);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow();
});


test("argumento nao numerico", () => {
    expect(() => {
        funcao("onze", "dezembro", "dois mil");
    }).toThrow();
});

test("valor negativo fora da faixa", () => {
    expect(() => {
        funcao(-1, -12, -1992);
    }).toThrow(RangeError);
});

test("valor deve ser inteiro", () => {
    expect(() => funcao(11.1, 10, 1755)).toThrow(TypeError);
});
