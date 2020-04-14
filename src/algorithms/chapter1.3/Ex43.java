import java.io.File;

import edu.princeton.cs.algs4.StdIn;

public class Ex43 {
    public void print(File file, int count, Queue queue)
    {
        File[] files = file.listFiles();
        String[] sfiles = file.list();
        for (int i = 0; i < files.length; i++)
        {
            String s = "";
            for(int j = 0; j < count; j++)
                s += "   ";
            if (files[i].isDirectory())
            {
                queue.enqueue(s + sfiles[i]);
                print(files[i], count + 1, queue);
            }
            else
                queue.enqueue(s + sfiles[i]);
        }
 
    }
	
	public static void main(String[] args) {
		String name = "C:\\Users\\cxwld\\Documents\\JAVA_exp\\Chapter_1_3"; //StdIn.readString();
		File path = new File(name);
		
		String[] fs = path.list();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i]);
			//System.out.println(fs[i].isFile());
		}
	}
}
