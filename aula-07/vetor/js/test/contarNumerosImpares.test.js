const EstruturasIteracao = require("../EstruturasIteracao");
const funcao = EstruturasIteracao.somaNumerosImpares;

test("encontra quantidade de impares", () => {
    const vet = [4, 3, 20, 11, 5];
    expect(funcao(vet)).toBe(19);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao([null]);
    }).toThrow();

    expect(() => {
        funcao([undefined]);
    }).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("vetor");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
    let vet = [];
    expect(() => {
        funcao(vet);
    }).toThrow(RangeError);
});

test("o argumento deve ser do tipo inteiro", () => {
    expect(() => {
        const vet = [10, "onze", 0];
        funcao(vet);
    }).toThrow(TypeError);
});

test("o argumento não deve ser float", () => {
    expect(() => {
        const vet = [10, 1.8, 0];
        funcao(vet);
    }).toThrow(TypeError);
});

