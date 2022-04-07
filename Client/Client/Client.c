//
// Created by Fernando on 04/04/22.
//


#include "Client.h"

bool Connect(){
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

        return false; }

    printf("Client connected \n");

    if((sSocket = socket(AF_INET , SOCK_STREAM , 0 )) == INVALID_SOCKET) {
        printf("!!: Could not create the socket  : %d", WSAGetLastError());
        return false;}

    for (int (i) = 0; i < 4; ++(i)) {
        connect(sSocket, (struct sockaddr*) &client, sizeof(client));
    }


    send(sSocket, abc, sizeof(abc),0);

    recv(sSocket, buffer, sizeof(buffer), 0);
    printf("Recibio: %s", buffer);




}
