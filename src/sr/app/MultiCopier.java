package sr.app;

import java.io.File;
import java.io.IOException;

public class MultiCopier implements Runnable{
	
	File srcFile,destFile;
	
	public MultiCopier(File s, File d) {
		this.srcFile=s;
		this.destFile=d;
		
	}

	@Override
	public void run() {
		
		
            try{
            	DirCopier.copyFolder(srcFile,destFile);
            }catch(IOException e){
            	e.printStackTrace();
            }
         
	}


	

}
