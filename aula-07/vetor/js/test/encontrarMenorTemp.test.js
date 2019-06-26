const EstruturasIteracao = require("../EstruturasIteracao");
const funcao = EstruturasIteracao.encontrarMenorTemp

test("argumento null/undefined", () => {
    expect(() => {
        funcao();
    }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("vetor");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    let vet = []
    expect(() => {
        funcao(vet);
    }).toThrow(RangeError);
});

test("o argumento deve ser do tipo inteiro", () => {
    expect(() => {
        const vet = [10, "onze", 0]
        funcao(vet);
    }).toThrow(TypeError);
});
