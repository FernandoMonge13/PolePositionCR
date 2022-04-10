#include <SFML/Graphics.h>
#include <stdbool.h>
#include <stdio.h>
#include "malloc.h"
//#include "../Client/Client.c"

struct sms{
    int id;
    int vidas;
    int puntos;
    int car_posX;
    int car_posY;
    int bala_posX;
    int bala_posY;
};



struct Jugador{
    int id;
    bool movingX;
    bool movingY;
    int global_Y;
    float velocity_X;
    float velocity_Y;
    int bulletCooldown;
    sfSprite* bulletSprite;
    sfVector2f bulletPos;
};

// Coordenadas jugar 1,2,3,4 . x y = 2 * 4 variables
// Coordenadas x y de disparos y jugador que disparó. Debería bastar trasmitir 4 por ciclo 3*4
//

int game (sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos) {

//    Connect();

    struct Jugador* player1 = (struct Jugador*) malloc(sizeof (player1));
    player1->id = 0;
    player1->movingX = false;
    player1->movingY = false;
    player1->velocity_X = 0.0f;
    player1->velocity_Y = 0.0f;
    player1->bulletCooldown = 5;
    sfVector2f bulletVect = {-500,0};
    player1->bulletPos = bulletVect;
    player1->global_Y=pos.y;

    const sfIntRect playerBullet_rect = {0,0, 22, 120};
    sfTexture* playerBullet_texture = sfTexture_createFromFile("../Assets/bullet1.png", &playerBullet_rect);
    sfSprite* playerBullet_Sprite = sfSprite_create();
    sfSprite_setTexture(playerBullet_Sprite, playerBullet_texture, sfTrue);
    player1->bulletSprite = playerBullet_Sprite;

    // Road
    const sfIntRect rect2 = {0,0, 840, 650};
    sfTexture* road_texture = sfTexture_createFromFile("../Assets/road.png", &rect2);
    sfSprite* road = sfSprite_create();
    sfSprite_setTexture(road, road_texture, sfTrue);
    sfVector2f roadPos = {0,0};

    // Road 2
    sfSprite* road2 = sfSprite_create();
    sfSprite_setTexture(road2, road_texture, sfTrue);
    sfVector2f road2Pos = {0,-648};

//    sfView* view = sfView_createFromRect(rect2);

    sfEvent event;

//    float total_time = 0.0f;
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
                        if (player1->velocity_Y < 300.0f){
                            player1->velocity_Y+= 75.0f;
//                            player1->velocity_Y = 300.0f;
                        }
                        break;
                    case sfKeyDown:
                        if (0 < player1->velocity_Y)
                            player1->velocity_Y -= 25.0f;
                        break;
                    case sfKeyEnter:
                        if (player1->bulletCooldown <= 0){
                            player1->bulletCooldown = 5;
                            player1->bulletPos = pos;
//                            printf(&player1->bulletCooldown);
                        }
                        break;
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
        if(0 < player1->velocity_Y){
//            pos.y += velocity_Y * delta_time; // posicion de otro carro
            roadPos.y +=  player1->velocity_Y * delta_time;
            road2Pos.y +=  player1->velocity_Y * delta_time;
            player1->global_Y += player1->velocity_Y * delta_time;
            // reposiciona sprite 1 de carretera
            if (650.0f <= roadPos.y){
                roadPos.y = -648.0f;
            }
            // reposiciona sprite 2 de la carretera
            else if (650.0f <= road2Pos.y){
                road2Pos.y = -648.0f;
            }
        }
        if (0 <= player1->bulletCooldown){
            // controlar collision
            player1->bulletCooldown -= delta_time;
            player1->bulletPos.y -= 500.0f * delta_time;
            sfSprite_setPosition(player1->bulletSprite, player1->bulletPos);
        }
        else if (player1->bulletCooldown <= 0){
            player1->bulletPos.x = -500.0f;
        }
        sfRenderWindow_clear(main_window, sfBlack);
        sfSprite_setPosition(road, roadPos);
        sfSprite_setPosition(road2, road2Pos);
        sfSprite_setPosition(sprite, pos);
        sfRenderWindow_drawSprite(main_window, road, NULL);
        sfRenderWindow_drawSprite(main_window, road2, NULL);
        sfRenderWindow_drawSprite(main_window, player1->bulletSprite, NULL);
        sfRenderWindow_drawSprite(main_window, sprite, NULL);
//        sfRenderWindow_setView(main_window, view);
        sfRenderWindow_display(main_window);

    }
    return 0;
};