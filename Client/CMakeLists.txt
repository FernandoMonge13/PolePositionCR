cmake_minimum_required(VERSION 3.19)
project(Client C)

set(CMAKE_C_STANDARD 99)
set(SDL2_INCLUDE_DIR SDL2-2.0.20/include)
set(SLD2_LIBRARY_DIR SDL2-2.0.20/lib/x64)
include_directories(${SDL2_INCLUDE_DIR})
LINK_DIRECTORIES(${SLD2_LIBRARY_DIR})

link_libraries(ws2_32 wsock32)

add_executable(Client main.c Client/Client.c Client/Client.h Json/cJSON.c Json/cJSON.h)
TARGET_LINK_LIBRARIES(${PROJECT_NAME} SDL2main SDL2)