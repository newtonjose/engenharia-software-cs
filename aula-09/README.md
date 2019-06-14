# Programa de serialização de arquivo Json.
## Requisitos:

2)
- Para cada arquivo JSON gerado por este sistema, deverá ser exportado,
pela aplicação a ser desenvolvida em arquivo binário.

3)
- a nota fiscal em formato binário, deve ser armazenada em um arquivo cujo
nome é `<sha-256>.dat`, onde `<sha-256>` é o valor de hash da sequência de bytes
em questão. ==> Obter esse a hash usando um programa SHA-256.
- O nome deve usar o padrão de codificação hexadecimal em letras minúsculas.

4)
- Cada sequência de bytes corresponde a uma nota é armazenadas em um arquivo
.dat.
- Compressão do arquivo em formato zip.

## Refêrencias

- http://www.ricardogiaviti.com.br/2016/10/serializacao-objetos-java-json-jackson-gson/