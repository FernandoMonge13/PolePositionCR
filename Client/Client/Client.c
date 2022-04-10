//
// Created by Fernando on 04/04/22.
//


#include "Client.h"


//bool conected = true;
//bool running = false;
//bool carSelect = false;
char newPlayer[100] = "{nuevo Jugador}";
char start[100] = "{Iniciar}";
char newString[100];

char* sendInfo;

struct Data{

};



struct Player Connect(struct Player* player){

//    struct Player* player = (struct Player*) malloc(sizeof(struct Player));
//    player->id = 1;
//    player->puntos = 0;
//    player->vidas = 3;
//    player->posX = 0;
//    player->posY = 0;
//    player->posBalaX = 0;
//    player->posBalaY = 0;
//    player->carro = 2;
//    player->running = false;


    WSADATA wsa;
    SOCKET sSocket;
    struct sockaddr_in client;
    client.sin_family = AF_INET;
    client.sin_addr.s_addr = inet_addr("127.0.0.1");
    client.sin_port = htons(5000);
    char buffer[6000];
    char abc [100] = "buenosdias}";

    if (WSAStartup(MAKEWORD(2,2),&wsa) != 0){
        printf("Failed. Error Code : %d",WSAGetLastError());

//        return false;
    }

    printf("Client connected \n");

    if((sSocket = socket(AF_INET , SOCK_STREAM , 0 )) == INVALID_SOCKET) {
        printf("!!: Could not create the socket  : %d", WSAGetLastError());
//        return false;
    }

    for (int (i) = 0; i < 4; ++(i)) {
        connect(sSocket, (struct sockaddr*) &client, sizeof(client));
    }

    if (!player->conected && !player->running && !player->carSelect) {
        char datos[100] = "{nuevo Jugador}";
        datos[15] = player->id;
        datos[16] = '\0';

        send(sSocket, datos, sizeof(datos),0);
        recv(sSocket, buffer, sizeof(buffer), 0);

        player->id=buffer[0];

        // Aqui se le empuja el valor que se ocupa
        printf("Recibio: %c", buffer[0]);

        memset(buffer, 0, sizeof(buffer));

        player->conected = true;

    } else if(player->conected && !player->running && !player->carSelect){
        //Enviar id y numero de carro
        char valor = player->id + '0';

        printf("\n");
        printf("%c",valor);
        printf("\n");

        char datos[100] = "PeticionCarro {i,c}";
        datos[15] = valor;
        valor = player->carro + '0';
        datos[17] = valor;

        send(sSocket, datos, sizeof(datos), 0);
        memset(buffer, 0, sizeof(buffer));
        recv(sSocket, buffer, sizeof(buffer), 0);
        player->carro = buffer[0];
        printf("Recibio: %c", buffer[0]);

        if (buffer[0] != 0) {
            player->carSelect = true;
            player->carro = (int) buffer[0];
            player->carro -= 48;
        }
    }
    else if (player->conected && player->carSelect && !player->running){
        char datos[100] = "{Iniciar,i}";
         datos[8] = player->id;

        send(sSocket, datos, sizeof(datos),0);
        player->carSelect = true;
        recv(sSocket, buffer, sizeof(buffer), 0);

//        printf("Recibio: %s", buffer[0]);
        int aux = (int)buffer[0]-48;
        if (aux == 1) {
//            memset(buffer, 0, sizeof(buffer));
            player->running = true;
        }


    } else if (player->conected && player->carSelect && player->running){
        createJson();
        send(sSocket, newString, sizeof(newString),0);
//        memset(buffer, 0, sizeof(buffer));
        recv(sSocket, buffer, sizeof(buffer), 0);
        printf("\nRecibio: %s", buffer);
//        readJson(buffer);

    }



//    send(sSocket, abc, sizeof(abc),0);
//
//    recv(sSocket, buffer, sizeof(buffer), 0);

//    readJson(buffer);
    //printf("Recibio: %s", buffer);
    return *player;
}

void createJson(){
    cJSON* taste = NULL;

    cJSON *information = cJSON_CreateObject();

//    cJSON_AddStringToObject(information,"id","0");
//    cJSON_AddStringToObject(information, "puntos","0");
//    cJSON_AddStringToObject(information, "vidas","3");
//    cJSON_AddStringToObject(information, "posX","1");
//    cJSON_AddStringToObject(information, "posY","1");



    //taste = cJSON_GetObjectItem(information, "name =")

    sendInfo="{\"id\":\"2\",\"puntos\":\"100\",\"vidas\":\"3\",\"posX\":\"1\",\"posY\":\"1\"}";

//    sendInfo = cJSON_Print(information);
//
    for (int i = 0; i < strlen(sendInfo); ++i) {
        newString[i] = sendInfo[i];

    }



    printf("%s", newString);





}

void readJson(char *info){

    printf("%s", info);

    cJSON* allInfo;
    cJSON* players;
    cJSON* data;


    cJSON* taste;
    char name;

//    Todo_lo que tenga info adentro
    taste = cJSON_Parse(info);


//    Jala un unico elemento del json y en este caso
//    se lo mete a un string pero puede se a uno tipo cJSON

    players = cJSON_GetObjectItem(taste, "players");
    data = cJSON_GetObjectItem(players, "id");

    name = cJSON_Print(data);
    printf("%s", name);

}

