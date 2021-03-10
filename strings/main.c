/*
 * main.c
 *
 *  Created on: 10 mar. 2021
 *      Author: suhar.txabarri
 */
#include <stdlib.h>
#include <stdio.h>
#include "operaciones/operaciones.h"
#include <STRING.H>

int main(void)
{
	char w[] = "Hola mundo";

	char * c = (char *) malloc(5 * sizeof(char));
	c[0] = 'H';
	c[1] = 'o';
	c[2] = 'l';
	c[3] = 'a';
	c[4] = '\0';

	printf("%d\n", strcmp(w, c));
	fflush(stdout);

	printf("%d", strlen(c));

	return 0;
}


