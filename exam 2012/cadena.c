/*
 * cadena.c
 *
 *  Created on: Apr 19, 2021
 *      Author: suhar.txabarri
 */

#include <stdio.h>
#include<stdlib.h>
#include "cadena.h"
#include <string.h>

Reflejo crearEspejo(char*str){
	Reflejo r;

	r.str = (char*)malloc(sizeof(char)*strlen(str));
	r.rstr = (char*)malloc(sizeof(char)*strlen(str));
	int i = 0;
	for (i = 0; i < strlen(str); ++i) {
		r.str[i]=str[i];
		r.rstr[strlen(str)-i-1] = str[i];
	}
	r.rstr[i] = str[i];
	return r;
}
void liberarEspejo(Reflejo*r){
	free(r->str);
	r->str = NULL;
	free(r->rstr);
	r->rstr = NULL;
}
