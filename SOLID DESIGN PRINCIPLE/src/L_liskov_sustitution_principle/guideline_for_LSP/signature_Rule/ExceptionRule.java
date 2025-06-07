package L_liskov_sustitution_principle.guideline_for_LSP.signature_Rule;

import java.io.IOException;

class FileProcessor{
    public void processFile() throws IOException{
        System.out.println("File processing in Parant class");
    }
}

class SecureFileProcessor extends FileProcessor{
    @Override
    public void processFile() throws IOException {
        System.out.println("File process in Child class");
    }
}

class ClientProcess{
    private FileProcessor processor;
    public ClientProcess(FileProcessor processor){
        this.processor = processor;
    }
    public void checkProcess(){
        try {
            processor.processFile();
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

public class ExceptionRule {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        SecureFileProcessor processor1 = new SecureFileProcessor();

        ClientProcess process = new ClientProcess(processor);
        process.checkProcess();

        ClientProcess process1 = new ClientProcess(processor1);
        process1.checkProcess();
    }
}
