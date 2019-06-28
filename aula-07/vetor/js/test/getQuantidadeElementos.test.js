const EstruturasIteracao = require("../EstruturasIteracao");
const funcao = EstruturasIteracao.getQuantidadeElementos;

test("encontra quantidade de elementos", () => {
    const vet = [4, 4, 6, 11, 5];
    expect(funcao(4, vet)).toBe(2);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao(null, [null]);
    }).toThrow();

    expect(() => {
        funcao(undefined, [undefined]);
    }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("numero", "vetor");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    let vet = [];
    expect(() => {
        funcao(0, vet);
    }).toThrow(RangeError);
});

test("o argumento deve ser do tipo inteiro", () => {
    expect(() => {
        const vet = [10, "onze", 0];
        funcao("um", vet);
    }).toThrow(TypeError);
});

test("o argumento não deve ser float", () => {
    expect(() => {
        const vet = [10, 1.8, 0];
        funcao(1.5, vet);
    }).toThrow(TypeError);
});

