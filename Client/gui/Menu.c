//
// Created by caman on 9/4/2022.
//

#include <SFML/Graphics.h>
#include "Menu.h"
#include "game.c"
#include "../Client/Client.c"

void menu() {

    sfVideoMode mode = {840, 650, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);

    Connect();

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
                        game(main_window, redCarSprite, redCarPos);
                        break;
                    case sfKeyNum2:
                        game(main_window, blueCarSprite, blueCarPos);
                        break;
                    case sfKeyNum3:
                        game(main_window, purpleCarSprite, purpleCarPos);
                        break;
                    case sfKeyNum4:
                        game(main_window, whiteCarSprite, whiteCarPos);
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



    }

}
