package downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class ParallelDownloader extends Downloader{

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int numberOfDownloads = 0;

        /**
         * Create the Thread Pool
         */

        //Returns the number of processors available to the Java virtual machine
        int threadCount = Runtime.getRuntime().availableProcessors();
        // Creates a thread pool that reuses a fixed number of threads
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);

        List<Callable<String>> callables = new ArrayList<>();

        for (String url: urls) {
            Callable<String> download = () -> saveUrl2File(url);
            callables.add(download);
        }

        try{
            List<Future<String>> allFutureDownloads = threadPool.invokeAll(callables);
            for (Future<String> future: allFutureDownloads) {
                if (future.get() != null){
                    numberOfDownloads++;
                }
            }
        }
        catch (InterruptedException | ExecutionException exception){
            System.out.println(exception.getMessage());
        }

        threadPool.shutdown(); // stop accepting new tasks and finish all ongoing executions
        return numberOfDownloads;
    }
}
