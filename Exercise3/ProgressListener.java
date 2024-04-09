package Exercise3;

public class ProgressListener {

    Downloader dload;
    ProgressListener listener = new ProgressListener(dload)

    public ProgressListener(Downloader dloader) {
        this.dload = dloader

    }

    // to deadlock, try to get lock here

    public void onProgress(int total) {
        dload.addListener(listener);

    }
    
}
