package sr.app;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;


public class DirCopier {
	
	
	public static void copyFolder(File src, File dest) throws IOException{
		
		
		if(src.isDirectory()){
			 

    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
 
    		
    		String files[] = src.list();
 
    		for (String file : files) {
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   copyFolder(srcFile,destFile);
    		}
 
    	}else{
    		Path srcPath=src.toPath();
    		Path destPath=dest.toPath();
    		if(!dest.exists() && src.exists())
    			try{
    			Files.copy(srcPath, destPath,REPLACE_EXISTING);
    			}catch (Exception e) {
					// TODO: handle exception
				}
    	}
	}
		

}
