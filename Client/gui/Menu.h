//
// Created by caman on 9/4/2022.
//

#ifndef POLEPOSITIONCR_MENU_H
#define POLEPOSITIONCR_MENU_H

#endif //POLEPOSITIONCR_MENU_H

#include "../Client/Client.c"
#include <SFML/Graphics.h>


/***
 * Controla la interfaz del menu principal
 */
void menu();

/***
 * Valida que el carro elegido por el usuario no haya sido seleccionado por otro jugador. Si el carro está disponible y
 * los demás jugadores están listos, empieza el juego
 * @param main_window ventana de la aplicación
 * @param sprite sprite del el carro elegido por el jugador
 * @param pos posición del carro elegido por el jugador
 * @param player estuctura con lo datos recibidos del servidor
 * @param carro numero identificador del carro elegido por el jugador
 */
void validarCarro(sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos, struct Player* player, int carro);
