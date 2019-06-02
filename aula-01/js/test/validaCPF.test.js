const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.validaCPF;

const cpf = [0, 1, 5, 5, 7, 5, 3, 1, 0, 0, 5];
const cpf_invalido = [3, 4, 5, 5, 8, 6, 6, 9, 7, 8,0];
const cpf_error = [0, 1, 5, -5, 7, 5, 3, 1, 0, 0, 5];

test("argumento null/undefined", () => {
    expect(() => { funcao(); }).toThrow(Error);
});

test("argumento nao vetor", () => {
    expect(() => { funcao("1.4.4.5.6.7"); }).toThrow(TypeError);
    expect(() => { funcao(["um", "dois", "tres", "quatro", "cinco", "seis",
        "sete", "foo", "foo", "foo", "foo"]); }).toThrow(TypeError);
});

test("cpf com tamanho invalido", () => {
    expect(() => { funcao([]); }).toThrow(RangeError);
});

test("cpf com números invalidos", () => {
    expect(() => { funcao(cpf_error); }).toThrow(RangeError);
});

test("valida um cpf correto", () => {
    expect(funcao(cpf)).toBe(true);
});

test("valida um cpf invalido", () => {
    expect(funcao(cpf_invalido)).toBe(false);
});
