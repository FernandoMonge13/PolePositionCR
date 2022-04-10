#include <SFML/Graphics.h>
#include "../Client/Client.h"
#include <stdbool.h>
#include <stdio.h>
#include "malloc.h"
#include "../Client/Client.c"

struct sms{
    int id;
    int vidas;
    int puntos;
    float car_posX;
    float car_posY;
    float bala_posX;
    float bala_posY;
};


struct player{
    int id;
    bool movingX;
    bool movingY;
    float velocity_X;
    float velocity_Y;
};
// Coordenadas jugar 1,2,3,4 . x y = 2 * 4 variables
// Coordenadas x y de disparos y jugador que disparó. Debería bastar trasmitir 4 por ciclo 3*4
//

int game () {

    Connect();

    struct player* player1 = (struct player*) malloc(sizeof (player1));
    player1->id = 0;
    player1->movingX = false;
    player1->movingY = false;
    player1->velocity_X = 0.0f;
    player1->velocity_Y = 0.0f;

    sfVideoMode mode = {840, 650, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);

    // Car
    sfFloatRect rect = {0,0, 61, 119};
    sfTexture* player_texture = sfTexture_createFromFile("../Assets/chuzoCE.png", &rect);
    sfSprite* sprite = sfSprite_create();
    sfSprite_setTexture(sprite, player_texture, sfTrue);
    sfVector2f pos = {500,400};

    // Road
    sfFloatRect rect2 = {0,0, 840, 650};
    sfTexture* road_texture = sfTexture_createFromFile("../Assets/road.png", &rect);
    sfSprite* road = sfSprite_create();
    sfSprite_setTexture(road, road_texture, sfTrue);
    sfVector2f roadPos = {0,0};

    // Road 2
    sfSprite* road2 = sfSprite_create();
    sfSprite_setTexture(road2, road_texture, sfTrue);
    sfVector2f road2Pos = {0,-650};

    sfView* view = sfView_createFromRect(rect2);

    sfEvent event;

    float total_time = 0.0f;
    float delta_time;
    sfClock* clock = sfClock_create();

    while (sfRenderWindow_isOpen(main_window))
    {
        delta_time = sfTime_asSeconds(sfClock_restart(clock));
        while (sfRenderWindow_pollEvent(main_window, &event))
        {
            if (event.type == sfEvtClosed)
            {
                sfRenderWindow_close(main_window);
            }
            else if (event.type == sfEvtKeyPressed){
                switch (event.key.code) {
                    case sfKeyLeft:
                        player1->movingX = true;
                        player1->velocity_X = -300.0f;
                        break;
                    case sfKeyRight:
                        player1->movingX = true;
                        player1->velocity_X = 300.0f;
                        break;
                    case sfKeyUp:
                        player1->movingY = true;
                        player1->velocity_Y = 300.0f;
                }
            }
            else if (event.type == sfEvtKeyReleased){
                switch (event.key.code) {
                    case sfKeyLeft:
                        player1->movingX = false;
                        player1->velocity_X = 0.0f;
                        break;
                    case sfKeyRight:
                        player1->movingX = false;
                        player1->velocity_X = 0.0f;
                        break;
                    case sfKeyUp:
                        player1->movingY = false;
                        player1->velocity_Y = 0.0f;
                        break;
                }

            }

        }

        // impide traspasar los bordes de la carretera
        if ( player1->movingX){
            if (640.0f <= pos.x){
                if ( player1->velocity_X < 0.0f){
                    pos.x +=  player1->velocity_X * delta_time;
                }
            }
            else if (pos.x <= 146){
                if (0.0f <  player1->velocity_X){
                    pos.x +=  player1->velocity_X * delta_time;
                }
            }
            else {pos.x +=  player1->velocity_X * delta_time;}
        }
        if( player1->movingY){
//            pos.y += velocity_Y * delta_time; // posicion de otro carro
            roadPos.y +=  player1->velocity_Y * delta_time;
            road2Pos.y +=  player1->velocity_Y * delta_time;
            // reposiciona sprite 1 de carretera
            if (650.0f <= roadPos.y){
                roadPos.y = -650.0f;
            }
            // reposiciona sprite 2 de la carretera
            else if (650.0f <= road2Pos.y){
                road2Pos.y = -650.0f;
            }
        }
        sfRenderWindow_clear(main_window, sfBlack);
//        sfView_zoom(view, 0.1f);
        sfSprite_setPosition(road, roadPos);
        sfSprite_setPosition(road2, road2Pos);
        sfSprite_setPosition(sprite, pos);
        sfRenderWindow_drawSprite(main_window, road, NULL);
        sfRenderWindow_drawSprite(main_window, road2, NULL);
        sfRenderWindow_drawSprite(main_window, sprite, NULL);
        sfRenderWindow_setView(main_window, view);
        sfRenderWindow_display(main_window);

    }
    return 0;
};