# <center>EL CHAPITO</center> #

## Descrição
---------------------------------------------------------------------------------------------

  Trabalho da matéria de Programação I, do curso de Ciências da Computação da Universidade Federal da Fronteira Sul - Campus Chapecó.
  O trabalho tem por objetivo programar um agente que será usado para batalhar em uma arena, para isso utilizamos conhecimentos de
  programação orientada a objeto previamente mostrados em aula para a implementação do agente.
  O agente implementado tem o nome de EL CHAPITO e foi escolhido de forma aleatória. A seguir está a explicação das estratégias utilizadas por esse agente.

## Locomoção 
-----------------------------------------------------------------------------------------------
A locomoção é dada pelo método pensa(), inicialmente cada agente recebe uma direção aleatória,
e a cada rodada é guardada a direção que o agente está, quando qualquer uma das váriaveis que
guardam a direção atingirem o valor 25, é gerada uma nova direção aleatória para o agente ir
se espalhando pelo mapa.

## Energia
-----------------------------------------------------------------------------------------------
Quando um agente recebe energia, isso significa que ele está perto de um cogumelo, então o
agente em questão para e manda uma mensagem informando suas coordenadas para seus companheiros,
fazendo assim todos seguirem em direção ao cogumelo para aproveitar do ganho de energia.

## Divisão do agente
-----------------------------------------------------------------------------------------------
Se a energia do agente for maior do que 1100, ele se divide por igual.<br>O agente fica estático, quando fica com energia inferior ou igual a 150 para poupar energia e espera receber energia, então é verificado se a energia foi recuperada, caso tenha se recuperado o agente volta a se locomover pelo mapa.

## Método moverPara(int x, int y)
-----------------------------------------------------------------------------------------------
Esse foi o único método novo criado, ele serve para fazer a locomoção para uma determinada
direção que vai ser informada quando o método for chamado. É feito algumas condições se
aproveitando do método getX() e getY() para conseguir levar o agente para a coordenada informada.

## Ataque
-----------------------------------------
À medida que o agente se encontra com o inimigo, ele se move para outra direção que é escolhida aleatoriamente e tenta se esquivar para se proteger. 

## Autores ##

[Paulo Nunes](https://github.com/Paulocc)<br>
[Otávio Pato](https://github.com/otaviopato)
