package Servidor;

import java.io.DataInputStream;
import java.io.OutputStream;

public class ServerThread extends Thread {

    private DataInputStream in;
    private OutputStream out;
    private String nombreCliente;

    public ServerThread(DataInputStream in, OutputStream out, String nombreCliente) {
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {

    }
}
