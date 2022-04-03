#include <SFML/Graphics.h>

int main()
{
    sfVideoMode mode = {200, 200, 32};
    sfRenderWindow* main_window = sfRenderWindow_create(mode, "CSFML works",sfDefaultStyle, NULL);

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
        
    }
    
    return 0;
}