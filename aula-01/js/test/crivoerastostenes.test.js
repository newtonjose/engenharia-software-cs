const Algoritmos = require("../aula-01");
const funcao = Algoritmos.crivoErastostenes;

//~ test("verifica se o numero é primo pelo crivo de erastostenes (situação verdadeira)", () => {
	//~ const vet = [0, 0, 0, 0, 0, 0, 0]
    //~ expect(funcao(7, vet)).toBe(true);
//~ })

test("argumento null/undefined", () => {
    expect(() => {
		funcao();
	}).toThrow();
});

test("argumento nao numerico", () => {
    expect(() => {
        funcao("um", "vetor");
    }).toThrow();
});

test("o argumento fora da faixa", () => {
	let vet = []
    expect(() => {
        funcao(0, vet);
    }).toThrow(RangeError);
    
    vet = [0, 0, 1, 0, -1, 0, 0]
    expect(() => {
        funcao(7, vet);
    }).toThrow(RangeError);
});

test("o argumento deve ser do tipo inteiro", () => {
    expect(() => {
		const vet = [0]
        funcao(1.5, vet);
    }).toThrow(RangeError);
});
