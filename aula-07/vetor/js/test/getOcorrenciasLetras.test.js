const EstruturasIteracao = require("../EstruturasIteracao");
const funcao = EstruturasIteracao.getOcorrenciasLetras;

test("encontra ocorrencias de letras", () => {
    const msg = "messagem";
    const expected = {a: 1, e: 2, g: 1, m: 2, s: 2};
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