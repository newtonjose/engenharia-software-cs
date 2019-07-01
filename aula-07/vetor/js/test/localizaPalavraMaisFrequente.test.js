const EstruturasIteracao = require("../EstruturasIteracao");
const funcao = EstruturasIteracao.localizaPalavraMaisFrequente;

test("encontra ocorrencias de letras", () => {
    const msg = "uma mensagem é uma";
    const expected = "uma";
    expect(funcao(msg)).toEqual(expected);
});

test("argumento null/undefined", () => {
    expect(() => {
        funcao([null]);
    }).toThrow();

    expect(() => {
        funcao([undefined]);
    }).toThrow();
});

test("argumento numerico", () => {
    expect(() => {
        funcao(1);
    }).toThrow();
});