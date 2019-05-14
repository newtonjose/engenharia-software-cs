const algoritmos = require("./aula-01");
const a = new algoritmos();

const funcao = a.restoDivisaoInteira();

test("data que satisfaz (data valida)", () => {
    expect(funcao(14, 5)).toBe(0);
});