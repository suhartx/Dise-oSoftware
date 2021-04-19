/*
 * main.c
 *
 *  Created on: Apr 19, 2021
 *      Author: suhar.txabarri
 */

#include <stdio.h>
#include "cadena.h"
#include <stdlib.h>
#include <string.h>
#define MAX 3


int main (void){

char texto[20];
char tmpstr[20];


Reflejo reflejos[MAX];
int num = 0;
do {
	fflush(stdin);
	printf("\nIntroduce los textos correspondientes\n");
	fflush(stdout);

	fgets(tmpstr,20, stdin);//Es mas seguro esta via
	sscanf(tmpstr, "%s", texto);//con una variable sola estaria bien


	reflejos[num] = crearEspejo(texto);



} while (num<MAX);
for (int i = 0; i < MAX; ++i) {
	fflush(stdin);
	printf("\n%s\n%s\n", reflejos[i].str, reflejos[i].rstr);
	fflush(stdout);
	liberarEspejo(&reflejos[i]);
}
return 0;


}
char* mirror_str(Reflejo *r){
	char* resultado;
	resultado = (char*)malloc(sizeof(char)*strlen(r->str)*2-2);

	char *destino = &resultado[strlen(resultado)];
	char *origen =  &r->str[1];

	while(origen!='\0'){
		*destino = *origen;
		destino++;
		origen++;
	}
	return resultado;
}

char** reflejoak(Reflejo *r){
	char ** resultado =  (char**)malloc(sizeof(char*)* MAX);
	for (int i = 0; i < MAX; ++i) {

	}
	return 0;
}
