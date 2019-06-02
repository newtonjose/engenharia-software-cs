const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.quadradoPerfeito;

test("verifica se numero é quadrado perfeito (situação verdadeira)", () => {
    expect(funcao(4)).toBe(true);
})

test("verifica se numero é quadrado perfeito (situação falsa)", () => {
    expect(funcao(2)).toBe(false);
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
