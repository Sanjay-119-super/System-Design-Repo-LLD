package google_Docs_project;

import com.sun.org.apache.bcel.internal.generic.DCMPG;

import javax.print.Doc;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    String render();
}

// class-1 for add text element
class TextElement implements DocumentElement{
    private String text;

    public TextElement(String text){
        this.text=text;
    }
    @Override
    public String render() {
        return text;
    }
}

//Class-2 Image add
class ImageElement implements DocumentElement{
    private String imgPath;

    public ImageElement(String imgPath){
        this.imgPath=imgPath;
    }

    @Override
    public String render() {
        return "[image: " + imgPath +"]";
    }
}

// class-3 add new line
class AddNewLine implements DocumentElement{
    @Override
    public String render() {
        return "\n";
    }
}

//class-4 add tab
class AddTab implements DocumentElement{
    @Override
    public String render() {
        return "\t";
    }
}

//document class Has -a
class Document{
    List<DocumentElement> elements=new ArrayList<>();

    public void addDocumentElements(DocumentElement element){
        elements.add(element);
    }

    // render all element
    public String render(){
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : elements){
            result.append(element.render());
        }
        return result.toString();
    }
}

// for db
interface Persistence{
    void save(String data);
}

// class-1 for save to file
class SaveToFile implements Persistence{
    @Override
    public void save(String data) {
        try {
            FileWriter outWrite = new FileWriter("document1.txt");
            outWrite.write(data);
            outWrite.close();
            System.out.println("Save data successfully");
        }catch (IOException e){
            System.out.println("Error: "  +e.getMessage());

        }
    }
}

// class-2 save to database
class SaveToDB implements Persistence{
    @Override
    public void save(String data) {
        //db logic
    }
}

// todo Document editor class
class DocumentEditorr {
   private Document document;
   private Persistence persistence;
   private String renderDocumner ="";

    public DocumentEditorr(Document document, Persistence persistence) {
        this.document = document;
        this.persistence = persistence;

    }

    // add text
    public void addText(String text){
        document.addDocumentElements(new TextElement(text));
    }
    //add image
    public void addImage(String path){
        document.addDocumentElements(new ImageElement(path));
    }
    //add new line
    public void addNewLine(){
        document.addDocumentElements(new AddNewLine());
    }
    //add tab space
    public void addTabSpace(){
        document.addDocumentElements(new AddTab());
    }
    //render document
    public String  renderDocs(){
        if (renderDocumner.isEmpty()){
           renderDocumner= document.render();
        }
        return renderDocumner;
    }
    public void saveDocument(){
        persistence.save(renderDocumner);
    }
}


//client
 class BetterDesignDocumentEditor {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new SaveToFile();

        DocumentEditorr editorr = new DocumentEditorr(document,persistence);

        editorr.addText("Hello Dunia");
        editorr.addNewLine();
        editorr.addImage("pic.jpg");
        editorr.addTabSpace();
        editorr.addText("Indented text after a tab space.");
        editorr.addNewLine();

        // Render and display the final document.
        System.out.println(editorr.renderDocs());
        editorr.saveDocument();
    }
}
