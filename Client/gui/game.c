
#include <stdbool.h>
#include <stdio.h>
#include "game.h"
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
    float bulletCooldown;
    int bulletY; // Eliminar
    int bulletX;  // Eliminar
//    sfSprite* bulletSprite;
//    sfVector2f bulletPos;
};



void game(sfRenderWindow* main_window, sfSprite* sprite, sfVector2f pos, struct Player *player) {


    struct Jugador* player1 = (struct Jugador*) malloc(sizeof (player1));
    player1->id = 0;
//    player1->pts = 0;
//    player1->vidas = 3;
    player1->movingX = false;
    player1->movingY = false;
    player1->velocity_X = 0.0f;
    player1->velocity_Y = 0.0f;
    player1->bulletCooldown = 5.0f;
    sfVector2f playerBulletPos = {-500,0};
//    player1->bulletX = -500;
//    player1->bulletY = 0;
//    player1->bulletPos = bulletVect;
    player1->global_Y=pos.y;

    int vidas = 3;
    int pts = 0;

    sfFont* font = sfFont_createFromFile("../Assets/Morphin Bold.ttf");

    // life title
    sfText* lifes_txt = sfText_create();
    sfText_setFont(lifes_txt, font);
    sfText_setString(lifes_txt, "VIDAS:");
    sfVector2f lifes_txt_pos = {850,40};
    sfText_setPosition(lifes_txt, lifes_txt_pos);

    // number of lifes
    sfText* nlifes_txt = sfText_create();
    sfText_setFont(nlifes_txt, font);
    char nlifes_txt_Str[20];
    itoa(vidas,nlifes_txt_Str,10);
    sfText_setString(nlifes_txt, nlifes_txt_Str);
    sfVector2f nlifes_txt_pos = {950,65};
    sfText_setPosition(nlifes_txt, nlifes_txt_pos);

    // Puntos title
    sfText* pts_txt = sfText_create();
    sfText_setFont(pts_txt, font);
    sfText_setString(pts_txt, "PTS:");
    sfVector2f pts_txt_pos = {850,130};
    sfText_setPosition(pts_txt, pts_txt_pos);

    // number of pts
    sfText* npts_txt = sfText_create();
    sfText_setFont(npts_txt, font);
    char npts_txt_Str[20];
    itoa(pts,npts_txt_Str,10);
    sfText_setString(npts_txt, npts_txt_Str);
    sfVector2f npts_txt_pos = {920,155};
    sfText_setPosition(npts_txt, npts_txt_pos);




//    Connect();



    //bullet
    const sfIntRect playerBullet_rect = {0,0, 22, 120};
    sfTexture* playerBullet_texture = sfTexture_createFromFile("../Assets/bullet1.png", &playerBullet_rect);
    sfSprite* playerBullet_Sprite = sfSprite_create();
    sfSprite_setTexture(playerBullet_Sprite, playerBullet_texture, sfTrue);
    sfSprite_setPosition(playerBullet_Sprite, playerBulletPos);


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

    // turbo
    const sfIntRect turboRect = {0,0, 100, 63};
    sfTexture* turboTexture = sfTexture_createFromFile("../Assets/turbo.png", &turboRect);
    sfSprite* turboSprite = sfSprite_create();
    sfSprite_setTexture(turboSprite, turboTexture, sfTrue);
    sfVector2f turboPos = {200,50};
    sfSprite_setPosition(turboSprite, turboPos);



    sfEvent event;
//    sfFloatRect_intersects()
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
                            playerBulletPos = pos;
//                            player1->bulletX = pos.x;
//                            player1->bulletY = pos.y;
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
                roadPos.y = road2Pos.y - 645.0f;
            }
                // reposiciona sprite 2 de la carretera
            else if (650.0f <= road2Pos.y){
                road2Pos.y = roadPos.y - 645.0f;
            }
        }
        if (0 <= player1->bulletCooldown){
            // controlar collision
            player1->bulletCooldown -= delta_time;
            playerBulletPos.y -= 500.0f * delta_time;
            sfSprite_setPosition(playerBullet_Sprite, playerBulletPos);
        }
        else if (player1->bulletCooldown <= 0){
            playerBulletPos.x = -500.0f;
        }
        sfRenderWindow_clear(main_window, sfBlack);
        sfSprite_setPosition(road, roadPos);
        sfSprite_setPosition(road2, road2Pos);
        sfSprite_setPosition(sprite, pos);

        sfRenderWindow_drawSprite(main_window, road, NULL);
        sfRenderWindow_drawSprite(main_window, road2, NULL);
        sfRenderWindow_drawSprite(main_window, playerBullet_Sprite, NULL);
        sfRenderWindow_drawSprite(main_window, sprite, NULL);
        sfRenderWindow_drawSprite(main_window, turboSprite, NULL);


        sfRenderWindow_drawText(main_window, lifes_txt, NULL);
        sfRenderWindow_drawText(main_window, nlifes_txt, NULL);
        sfRenderWindow_drawText(main_window, pts_txt, NULL);
        sfRenderWindow_drawText(main_window, npts_txt, NULL);

        sfRenderWindow_display(main_window);

//        sfSleep(sfMilliseconds(1));

    }
}

void game3 (sfRenderWindow *main_window, sfSprite *playerCar, sfVector2f *playerPos, struct Player *player) {

    struct Jugador* player1 = (struct Jugador*) malloc(sizeof (player1));
    player1->id = 0;
    player1->movingX = false;
    player1->movingY = false;
    player1->velocity_X = 0.0f;
    player1->velocity_Y = 0.0f;
    player1->bulletCooldown = 5;
//    sfVector2f bulletVect = {-500,0};
//    player1->bulletPos = bulletVect;

    float delta_time;
    sfClock* clock = sfClock_create();


    sfEvent event;

    while (sfRenderWindow_isOpen(main_window)){

        delta_time = sfTime_asSeconds(sfClock_restart(clock));

        while (sfRenderWindow_pollEvent(main_window, &event))
        {
            if (event.type == sfEvtClosed)
            {
                sfRenderWindow_close(main_window);
            }
            else if (event.type == sfEvtKeyPressed){
                switch (event.key.code) {
                    case sfKeyNum1:
                        printf("%d", 1);
                        break;
                }
            }

        }
        sfRenderWindow_clear(main_window, sfBlack);
        sfRenderWindow_display(main_window);
    }
}
