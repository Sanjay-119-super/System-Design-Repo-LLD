package google_Docs_project;/*
package google_Docs_project;

import java.util.ArrayList;
import java.util.List;

class DocumentEditor{
    private List<String> documentElements;

    public DocumentEditor(){
        this.documentElements=new ArrayList<>();
    }

    public void addText(String text){
        documentElements.add("Text: " + text);
    }

    public void addImage(String imgPath){
        documentElements.add("Image: " + imgPath);
    }

    public void renderDocument(){
        System.out.println("Document rendering:  ");
        for (String ren: documentElements){
            System.out.println(ren);
        }
    }
    public void saveToDb(){
        System.out.println("Saving document..");
        for (String save: documentElements){
            System.out.println("Save: " + save);
        }
    }

}


public class Test {
    public static void main(String[] args) {

        DocumentEditor editor = new DocumentEditor();
        editor.addText("Demo....");
        editor.addImage("image.jpg");
        editor.renderDocument();
        editor.saveToDb();
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class DocumentEditor {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor() {
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }

    // Adds text as a plain string
    public void addText(String text) {
        documentElements.add(text);
    }

    // Adds an image represented by its file path
    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    // Renders the document by checking the type of each element at runtime
    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : documentElements) {
                if (element.length() > 4 &&
                        (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

public class DocumentEditorClient {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, world!");
        editor.addImage("picture.jpg");
        editor.addText("This is a document editor.");

        System.out.println(editor.renderDocument());

        editor.saveToFile();
    }
}
