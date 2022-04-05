package Cliente;

import java.io.DataInputStream;
import java.io.OutputStream;

public class ClientThread extends Thread {

    private DataInputStream in;
    private OutputStream out;

    public ClientThread(DataInputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

    }
}
