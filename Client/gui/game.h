//
// Created by caman on 11/4/2022.
//

#ifndef CLIENT_GAME_H
#define CLIENT_GAME_H

#endif //CLIENT_GAME_H

#include <SFML/Graphics.h>

/***
 * Controla la interfaz de juego
 * @param main_window ventana del programa
 * @param sprite sprite del carro del jugador
 * @param pos posición del carro del jugador
 * @param player structura con la información recibida del servidor
 */
void game (sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos, struct Player *player);

