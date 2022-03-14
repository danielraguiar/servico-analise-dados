# Serviço de Análise de Dados

Serviço de análise de dados, onde o sistema fará leitura de arquivos importados, analisará os dados e produzirá um relatório.

O serviço criará automaticamente uma pasta com nome de "data" no caminho c:/home/ e dentro dessa pasta serão criadas duas pastas com nomes "in" e "out"

Na pasta c:/home/data/in é o local onde os arquivos serão importados, toda vez que um novo arquivo for submetido nesta pasta, o serviço irá produzir um relatório sobre o mesmo na pasta c:/home/data/out


# Executar
```
No terminal navegar até a pasta /servico-analise-dados
Executar: $ mvn clean install spring-boot:run
```

# Exemplo de arquivos:
```
salvar em: c:/home/data/in/file01
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
```
```
salvar em: c:/home/data/in/file02
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
001ç1234567801234çAndreç50000
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
002ç2345675434544340çManuelçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
003ç11ç[1-10-100,2-30-2.50,3-40-3.10]çAndre
```

```
salvar em: c:/home/data/in/file03
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
001ç1234567801234çAndreç50000
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
002ç2345675434544340çManuelçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo
003ç11ç[1-34-10,2-33-1.50,3-40-0.10]çAndre
```
