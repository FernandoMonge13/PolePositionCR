cmake_minimum_required(VERSION 3.19)
project(Client C)

set(CMAKE_C_STANDARD 99)
link_libraries(ws2_32 wsock32)

add_executable(Client main.c Client/Client.c Client/Client.h)