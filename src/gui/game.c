#include <SFML/Graphics.h>


int game () {

    sfVideoMode mode = {1000, 700, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);


    sfFloatRect rect = {0,0, 61, 119};
    sfTexture* player_texture = sfTexture_createFromFile("../Assets/chuzoCE.png", &rect);
    sfSprite* sprite = sfSprite_create();
    sfSprite_setTexture(sprite, player_texture, sfTrue);
    sfVector2f pos = {500,300};

    sfEvent event;

    while (sfRenderWindow_isOpen(main_window))
    {
        while (sfRenderWindow_pollEvent(main_window, &event))
        {
            if (event.type == sfEvtClosed)
            {
                sfRenderWindow_close(main_window);
            }

        }
        sfRenderWindow_clear(main_window, sfBlack);
        sfSprite_setPosition(sprite, pos);
        sfRenderWindow_drawSprite(main_window, sprite, NULL);
        sfRenderWindow_display(main_window);

    }
    return 0;
};