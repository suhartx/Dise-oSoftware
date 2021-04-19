/*
 * cadena.h
 *
 *  Created on: Apr 19, 2021
 *      Author: suhar.txabarri
 */

#ifndef CADENA_H_
#define CADENA_H_
typedef struct{

	char*str;

	char*rstr;



}Reflejo;

Reflejo crearEspejo(char*str);
void liberarEspejo(Reflejo*r);
#endif /* CADENA_H_ */
