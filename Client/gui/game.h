//
// Created by caman on 11/4/2022.
//

#ifndef CLIENT_GAME_H
#define CLIENT_GAME_H

#endif //CLIENT_GAME_H

#include <SFML/Graphics.h>

void game (sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos, struct Player *player);


// Rehaciendo game
void game3 (sfRenderWindow* main_window, sfSprite* playerCar, sfVector2f* playerPos, struct Player *player);