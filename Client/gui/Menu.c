//
// Created by caman on 9/4/2022.
//

#include "Menu.h"
#include "game.c"


// Hay que descomentar linea 60 y 121 para que funcione la conexion


void menu() {

    sfVideoMode mode = {1000, 650, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);
    sfRenderWindow_setFramerateLimit(main_window, 60);
    // redCar
    const sfIntRect redCarRect = {0,0, 61, 119};
    sfTexture* redCarTexture = sfTexture_createFromFile("../Assets/chuzoCE.png", &redCarRect);
    sfSprite* redCarSprite = sfSprite_create();
    sfSprite_setTexture(redCarSprite, redCarTexture, sfTrue);
    sfVector2f redCarPos = {150,400};

    // blueCar
    const sfIntRect blueCarRect = {0,0, 79, 194};
    sfTexture* blueCarTexture = sfTexture_createFromFile("../Assets/PepsiTankIns.png", &blueCarRect);
    sfSprite* blueCarSprite = sfSprite_create();
    sfSprite_setTexture(blueCarSprite, blueCarTexture, sfTrue);
    sfVector2f blueCarPos = {250,400};

    // purpleCar
    const sfIntRect purpleCarRect = {0,0, 61, 119};
    sfTexture* purpleCarTexture = sfTexture_createFromFile("../Assets/SapriCarIns.png", &purpleCarRect);
    sfSprite* purpleCarSprite = sfSprite_create();
    sfSprite_setTexture(purpleCarSprite, purpleCarTexture, sfTrue);
    sfVector2f purpleCarPos = {400,400};

    // whiteCar
    const sfIntRect whiteCarRect = {0,0, 61, 119};
    sfTexture* whiteCarTexture = sfTexture_createFromFile("../Assets/whiteCar.png", &whiteCarRect);
    sfSprite* whiteCarSprite = sfSprite_create();
    sfSprite_setTexture(whiteCarSprite, whiteCarTexture, sfTrue);
    sfVector2f whiteCarPos = {500,400};

    struct Player* playerClient = (struct Player*) malloc(sizeof (playerClient));

    playerClient->id = 0;
    playerClient->puntos = 0;
    playerClient->vidas = 3;
    playerClient->posX = 0;
    playerClient->posY = 0;
    playerClient->posBalaX = -300;
    playerClient->posBalaY = 0;
    playerClient->carro = 0;
    playerClient->running = false;
    playerClient->conected = false;
    playerClient->carSelect = false;

    *playerClient = Connect(playerClient);


    sfEvent event;

    while (sfRenderWindow_isOpen(main_window))
    {
        while (sfRenderWindow_pollEvent(main_window, &event))
        {
            if (event.type == sfEvtClosed)
            {
                sfRenderWindow_close(main_window);
            }
            else if (event.type == sfEvtKeyPressed){
                switch (event.key.code) {
                    case sfKeyNum1:
                        if (!playerClient->carSelect){
                            validarCarro(main_window, redCarSprite, redCarPos, playerClient, 1);
                        }
                        break;
                    case sfKeyNum2:
                        if (!playerClient->carSelect){
                            validarCarro(main_window, blueCarSprite, blueCarPos, playerClient, 2);
                        }
                        break;
                    case sfKeyNum3:
                        if (!playerClient->carSelect){
                            validarCarro(main_window, purpleCarSprite, purpleCarPos, playerClient, 3);
                        }
                        break;
                    case sfKeyNum4:
                        if (!playerClient->carSelect){
                            validarCarro(main_window, whiteCarSprite, whiteCarPos, playerClient, 4);
                        }
                        break;
                }
            }
        }

        sfSprite_setPosition(redCarSprite, redCarPos);
        sfSprite_setPosition(blueCarSprite, blueCarPos);
        sfSprite_setPosition(purpleCarSprite, purpleCarPos);
        sfSprite_setPosition(whiteCarSprite, whiteCarPos);

        sfRenderWindow_clear(main_window, sfBlack);

        sfRenderWindow_drawSprite(main_window, redCarSprite, NULL);
        sfRenderWindow_drawSprite(main_window, blueCarSprite, NULL);
        sfRenderWindow_drawSprite(main_window, purpleCarSprite, NULL);
        sfRenderWindow_drawSprite(main_window, whiteCarSprite, NULL);

        sfRenderWindow_display(main_window);
//        printf("%d", delta)
//        sfSleep(sfMilliseconds(1));


    }

}

void validarCarro(sfRenderWindow *main_window, sfSprite *sprite, sfVector2f pos, struct Player *player, int carro) {

    player->carro = carro;
    *player = Connect(player);
    printf("%s  \n", "rcvMSG");
    printf("%d \n", player->carro);
    printf("%d \n", carro);
    if (player->carro == carro){
        player->carSelect = true;
        while (!player->running){
            sfSleep(sfSeconds(1));
            *player = Connect(player);
        }
        game(main_window, sprite, pos, player);
    }
//    game(main_window, sprite, pos, player);

}
/*
void game2() {

    sfVideoMode mode = {940, 650, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);
    sfRenderWindow_setFramerateLimit(main_window, 60);

    const sfIntRect redCarRect = {0,0, 61, 119};
    sfTexture* redCarTexture = sfTexture_createFromFile("../Assets/chuzoCE.png", &redCarRect);
    sfSprite* redCarSprite = sfSprite_create();
    sfSprite_setTexture(redCarSprite, redCarTexture, sfTrue);
    sfVector2f redCarPos = {150,400};


    struct Jugador* player1 = (struct Jugador*) malloc(sizeof (player1));
    player1->id = 0;
    player1->movingX = false;
    player1->movingY = false;
    player1->velocity_X = 0.0f;
    player1->velocity_Y = 0.0f;
    player1->bulletCooldown = 5;
    sfVector2f bulletVect = {-500,0};
    player1->bulletPos = bulletVect;
    player1->global_Y=redCarPos.y;

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
                            player1->bulletPos = redCarPos;
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
            if (640.0f <= redCarPos.x){
                if ( player1->velocity_X < 0.0f){
                    redCarPos.x +=  player1->velocity_X * delta_time;
                }
            }
            else if (redCarPos.x <= 146){
                if (0.0f <  player1->velocity_X){
                    redCarPos.x +=  player1->velocity_X * delta_time;
                }
            }
            else {redCarPos.x +=  player1->velocity_X * delta_time;}
        }
        if(0 < player1->velocity_Y){
//            pos.y += velocity_Y * delta_time; // posicion de otro carro
            roadPos.y +=  player1->velocity_Y * delta_time;
            road2Pos.y +=  player1->velocity_Y * delta_time;
            player1->global_Y += player1->velocity_Y * delta_time;
            // reposiciona sprite 1 de carretera
            if (650.0f <= roadPos.y){
                roadPos.y = -645.0f;
            }
                // reposiciona sprite 2 de la carretera
            else if (650.0f <= road2Pos.y){
                road2Pos.y = -645.0f;
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
        sfSprite_setPosition(redCarSprite, redCarPos);
        sfRenderWindow_drawSprite(main_window, road, NULL);
        sfRenderWindow_drawSprite(main_window, road2, NULL);
        sfRenderWindow_drawSprite(main_window, player1->bulletSprite, NULL);
        sfRenderWindow_drawSprite(main_window, redCarSprite, NULL);
//        sfRenderWindow_setView(main_window, view);
        sfRenderWindow_display(main_window);

//        sfSleep(sfMilliseconds(1));

    }
}
*/
