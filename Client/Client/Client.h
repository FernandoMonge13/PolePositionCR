
#ifndef PRUEBA_CLIENT_H
#define PRUEBA_CLIENT_H

#include <stdbool.h>
#include <winsock2.h>
#pragma comment(lib,"ws2_32.lib")
#include <stdio.h>
#include "../Json/cJSON.h"

bool Connect();
void createJson();
void readJson();

#endif //PRUEBA_CLIENT_H
