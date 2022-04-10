
#ifndef PRUEBA_CLIENT_H
#define PRUEBA_CLIENT_H

#include <stdbool.h>
#include <winsock2.h>
#pragma comment(lib,"ws2_32.lib")
#include <stdio.h>
#include "../Json/cJSON.c"

struct Player{
    int id;
    int puntos;
    int vidas;
    int posX, posY;
    int posBalaX, posBalaY;
    int carro;
    bool running;
    bool conected;
    bool carSelect;
};

struct Player Connect();
void createJson();
void readJson();

#endif //PRUEBA_CLIENT_H
