//


package Exercise3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Downloader {

    private final InputStream in;
    private final OutputStream out;
    private final List<ProgressListener> listeners;


    public Downloader(URL url, String outputFilename) throws IOException {
    in = url.openConnection().getInputStream();
    out = new FileOutputStream(outputFilename);
    listeners = new ArrayList<>();
    }


    public synchronized void addListener(ProgressListener listener) {
    listeners.add(listener);
    }


    private synchronized void updateProgress(int total) {
    for (ProgressListener listener : listeners)
    listener.onProgress(total);
    }

    public void run() throws IOException {
        int n = 0, total = n;
        byte buffer[] = new byte[1024];
        
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
            total += n;
            updateProgress(total);
        }
        out.flush();
        }

    public static void main(String[] args) {
        
    }
}