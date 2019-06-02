const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.numeroPrimo;

test("verifica se numero o numero é primo (situação verdadeira)", () => {
    expect(funcao(2)).toBe(true);
})

test("verifica se numero o numero é primo (situação falsa)", () => {
    expect(funcao(4)).toBe(false);
})

test("argumento null/undefined", () => {
    expect(() => {
		funcao();
	}).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    expect(() => {
        funcao(0);
    }).toThrow(RangeError);
});

test("o argumento deve ser do tipo inteiro", () => {
    expect(() => {
        funcao(1.5);
    }).toThrow(RangeError);
});
