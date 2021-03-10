/*
 * main.c
 *
 *  Created on: 10 mar. 2021
 *      Author: suhar.txabarri
 */
#include <stdlib.h>
#include <stdio.h>
#include "operaciones.h"
int main(void)
{
	int *p = malloc(3 * sizeof(int));
	p[0] = 1;
	p[1] = 2;
	p[2] = 3;


	printf("%d",sumar(p, 3));
	fflush(stdout);
	free(p);
	p = NULL;
	return 0;
}
int sumar(int a[], int size)
{
	int total = 0;
	int c = 0;
	int *p = &a[0]; // obtenemos la dirección al primer elemento.
	while (c < size)
	{
		total += *p;
		p++;
		c++;
}
	return total;
}

