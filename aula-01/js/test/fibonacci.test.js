const Algoritmos = require("../AlgoritmosMatematicos");
const funcao = Algoritmos.fibonacci();

test("calcula regra de horner corretamente", () => {
    expect(funcao(1, 2)).toBe(1);
});

//TODO: Test método fibonacci
