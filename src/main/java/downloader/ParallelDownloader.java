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
        int numWorkers = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numWorkers);

        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (String u: urls) {
                    Callable<String> task = () ->{
                        try{
                            return saveUrl2File(u);
                        }catch(Exception e){
                            return "error";
                        }
                    };

                }


                return null;
            }
        });

        pool.shutdown();


        /*
        List<Callable<String>> callables = new ArrayList<>();

        for (String u: urls) {
            Callable<String> task = () ->{
                try{
                    return saveUrl2File(u);
                }catch(Exception e){
                    return "error";
                }
            };
            callables.add(task);
        }

         */

        return 0;
    }
}
