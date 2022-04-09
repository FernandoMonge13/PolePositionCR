#include <stdio.h>
#include "Client/Client.h"
#include <SDL.h>

int main(int argc, char *args[]) {
//    createJson();
    Connect();

    SDL_Window* window = SDL_CreateWindow("Ventana", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, 840, 650, SDL_WINDOW_SHOWN);
    SDL_Renderer* renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED | SDL_RENDERER_PRESENTVSYNC);
    SDL_Surface* background = SDL_LoadBMP("../Assets/ROAD.bmp");
    SDL_Texture* texture = SDL_CreateTextureFromSurface(renderer,background);
    SDL_FreeSurface(background);
    SDL_Rect* rect;
    rect->x = 0;
    rect->y = 0;
    rect->h = 650;
    rect->w = 840;
    bool running = true;

    SDL_Event event;

    while (running){
        SDL_SetRenderDrawColor(renderer, 0,0,0, SDL_ALPHA_OPAQUE);
        SDL_RenderClear(renderer);
        SDL_RenderCopy(renderer, texture, rect, NULL);
        SDL_RenderPresent(renderer);
        SDL_PollEvent(&event);
        switch (event.type) {
            case SDL_QUIT:
                running = false;
                break;
        }
        SDL_Delay(50);
    }
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();
    return 0;
}
