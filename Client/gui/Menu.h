//
// Created by caman on 9/4/2022.
//

#ifndef POLEPOSITIONCR_MENU_H
#define POLEPOSITIONCR_MENU_H

#endif //POLEPOSITIONCR_MENU_H

#include "../Client/Client.c"
#include <SFML/Graphics.h>


// Controla el menu del juego donde se selecciona el carro deseado
void menu();

// parece que funciona si creo la ventana y demás en la misma funcion
void game2();

void validarCarro(sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos, struct Player* player, int carro);
