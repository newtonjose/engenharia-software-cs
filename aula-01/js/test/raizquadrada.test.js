const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.raizQuadrada;

test("calcula raiz quadada correta", () => {
    expect(funcao(1, 2)).toBe(1);
})

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow();
});

test("argumentos nao numericos", () => {
    expect(() => {
        funcao("um", "dois");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    expect(() => {
        funcao(-1, 2);
    }).toThrow(RangeError);
});

test("os argumentos devem ser do tipo inteiro", () => {
    expect(() => {
        funcao(1.5, 2.1);
    }).toThrow(TypeError);
});
