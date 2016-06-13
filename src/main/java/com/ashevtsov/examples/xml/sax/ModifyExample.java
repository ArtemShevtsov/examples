package com.ashevtsov.examples.xml.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.ashevtsov.examples.xml.sax.handlers.ModifyHandler;
import org.xml.sax.SAXException;

/**
 * Created by Artem_Shevtsov on 6/2/2016.
 */
public class ModifyExample {
    private File inputFile;
    private File outputFile;

    public static void main(String[] args) {
        ModifyExample modifyExample = new ModifyExample();
        modifyExample.setInputFile(new File("resources/parser_example.xml"));
        modifyExample.setOutputFile(new File("resources/modified_example.xml"));

        modifyExample.runModifyExample();
    }

    private void runModifyExample(){
        try(FileWriter fileWriter = new FileWriter(outputFile)) {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            ModifyHandler modifyHandler = new ModifyHandler();
            saxParser.parse(inputFile, modifyHandler);

            int numberLines = modifyHandler.getNumberLines();
            String[] displayText = modifyHandler.getDisplayText();

            for(int i = 0; i <= numberLines; i++){
                fileWriter.write(displayText[i]);
                fileWriter.write('\n');
                System.out.println(displayText[i]);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }
}
