package sr.app;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

	public static void main(String[] args) {

		
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "Z"};
        File[] drives = new File[letters.length];
        boolean[] isDrive = new boolean[letters.length];
    	File destFolder = new File("d:\\Robber");
    	ExecutorService executor=Executors.newCachedThreadPool();

        for ( int i = 0; i < letters.length; ++i ){
            
        	drives[i] = new File(letters[i]+":\\");
            isDrive[i] = drives[i].exists();
        }
        
        
        
		
        while(true){
        	
        	for(int i=0;i<drives.length;i++){
        		
        		boolean status=drives[i].exists();
        		if(isDrive[i]!=status){
        			
        			if(status){
        				System.out.println(letters[i]+" is plugedin");
        		    	executor.execute(new MultiCopier(drives[i], destFolder));
   
        			}
        			else
        				System.out.println(letters[i]+" is unpluged");

            		isDrive[i]=status;
        		}
        		
        		isDrive[i]=status;
        		
        	}
        	
        	try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }

	}

}
